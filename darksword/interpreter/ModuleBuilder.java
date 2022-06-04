package darksword.interpreter;

import darksword.console.Config;
import darksword.console.display.RowMark;
import darksword.interpreter.error.InternalError;
import darksword.interpreter.generated.LLVMIRBaseVisitor;
import darksword.interpreter.generated.LLVMIRLexer;
import darksword.interpreter.generated.LLVMIRParser;
import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.share.error.ParseErrorListener;
import masterball.compiler.share.lang.LLVM;
import masterball.debug.Log;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Objects;

public class ModuleBuilder extends LLVMIRBaseVisitor<Value> {

    // this is used to handle forward reference
    private static class RawOnlyName extends Value {
        public static ArrayList<RawOnlyName> workList = new ArrayList<>();

        public RawOnlyName(String name) {
            super(name, null);
            workList.add(this);
        }
    }

    private final LinkedHashMap<IRBlock, LLVMIRParser.BasicBlockContext> blockCtx = new LinkedHashMap<>();

    public IRModule irModule = new IRModule();

    public final LinkedHashMap<String, Value> valueMap = new LinkedHashMap<>();

    public LinkedHashMap<Value, RowMark> rowMarker = new LinkedHashMap<>();

    public ModuleBuilder() throws IOException {
        // lexer
        LLVMIRLexer irLexer = new LLVMIRLexer(CharStreams.fromStream(
                (InputStream) Config.getArgValue(Config.Option.Input)
        ));
        irLexer.removeErrorListeners();
        irLexer.addErrorListener(new ParseErrorListener());

        // parser
        LLVMIRParser irParser = new LLVMIRParser(new CommonTokenStream(irLexer));
        irParser.removeErrorListeners();
        irParser.addErrorListener(new ParseErrorListener());

        irModule.setBottomFunctions();
        visit(irParser.rootLLVMIR());

        // clear onlyName
        for (RawOnlyName onlyName : RawOnlyName.workList) {
            var userList = new ArrayList<>(onlyName.users);
            for (User user : userList) {
                user.resetOperand(user.operands.indexOf(onlyName), valueMap.get(onlyName.name));
            }
        }

        Log.info("Build Module finish from .ll file.");
    }

    private Value newValue(String name, IRBaseType type) {
        if (valueMap.get(name) != null) return valueMap.get(name);
        Value ret = new Value(name, type);
        valueMap.put(name, ret);
        return ret;
    }

    private void setNewValue(String name, Value value) {
        value.name = name;
        valueMap.put(name, value);
    }

    private IRBaseType translateType(LLVMIRParser.TypeContext ctx) {
        if (ctx.pointer != null) {
            return new PointerType(translateType(ctx.type()));
        }

        if (ctx.basicType() != null) {
            if (ctx.basicType().IntType() != null) {
                int bitWidth = Integer.parseInt(ctx.basicType().IntType().getText().substring(1));  // emit 'i'
                if (bitWidth == 1) return new BoolType();
                else if (bitWidth == 8) return new MemBoolType();

                return new IntType(bitWidth);
            }
            else if (ctx.basicType().VoidType() != null) {
                return new VoidType();
            }
            else if (ctx.basicType().LabelType() != null) {
                return new LabelType();
            }
            else if (ctx.basicType().LocalReg() != null) {
                return valueMap.get(ctx.basicType().LocalReg().getText().substring(1 + LLVM.StructPrefix.length())).type;
            }
        }

        assert ctx.arrayType() != null;
        return new ArrayType(translateType(ctx.arrayType().type()), Integer.parseInt(ctx.arrayType().arrayLen.getText()));
    }

    private Value regToValue(TerminalNode reg) {
        String name = reg.getText().substring(1);
        if (valueMap.get(name) == null) {
            return new RawOnlyName(name);
        }
        return valueMap.get(name);
    }

    @Override
    public Value visitRootLLVMIR(LLVMIRParser.RootLLVMIRContext ctx) {
        // classes
        for (var classDecl : ctx.classDecl()) {
            StructType classType = new StructType(classDecl.LocalReg().getText().substring(1 + LLVM.StructPrefix.length()));
            irModule.classes.add(classType.structProto);
            setNewValue(classType.structName, classType.structProto);
        }
        for (var classDecl : ctx.classDecl()) {
            visit(classDecl);
        }

        // functions
        for (var funcDecl : ctx.funcDecl()) {
            irModule.builtinFunctions.add((IRFunction) visit(funcDecl));
        }

        for (var funcDef : ctx.funcDef()) {
            irModule.functions.add((IRFunction) visit(funcDef));
        }

        // global & string
        for (var globalDecl : ctx.globalDecl()) {
            if (Objects.equals(globalDecl.GlobalWord().getText(), "constant")) {
                // only string constant
                irModule.stringConstSeg.add((StringConst) visit(globalDecl));
            }
            else {
                irModule.globalVarSeg.add((GlobalVariable) visit(globalDecl));
            }
        }

        // start
        for (var funcDef : ctx.funcDef()) {
            deepToInst(funcDef);
        }

        return null;
    }

