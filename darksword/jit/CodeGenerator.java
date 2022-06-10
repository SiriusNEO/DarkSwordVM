package darksword.jit;

import darksword.interpreter.Machine;
import darksword.interpreter.error.InternalError;
import masterball.compiler.backend.rvasm.AsmFormatter;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.inst.AsmCallInst;
import masterball.compiler.backend.rvasm.inst.AsmLaInst;
import masterball.compiler.backend.rvasm.inst.AsmLoadInst;
import masterball.compiler.backend.rvasm.inst.AsmRetInst;
import masterball.compiler.backend.rvasm.operand.GlobalReg;
import masterball.compiler.backend.rvasm.operand.Immediate;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.middleend.llvmir.constant.GlobalValue;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.share.pass.AsmBlockPass;
import masterball.compiler.share.pass.AsmFuncPass;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class CodeGenerator implements AsmFuncPass, AsmBlockPass {

    private final static String TAB = "\t";
    private final static String NAME_REPLACE = "__internal__name__replace__",
                                RESTORE_INST_REPLACE = "__internal_restore__replace__\n";

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

    public String getGeneratedCode(IRFunction function, HashSet<IRFunction> dependencies, ArrayList<GlobalValue> dirtyGlobal) {
        AsmFunction compiledAsmFunc = this.runningIR2CompiledAsm.get(function);

        if (!codeStorage.containsKey(compiledAsmFunc)) {
            throw new InternalError("codegen error: function not compiled");
        }

        StringBuilder base = new StringBuilder();
        StringBuilder restore = new StringBuilder();

        for (int i = 1; i <= dirtyGlobal.size(); ++i) {
            // stringConst will not be modified
            // only care about global variable
            var dirty = dirtyGlobal.get(i-1);
            var insertedLa = new AsmLaInst(PhysicalReg.reg("t0"), dirty.name, null);
            var insertedLoad = new AsmLoadInst(dirty.type.size(), PhysicalReg.reg("a"+i),
                    PhysicalReg.reg("t0"), new Immediate(0), null);
            restore.append(AsmFormatter.instFormat(insertedLa)).append("\n")
                    .append(AsmFormatter.instFormat(insertedLoad)).append("\n");
        }

        // link all
        for (IRFunction dependency : dependencies) {
            AsmFunction compiledDependency = this.runningIR2CompiledAsm.get(dependency);
            if (!codeStorage.containsKey(compiledDependency)) {
                throw new InternalError("dependency error!");
            }
            String dependencyCode = codeStorage.get(compiledDependency);
            if (dependency == function) {
                // set to main
                base.append(dependencyCode.replaceAll(NAME_REPLACE, "main")
                                          .replaceAll(RESTORE_INST_REPLACE, restore.toString()));
            }
            else {
                base.append(dependencyCode.replaceAll(NAME_REPLACE, compiledDependency.identifier)
                                          .replaceAll(RESTORE_INST_REPLACE, ""));
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
            if (inst instanceof AsmRetInst)
                code += RESTORE_INST_REPLACE;
            code += instStr;
        });
    }
}
