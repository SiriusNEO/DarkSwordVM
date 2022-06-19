package darksword.interpreter;

import darksword.console.Console;
import darksword.console.display.Displayer;
import darksword.interpreter.error.InternalError;
import darksword.interpreter.error.ZeroDivisionError;
import darksword.jit.CodeGenerator;
import darksword.jit.JITCompiler;
import darksword.jit.JITScheduler;
import darksword.jit.FuncProfiler;
import darksword.ravel.RavelControl;
import masterball.compiler.backend.rvasm.AsmBuilder;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.ArrayType;
import masterball.compiler.middleend.llvmir.type.IRBaseType;
import masterball.compiler.middleend.llvmir.type.PointerType;
import masterball.compiler.middleend.llvmir.type.StructType;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.pass.InstVisitor;
import masterball.debug.Log;
import masterball.debug.Statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Interpreter implements InstVisitor {

    private final Machine machine;
    private final ModuleBuilder runningBuilder;

    private final FuncProfiler profiler;
    private final JITCompiler compiler;
    private final JITScheduler scheduler;
    private final CodeGenerator generator;

    public Interpreter(Console console) throws IOException {
        runningBuilder = new ModuleBuilder();
        machine = new Machine(runningBuilder.irModule);
        new AsmBuilder().buildModuleSkeleton(runningBuilder.irModule); // give running IR some asmOperands...

        if (console.jitMode) {
            profiler = new FuncProfiler(runningBuilder.irModule);
            compiler = new JITCompiler();
            scheduler = new JITScheduler();
            generator = new CodeGenerator(runningBuilder.irModule, machine);
            RavelControl.connect("Hello, ravel");
            Log.info("Test ravel connection finish. Interpreter ready.");
        }
        else {
            profiler = null;
            compiler = null;
            scheduler = null;
            generator = null;
            Log.info("Interpreter ready.");
        }
    }

    // interpret curBlock
    // change the cursor

    public void interpret() {
        IRCallInst exitCode = new IRCallInst(machine.curBlock.parentFunction, null); // just a pseudo "call main"
        machine.runStack.push(new Machine.StackLayer(exitCode, -1, null)); // sp == -1: terminated

        while (machine.cursor >= 0) {
            IRBaseInst curInst;
            if (machine.cursor < machine.curBlock.phiInsts.size()) {
                curInst = machine.curBlock.phiInsts.get(machine.cursor);
            }
            else {
                curInst = machine.curBlock.instructions.get(machine.cursor - machine.curBlock.phiInsts.size());
            }
            // Displayer.interpretRow(runningBuilder.rowMarker.get(curInst));

            boolean invokeRavel = false;

            // call others
            if (profiler != null) {
                if (curInst instanceof IRCallInst) {
                    if (runningBuilder.irModule.functions.contains(((IRCallInst) curInst).callFunc())) {
                        if (profiler.isCompiled(((IRCallInst) curInst).callFunc())) {
                            invokeRavel = true;
                        } else {
                            profiler.funcInterpretedSubmit(((IRCallInst) curInst).callFunc());
                        }
                    }
                }
            }

            if (invokeRavel) {
                IRFunction callFunc = ((IRCallInst) curInst).callFunc();
                var dependencies = profiler.dependencyAnalysis(callFunc);
                var dirtyGlobal = profiler.dirtyGlobalAnalysis(callFunc);

                boolean linkLib = false;
                for (var dependency : dependencies) {
                    linkLib = profiler.hasLibcCall.contains(dependency);
                    if (linkLib) break;
                }

                // Log.info("ravel call:", callFunc.identifier());

                int ravelRunningTime = machine.callRavel(
                        (IRCallInst) curInst,
                        generator.getGeneratedCode(callFunc, dependencies, dirtyGlobal),
                        generator.getCompiledFunc(callFunc),
                        dirtyGlobal,
                        linkLib
                );
                Statistics.plus("ravel", ravelRunningTime);
                machine.regWrite(curInst, machine.regs[10]); // a0
                machine.cursor++;
            }
            else {
                curInst.accept(this);
            }

            if (scheduler != null && scheduler.signal()) {
                assert profiler != null;
                IRFunction hottest = profiler.hotSelect();
                if (hottest != null) {
                    Log.info("hot function compiling:", hottest.identifier());
                    AsmFunction compiledFunc = compiler.compile(hottest.name);
                    profiler.funcCompiledSubmit(hottest);
                    generator.runOnFunc(compiledFunc);
                    generator.setRCMap(hottest, compiledFunc);
                    scheduler.acknowledged();
                    // Log.info(generator.getGeneratedCode(hottest, profiler.dependencyAnalysis(hottest), profiler.dirtyGlobalAnalysis(hottest)));
                }
            }
        }
        Displayer.interpretFinish(machine.regRead(exitCode) & 0xffff); // 0xffff

        /*
        for (var entry : generator.codeStorage.entrySet()) {
            Log.info("[compiled code]", entry.getKey().identifier);
            Log.info(entry.getValue());
        }
        */
    }

    @Override
    public void visit(IRAllocaInst inst) {
        machine.regWrite(inst, machine.alloc(inst.allocaType.size()));
        machine.cursor++;
    }

    @Override
    public void visit(IRBinaryInst inst) {
        int result, lhsNum = machine.regRead(inst.lhs()), rhsNum = machine.regRead(inst.rhs());

        switch (inst.op) {
            case LLVM.AddInst: result = lhsNum + rhsNum; break;
            case LLVM.SubInst: result = lhsNum - rhsNum; break;
            case LLVM.MulInst: result = lhsNum * rhsNum; break;
            case LLVM.DivInst:
                if (rhsNum == 0) {
                    throw new ZeroDivisionError();
                }
                else result = lhsNum / rhsNum;
                break;
            case LLVM.ModInst:
                if (rhsNum == 0) {
                    throw new ZeroDivisionError();
                }
                else result = lhsNum % rhsNum;
                break;
            case LLVM.AndInst: result = lhsNum & rhsNum; break;
            case LLVM.OrInst: result = lhsNum | rhsNum; break;
            case LLVM.XorInst: result = lhsNum ^ rhsNum; break;
            case LLVM.ShiftLeftInst: result = lhsNum << rhsNum; break;
            case LLVM.ShiftRightInst: result = lhsNum >> rhsNum; break;
            default:
                throw new InternalError("binary interpretation error");
        }

        machine.regWrite(inst, result);
        machine.cursor++;
    }

    @Override
    public void visit(IRBitCastInst inst) {
        machine.regWrite(inst, machine.regRead(inst.fromValue()));
        machine.cursor++;
    }

    @Override
    public void visit(IRBrInst inst) {
        machine.lastBlock = machine.curBlock;

        if (inst.isJump()) {
            machine.curBlock = inst.destBlock();
        }
        else {
            int cond = machine.regRead(inst.condition());
            if (cond == 1) {
                machine.curBlock = inst.ifTrueBlock();
            } else if (cond == 0) {
                machine.curBlock = inst.ifFalseBlock();
            } else {
                throw new InternalError("interpret branch: invalid condition");
            }
        }

        machine.cursor = 0;
    }

    @Override
    public void visit(IRCallInst inst) {
        if (runningBuilder.irModule.builtinFunctions.contains(inst.callFunc())) {
            Integer ret = null;
            ArrayList<Integer> args = new ArrayList<>();

            for (int i = 0; i < inst.callFunc().getArgNum(); i++) {
                args.add(machine.regRead(inst.getArg(i)));
            }

            switch (inst.callFunc().name) {
                case "_bot_malloc":
                    ret = machine.libcMalloc(args.get(0)); break;
                case "_bot_str_cat":
                    ret = machine.libcStrCat(args.get(0), args.get(1)); break;
                case "_bot_str_eq":
                    ret = machine.libcStrEq(args.get(0), args.get(1)) ? 1 : 0; break;
                case "_bot_str_ne":
                    ret = machine.libcStrNe(args.get(0), args.get(1)) ? 1 : 0; break;
                case "_bot_str_slt":
                    ret = machine.libcStrSlt(args.get(0), args.get(1)) ? 1 : 0; break;
                case "_bot_str_sle":
                    ret = machine.libcStrSle(args.get(0), args.get(1)) ? 1 : 0; break;
                case "_bot_str_sgt":
                    ret = machine.libcStrSgt(args.get(0), args.get(1)) ? 1 : 0; break;
                case "_bot_str_sge":
                    ret = machine.libcStrSge(args.get(0), args.get(1)) ? 1 : 0; break;
                case "print":
                    machine.libcPrint(args.get(0)); break;
                case "println":
                    machine.libcPrintln(args.get(0)); break;
                case "printInt":
                    machine.libcPrintInt(args.get(0)); break;
                case "printlnInt":
                    machine.libcPrintlnInt(args.get(0)); break;
                case "getString":
                    ret = machine.libcGetString(); break;
                case "getInt":
                    ret = machine.libcGetInt(); break;
                case "toString":
                    ret = machine.libcToString(args.get(0)); break;
                case "_str_length":
                    ret = machine.libcStrLength(args.get(0)); break;
                case "_str_substring":
                    ret = machine.libcStrSubstring(args.get(0), args.get(1), args.get(2)); break;
                case "_str_parseInt":
                    ret = machine.libcStrParseInt(args.get(0)); break;
                case "_str_ord":
                    ret = machine.libcStrOrd(args.get(0), args.get(1)); break;
                default:
                    throw new InternalError("interpret libc call: unknown libc func.");
            }

            if (ret != null)
                machine.regWrite(inst, ret);

            machine.cursor++;
            return;
        }

        ArrayList<Integer> args = new ArrayList<>();
        // read in current scope
        for (int i = 0; i < inst.callFunc().getArgNum(); i++) {
            args.add(machine.regRead(inst.getArg(i)));
        }


        // new Layer
        machine.runStack.push(new Machine.StackLayer(inst, machine.curBlock.instructions.indexOf(inst) + 1, machine.lastBlock));

        // argument load. write in new scope
        for (int i = 0; i < inst.callFunc().getArgNum(); i++) {
            machine.regWrite(inst.callFunc().getArg(i), args.get(i));
        }

        machine.lastBlock = machine.curBlock;
        machine.curBlock = inst.callFunc().entryBlock;

        machine.cursor = 0;
    }

    @Override
    public void visit(IRGetElementPtrInst inst) {
        int totalOff = 0;
        IRBaseType curType = inst.headPointer().type;

        for (int i = 0; i < inst.indicesNum(); ++i) {
            int index = machine.regRead(inst.getIndex(i));
            if (i == 0) { // the first index always indexes the pointer
                assert curType instanceof PointerType;
                totalOff += index * ((PointerType) curType).pointedType.size();
                curType = ((PointerType) curType).pointedType;
            }
            else {
                if (curType instanceof StructType) {
                    totalOff += ((StructType) curType).memberOffset(index);
                    curType = ((StructType) curType).memberVarTypes.get(index);
                }
                else if (curType instanceof ArrayType) {
                    totalOff += index * ((ArrayType) curType).elementType.size();
                    curType = ((ArrayType) curType).elementType;
                }
                else {
                    throw new InternalError("getelementptr in other types");
                }
            }
        }

        machine.regWrite(inst, machine.regRead(inst.headPointer()) + totalOff);

        machine.cursor++;
    }

    @Override
    public void visit(IRICmpInst inst) {
        boolean result;
        int lhsNum = machine.regRead(inst.lhs()), rhsNum = machine.regRead(inst.rhs());

        switch (inst.op) {
            case LLVM.LessArg: result = lhsNum < rhsNum; break;
            case LLVM.LessEqualArg: result = lhsNum <= rhsNum; break;
            case LLVM.GreaterArg: result = lhsNum > rhsNum; break;
            case LLVM.GreaterEqualArg: result = lhsNum >= rhsNum; break;
            case LLVM.EqualArg: result = lhsNum == rhsNum; break;
            case LLVM.NotEqualArg: result = lhsNum != rhsNum; break;
            default:
                throw new InternalError("icmp interpretation error");
        }

        machine.regWrite(inst, result ? 1 : 0);
        machine.cursor++;
    }

    @Override
    public void visit(IRLoadInst inst) {
        int addr = machine.regRead(inst.loadPtr()), size = inst.type.size();
        if (size > 4) {
            throw new InternalError("mem op at most 4 bytes");
        }
        machine.regWrite(inst, machine.loadBySize(addr, size));
        machine.cursor++;
    }

    @Override
    public void visit(IRPhiInst inst) {
        for (int i = 0; i < inst.operandSize(); i += 2) {
            if (inst.getOperand(i+1) == machine.lastBlock) {
                machine.regWrite(inst, machine.regRead(inst.getOperand(i)));
                machine.cursor++;
                return;
            }
        }

        throw new InternalError("non-existent phi branch");
    }

    @Override
    public void visit(IRRetInst inst) {
        IRCallInst call = (IRCallInst) machine.runStack.peek().retVal;

        int ret = 0;
        // read in current scope
        if (!inst.isVoid()) ret = machine.regRead(inst.retVal());

        machine.lastBlock = machine.runStack.peek().lastBlock;
        machine.curBlock = call.parentBlock;
        machine.cursor = machine.runStack.peek().retAddr;

        machine.releaseStack();
        if(machine.runStack.size() > 1) machine.runStack.pop(); // do not pop last layer
        // in last scope: write
        if (!inst.isVoid()) machine.regWrite(call, ret);
    }

    @Override
    public void visit(IRStoreInst inst) {
        int addr = machine.regRead(inst.storePtr()),
            size = inst.type.size(),
            storeData = machine.regRead(inst.storeValue());

        if (size > 4) {
            throw new InternalError("mem op at most 4 bytes");
        }
        machine.storeBySize(addr, storeData, size);
        machine.cursor++;
    }

    @Override
    public void visit(IRTruncInst inst) {
        machine.regWrite(inst, machine.regRead(inst.fromValue()));
        machine.cursor++;
    }

    @Override
    public void visit(IRZextInst inst) {
        machine.regWrite(inst, machine.regRead(inst.fromValue()));
        machine.cursor++;
    }

    @Override
    public void visit(IRMoveInst inst) {
        throw new InternalError("try to interpret move");
    }
}
