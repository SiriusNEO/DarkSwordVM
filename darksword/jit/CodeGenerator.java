package darksword.jit;

import darksword.interpreter.Machine;
import darksword.interpreter.error.InternalError;
import masterball.compiler.backend.rvasm.AsmFormatter;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmCallInst;
import masterball.compiler.backend.rvasm.operand.GlobalReg;
import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.share.pass.AsmBlockPass;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class CodeGenerator implements AsmFuncPass, AsmBlockPass {

    private final static String TAB = "\t";
    private final static String NAME_REPLACE = "__internal__replace__";
    private final static String WORD_LINE = TAB + ".word" + TAB;

    private final Machine runningMachine;
    private String code;

    private final HashMap<GlobalValue, String> globalInfo;

    private final HashMap<IRFunction, AsmFunction> runningIR2CompiledAsm;
    private final HashMap<AsmFunction, String> codeStorage;

    private AsmFunction curAsmFunc;

    public CodeGenerator(IRModule module, Machine runningMachine) {
        this.runningMachine = runningMachine; // runtime info
        this.codeStorage = new HashMap<>();
        this.globalInfo = new HashMap<>();
        this.runningIR2CompiledAsm = new HashMap<>();

        module.globalVarSeg.forEach(globalVar -> {
            var glbFormat = AsmFormatter.globalVariableFormat((GlobalReg) globalVar.asmOperand);
            StringBuilder buf = new StringBuilder();
            for (var line : glbFormat) {
                if (Objects.equals(line, WORD_LINE + 0)) {
                    buf.append(WORD_LINE + "%d" + "\n");
                }
                else {
                    buf.append(line).append("\n");
                }
            }
            globalInfo.put(globalVar, buf.toString());
        });
        module.stringConstSeg.forEach(stringConst -> {
            StringBuilder buf = new StringBuilder();
            var strFormat = AsmFormatter.stringConstFormat((GlobalReg) stringConst.asmOperand);
            for (var line : strFormat) buf.append(line).append("\n");
            globalInfo.put(stringConst, buf.toString());
        });
    }

    public AsmFunction getCompiledFunc(IRFunction function) {
        return this.runningIR2CompiledAsm.get(function);
    }

    public String getGeneratedCode(IRFunction function, HashSet<IRFunction> dependencies) {
        AsmFunction compiledAsmFunc = this.runningIR2CompiledAsm.get(function);

        if (!codeStorage.containsKey(compiledAsmFunc)) {
            throw new InternalError("codegen error: function not compiled");
        }

        StringBuilder base = new StringBuilder();

        // link all
        for (IRFunction dependency : dependencies) {
            AsmFunction compiledDependency = this.runningIR2CompiledAsm.get(dependency);
            if (!codeStorage.containsKey(compiledDependency)) {
                throw new InternalError("dependency error!");
            }
            String dependencyCode = codeStorage.get(compiledDependency);
            if (dependency == function) {
                // set to main
                base.append(dependencyCode.replaceAll(NAME_REPLACE, "main"));
            }
            else {
                base.append(dependencyCode.replaceAll(NAME_REPLACE, compiledDependency.identifier));
            }
            base.append("\n");
        }

        for (var entry : globalInfo.entrySet()) {
            if (entry.getKey() instanceof StringConst) base.append(entry.getValue());
            else {
                assert entry.getKey() instanceof GlobalVariable;
                GlobalVariable gloVar = (GlobalVariable) entry.getKey();
                base.append(String.format(entry.getValue(),
                        runningMachine.loadBySize(runningMachine.regRead(gloVar), gloVar.type.size())));
            }
        }

        return base.toString();
    }

    public void setRCMap(IRFunction runningIRFunc, AsmFunction compiledAsmFunc) {
        this.runningIR2CompiledAsm.put(runningIRFunc, compiledAsmFunc);
    }

    @Override
    public void runOnFunc(AsmFunction compiledAsmFunc) {
        assert !codeStorage.containsKey(compiledAsmFunc);

        AsmFunction pseudoFunc = new AsmFunction(NAME_REPLACE);

        code = "";
        code += TAB + ".text\n";
        AsmFormatter.functionHeaderFormat(pseudoFunc).forEach(line -> code += line + "\n");
        code += pseudoFunc + ":" + "\n";

        curAsmFunc = compiledAsmFunc;
        compiledAsmFunc.blocks.forEach(this::runOnBlock);

        code += TAB + ".size" + TAB + pseudoFunc + ", .-" + pseudoFunc + "\n";
        codeStorage.put(compiledAsmFunc, code);
    }

    @Override
    public void runOnBlock(AsmBlock block) {
        code += block.identifier + ":" + "\n";
        block.instructions.forEach(inst -> {
            String instStr = AsmFormatter.instFormat(inst) + "\n";
            if (inst instanceof AsmCallInst && ((AsmCallInst) inst).callFunc == curAsmFunc)
                instStr = instStr.replaceAll(curAsmFunc.identifier, NAME_REPLACE);
            code += instStr;
        });
    }
}