    // this part is a Symbol Collector.
    // They will not go to instructions.

    @Override
    public Value visitGlobalDecl(LLVMIRParser.GlobalDeclContext ctx) {
        String glbName = ctx.GlobalReg().getText().substring(1);

        if (Objects.equals(ctx.GlobalWord().getText(), "constant")) {
            assert ctx.initExp() != null;
            assert ctx.initExp().atom() != null;
            StringConst strCst = (StringConst) visit(ctx.initExp().atom());
            setNewValue(glbName, strCst);
            return strCst;
        }

        GlobalVariable glbVar = new GlobalVariable(glbName, translateType(ctx.type()));
        if (ctx.initExp() != null) {
            if (ctx.initExp().atom() != null)
                glbVar.initValue = visit(ctx.initExp().atom());
            else {
                // zero initializer
                glbVar.initValue = null;
            }
        }
        setNewValue(glbName, glbVar);
        return glbVar;
    }

    @Override
    public Value visitFuncInfo(LLVMIRParser.FuncInfoContext ctx) {
        String funcName = ctx.GlobalReg().getText().substring(1); // emit @

        IRBaseType retType = translateType(ctx.type(0));

        // use bottom function constructor
        // "method" is unnecessary to concern
        var function = new IRFunction(funcName, retType);

        for (int i = 1; i < ctx.type().size(); ++i) {
            String name = funcName + ".anon_arg" + i;
            if (ctx.LocalReg(i-1) != null) {
                name = ctx.LocalReg(i-1).getText().substring(1);
            }
            IRBaseType argType = translateType(ctx.type(i));
            ((IRFuncType) function.type).argTypes.add(argType);
            function.addArg(newValue(name, argType));
        }

        setNewValue(funcName, function);
        return function;
    }

    @Override
    public Value visitFuncDecl(LLVMIRParser.FuncDeclContext ctx) {
        return visit(ctx.funcInfo());
    }

    @Override
    public Value visitFuncDef(LLVMIRParser.FuncDefContext ctx) {
        IRFunction function = (IRFunction) visit(ctx.funcInfo());

        for (var blockCtx : ctx.basicBlock()) {
            IRBlock block = (IRBlock) visit(blockCtx);
            block.parentFunction = function;
            if (function.entryBlock == null) {
                function.entryBlock = block;
            }
            function.blocks.add(block);
        }

        return function;
    }

    @Override
    public Value visitClassDecl(LLVMIRParser.ClassDeclContext ctx) {
        StructType classType = (StructType) valueMap.get(ctx.LocalReg().getText().substring(1 + LLVM.StructPrefix.length())).type;

        for (var memberTypeCtx : ctx.type()) {
            classType.memberVarTypes.add(translateType(memberTypeCtx));
        }

        return classType.structProto;
    }

    @Override
    public Value visitBasicBlock(LLVMIRParser.BasicBlockContext ctx) {
        IRBlock block = new IRBlock(ctx.Identifier().getText(), null);
        setNewValue(block.name, block);
        blockCtx.put(block, ctx);
        return block;
    }

    // this part is instructions
    // CFG order!

    private void deepToInst(LLVMIRParser.FuncDefContext ctx) {
        HashSet<IRBlock> visited = new HashSet<>();

        for (int i = 0; i < ctx.basicBlock().size(); ++i) {
            deepToInst(ctx.basicBlock().get(i), visited);
        }
    }

    private void deepToInst(LLVMIRParser.BasicBlockContext ctx, HashSet<IRBlock> visited) {
        IRBlock block = (IRBlock) valueMap.get(ctx.Identifier().getText());

        if (visited.contains(block)) return;
        visited.add(block);

        for (var instCtx : ctx.instruction()) {
            IRBaseInst inst = (IRBaseInst) visit(instCtx);
            inst.setParentBlock(block);
            rowMarker.put(inst, new RowMark(instCtx.getStart().getLine(), inst.format()));
        }

        if (block.terminator() instanceof IRBrInst) {
            if (((IRBrInst) block.terminator()).isJump()) {
                deepToInst(blockCtx.get(((IRBrInst) block.terminator()).destBlock()), visited);
            } else {
                deepToInst(blockCtx.get(((IRBrInst) block.terminator()).ifTrueBlock()), visited);
                deepToInst(blockCtx.get(((IRBrInst) block.terminator()).ifFalseBlock()), visited);
            }
        }
        else if (block.terminator() instanceof IRRetInst) {
            block.parentFunction.exitBlock = block;
        }
    }

