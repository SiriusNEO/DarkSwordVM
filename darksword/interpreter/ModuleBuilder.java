package darksword.interpreter;

import darksword.interpreter.display.RowMark;
import darksword.interpreter.generated.LLVMIRBaseVisitor;
import masterball.compiler.middleend.llvmir.User;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.*;
import masterball.compiler.middleend.llvmir.type.*;
import masterball.compiler.share.error.ParseErrorListener;
import masterball.console.Config;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import darksword.interpreter.generated.LLVMIRLexer;
import darksword.interpreter.generated.LLVMIRParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
            for (User user : onlyName.users) {
                user.resetOperand(user.operands.indexOf(onlyName), valueMap.get(onlyName.name));
            }
        }
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
                return new StructType(ctx.basicType().LocalReg().getText().substring(1));
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
        // functions
        for (var funcDef : ctx.funcDef()) {
            irModule.functions.add((IRFunction) visit(funcDef));
        }

        // global
        for (var globalDecl : ctx.globalDecl()) {
            irModule.globalVarSeg.add((GlobalVariable) visit(globalDecl));
        }

        // strings

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
    public Value visitFuncDecl(LLVMIRParser.FuncDeclContext ctx) {
        return null;
    }

    @Override
    public Value visitFuncDef(LLVMIRParser.FuncDefContext ctx) {
        String funcName = ctx.funcHeader().GlobalReg().getText().substring(1); // emit @

        // TODO: if this is a method

        IRBaseType retType = translateType(ctx.type());

        // use bottom function constructor
        var function = new IRFunction(funcName, retType);

        for (int i = 0; i < ctx.funcHeader().type().size(); ++i) {
            function.addArg(newValue(ctx.funcHeader().LocalReg(i).getText().substring(1),
                    translateType(ctx.funcHeader().type(i))
            ));
        }

        for (var blockCtx : ctx.basicBlock()) {
            IRBlock block = (IRBlock) visit(blockCtx);
            block.parentFunction = function;
            if (function.entryBlock == null) {
                function.entryBlock = block;
            }
            function.blocks.add(block);
        }

        setNewValue(funcName, function);
        return function;
    }

    @Override
    public Value visitBasicBlock(LLVMIRParser.BasicBlockContext ctx) {
        IRBlock block = new IRBlock(ctx.Identifier().getText(), null);
        setNewValue(block.name, block);
        return block;
    }

    // this part is instructions

    public void deepToInst(LLVMIRParser.FuncDefContext ctx) {
        for (int i = 0; i < ctx.basicBlock().size(); ++i) {
            for (var instCtx : ctx.basicBlock(i).instruction()) {
                IRBaseInst inst = (IRBaseInst) visit(instCtx);
                inst.setParentBlock((IRBlock) valueMap.get(ctx.basicBlock(i).Identifier().getText()));
                rowMarker.put(inst, new RowMark(instCtx.getStart().getLine(), inst.format()));
            }
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
        String op = ctx.binaryOp.getText();

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
        String calledFn = ctx.funcHeader().GlobalReg().getText().substring(1);

        ArrayList<Value> argsValue = new ArrayList<>();
        for (var localReg : ctx.funcHeader().LocalReg())
            argsValue.add(regToValue(localReg));

        IRCallInst inst = new IRCallInst((IRFunction) regToValue(ctx.funcHeader().GlobalReg()), null, argsValue);

        if (ctx.instDest() != null) {
            setNewValue(calledFn, inst);
        }

        return inst;
    }

    @Override
    public Value visitGetelementptr(LLVMIRParser.GetelementptrContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);

        ArrayList<Value> indices = new ArrayList<>();

        for (var offsetCtx : ctx.gepOffset())
            indices.add(visit(offsetCtx.atom()));

        IRGetElementPtrInst inst = new IRGetElementPtrInst(visit(ctx.src), translateType(ctx.type(1)), null, indices);
        setNewValue(destName, inst);
        return inst;
    }

    @Override
    public Value visitIcmp(LLVMIRParser.IcmpContext ctx) {
        String destName = ctx.instDest().LocalReg().getText().substring(1);
        String op = ctx.cmpOp.getText();

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
        return null;
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
        else if (ctx.stringConstant() != null) {
            String rawString =  ctx.stringConstant().toString();
            return new StringConst(
                    rawString.substring(1, rawString.length()-1) // quote filter
                            .replace("\\\"","\"")
                            .replace("\\n","\n")
                            .replace("\\t","\t")
                            .replace("\\\\","\\")
            );
        }
        else if (ctx.BoolConstant() != null) {
            return new BoolConst(Objects.equals(ctx.BoolConstant().getText(), "true"));
        }

        assert ctx.NullptrConstant() != null;
        return new NullptrConst();
    }
}
