package darksword.interpreter;

import darksword.interpreter.display.Displayer;
import darksword.interpreter.error.ZeroDivisionError;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.share.error.runtime.InternalError;
import masterball.compiler.share.error.runtime.UnimplementedError;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;
import masterball.compiler.share.pass.InstVisitor;
import masterball.debug.Log;

import java.io.IOException;
import java.util.Objects;

public class Interpreter implements InstVisitor {

    private final Machine machine;
    private final ModuleBuilder builder;

    public Interpreter() throws IOException {
        builder = new ModuleBuilder();
        Log.info("Build finish from .ll file.");

        machine = new Machine(builder.irModule);
        Log.info("Virtual machine booted. Able to interpret now.");
    }

    // interpret curBlock
    // change the cursor

    public void interpret() {
        IRCallInst exitCode = new IRCallInst(machine.curBlock.parentFunction, null); // just a pseudo "call main"
        machine.retValStack.push(exitCode);
        machine.retAddrStack.push(-1); // sp == -1: terminated

        while (machine.sp >= 0) {
            IRBaseInst curInst = machine.curBlock.instructions.get(machine.sp);
            Displayer.interpretRow(builder.rowMarker.get(curInst));
            curInst.accept(this);
        }
        Displayer.interpretFinish(machine.regRead(exitCode));
    }

    @Override
    public void visit(IRAllocaInst inst) {
        machine.regWrite(inst, machine.alloc(inst.allocaType.size()));
        machine.sp = machine.sp + 1;
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
        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRBitCastInst inst) {
        machine.regWrite(inst, machine.regRead(inst.fromValue()));
        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRBrInst inst) {
        if (inst.isJump()) {
            machine.curBlock = inst.destBlock();
        }
        else {
            int cond = machine.regRead(inst.condition());
            if (cond == 1) {
                machine.lastBlock = machine.curBlock;
                machine.curBlock = inst.ifTrueBlock();
            } else if (cond == 0) {
                machine.lastBlock = machine.curBlock;
                machine.curBlock = inst.ifFalseBlock();
            } else {
                throw new InternalError("interpret branch: invalid condition");
            }
        }

        machine.sp = 0;
    }

    @Override
    public void visit(IRCallInst inst) {
        // argument load
        for (int i = 0; i < inst.callFunc().getArgNum(); i++) {
            machine.regWrite(inst.callFunc().getArg(i),
                    machine.regRead(inst.getArg(i))
                );
        }

        machine.retValStack.push(inst);
        machine.retAddrStack.push(machine.curBlock.instructions.indexOf(inst) + 1);

        machine.lastBlock = machine.curBlock;
        machine.curBlock = inst.callFunc().entryBlock;

        machine.sp = 0;
    }

    @Override
    public void visit(IRGetElementPtrInst inst) {
        // TODO
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
        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRLoadInst inst) {
        int addr = machine.regRead(inst.loadPtr()), size = inst.type.size(), loadData = 0;
        if (size > 4) {
            throw new UnimplementedError(inst);
        }
        for (int i = 0; i < size; ++i) {
            // Big-Endian load
            loadData = (loadData << 8) + machine.load(addr);
            addr++;
        }
        machine.regWrite(inst, loadData);
        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRPhiInst inst) {
        // TODO
    }

    @Override
    public void visit(IRRetInst inst) {
        IRCallInst call = (IRCallInst) machine.retValStack.peek();

        if (!inst.isVoid()) {
            machine.regWrite(call, machine.regRead(inst.retVal()));
        }

        machine.lastBlock = machine.curBlock;
        machine.curBlock = call.parentBlock;
        machine.sp = machine.retAddrStack.peek();

        machine.retValStack.pop();
        machine.retAddrStack.pop();
    }

    @Override
    public void visit(IRStoreInst inst) {
        int addr = machine.regRead(inst.storePtr()),
            size = inst.type.size(),
            storeData = machine.regRead(inst.storeValue());

        if (size > 4) {
            throw new UnimplementedError(inst);
        }

        for (int i = 0; i < size; ++i) {
            // Big-Endian store
            machine.store(addr, (byte) (storeData >> 8*(3-i) & 0xff));
            addr++;
        }

        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRTruncInst inst) {
        machine.regWrite(inst, machine.regRead(inst.fromValue()));
        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRZextInst inst) {
        machine.regWrite(inst, machine.regRead(inst.fromValue()));
        machine.sp = machine.sp + 1;
    }

    @Override
    public void visit(IRMoveInst inst) {
        throw new InternalError("try to interpret move");
    }
}