    @Override
    public Value visitAlloca(LLVMIRParser.AllocaContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        IRAllocaInst inst =  new IRAllocaInst(
                destName,
               translateType(ctx.type()),
               null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitBinary(LLVMIRParser.BinaryContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);
        String op = ctx.binaryOp().getText();

        IRBinaryInst inst =  new IRBinaryInst(
                op,
                translateType(ctx.type()),
                visit(ctx.lsrc),
                visit(ctx.rsrc),
                null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitBitcast(LLVMIRParser.BitcastContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        IRBitCastInst inst = new IRBitCastInst(
                visit(ctx.src),
                translateType(ctx.type(1)),
                null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitTrunc(LLVMIRParser.TruncContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        IRTruncInst inst = new IRTruncInst(
                visit(ctx.src),
                translateType(ctx.type(1)),
                null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitZext(LLVMIRParser.ZextContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        IRZextInst inst = new IRZextInst(
                visit(ctx.src),
                translateType(ctx.type(1)),
                null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitBr(LLVMIRParser.BrContext ctx) {
        if (ctx.src != null) {
            return new IRBrInst(
                    visit(ctx.src),
                    (IRBlock) visit(ctx.atom(1)),
                    (IRBlock) visit(ctx.atom(2)),
                    null
            );
        }
        return new IRBrInst((IRBlock) visit(ctx.atom(0)), null);
    }

    @Override
    public Value visitCall(LLVMIRParser.CallContext ctx) {
        ArrayList<Value> argsValue = new ArrayList<>();
        for (var arg : ctx.funcCall().atom())
            argsValue.add(visit(arg));

        IRCallInst inst = new IRCallInst((IRFunction) regToValue(ctx.funcCall().GlobalReg()), null, argsValue);

        if (ctx.instDest() != null) {
            setNewValue(ctx.instDest().LocalReg().getText().substring(1), inst);
        }

        return inst;
    }

    @Override
    public Value visitGetelementptr(LLVMIRParser.GetelementptrContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        ArrayList<Value> indices = new ArrayList<>();

        for (var offsetCtx : ctx.gepOffset())
            indices.add(visit(offsetCtx.atom()));

        IRGetElementPtrInst inst = new IRGetElementPtrInst(visit(ctx.src), null, null, indices);
        inst.type = inst.headPointer().type;
        for (int i = 0; i < inst.indicesNum(); ++i) {
            if (i == 0) { // the first index always indexes the pointer
                assert inst.type instanceof PointerType;
                inst.type = ((PointerType) inst.type).pointedType;
            }
            else {
                if (inst.type instanceof StructType) {
                    inst.type = ((StructType) inst.type).memberVarTypes.get(((IntConst) indices.get(i)).constData);
                }
                else if (inst.type instanceof ArrayType) {
                    inst.type = ((ArrayType) inst.type).elementType;
                }
                else {
                    throw new InternalError("getelementptr in other types");
                }
            }
        }

        // wrapped
        inst.type = new PointerType(inst.type);

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitIcmp(LLVMIRParser.IcmpContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);
        String op = ctx.cmpOp().getText();

        IRICmpInst inst =  new IRICmpInst(
                op,
                visit(ctx.lsrc),
                visit(ctx.rsrc),
                null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitLoad(LLVMIRParser.LoadContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        IRLoadInst inst =  new IRLoadInst(
            visit(ctx.atom()),
            null
        );

        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitStore(LLVMIRParser.StoreContext ctx) {
        return new IRStoreInst(visit(ctx.atom(1)), visit(ctx.atom(0)), null);
    }

    @Override
    public Value visitRet(LLVMIRParser.RetContext ctx) {
        if (ctx.atom() != null) {
            return new IRRetInst(visit(ctx.atom()), null);
        }
        return new IRRetInst(null);
    }

    @Override
    public Value visitPhi(LLVMIRParser.PhiContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);
        IRPhiInst inst = new IRPhiInst(translateType(ctx.type()), null);

        for (var phi : ctx.phiBranch()) {
            inst.addBranch(visit(phi.atom(0)), (IRBlock) visit(phi.atom(1)));
        }
        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitAtom(LLVMIRParser.AtomContext ctx) {
        if (ctx.GlobalReg() != null) {
            return regToValue(ctx.GlobalReg());
        }
        else if (ctx.LocalReg() != null) {
            return regToValue(ctx.LocalReg());
        }
        else if (ctx.integerConstant() != null) {
            return new IntConst(Integer.parseInt(ctx.integerConstant().getText()));
        }
        else if (ctx.StringConstant() != null) {
            String rawString =  ctx.StringConstant().toString();
            return new StringConst(
                    rawString.substring(2, rawString.length()-1) // filter： c" "
                            .replace("\\5C", "\\")
                            .replace("\\0A", "\n")
                            .replace("\\00", "\0")
                            .replace("\\09", "\t")
                            .replace("\\22", "\"")
            );
        }
        else if (ctx.BoolConstant() != null) {
            return new BoolConst(Objects.equals(ctx.BoolConstant().getText(), "true"));
        }

        assert ctx.NullptrConstant() != null;
        return new NullptrConst();
    }
}
