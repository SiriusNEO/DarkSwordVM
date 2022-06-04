package darksword.jit;

import masterball.compiler.backend.rvasm.AsmFormatter;
import masterball.compiler.backend.rvasm.hierarchy.AsmBlock;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.hierarchy.AsmModule;
import masterball.compiler.share.pass.AsmBlockPass;
import masterball.compiler.share.pass.AsmFuncPass;

import java.util.HashMap;

public class CodeGenerator implements AsmFuncPass, AsmBlockPass {

    private final static String TAB = "\t";

    private final AsmModule module;
    private String code;
    public HashMap<AsmFunction, String> codeStorage;

    public CodeGenerator(AsmModule module) {
        this.module = module;
        this.codeStorage = new HashMap<>();
    }

    @Override
    public void runOnFunc(AsmFunction function) {
        assert !codeStorage.containsKey(function);

        code = "";
        code += TAB + ".text\n";

        String backupFuncName = function.identifier;
        function.identifier = "main"; // rename to name.
        AsmFormatter.functionHeaderFormat(function).forEach(line -> code += line + "\n");
        code += function.identifier + ":" + "\n";

        function.blocks.forEach(this::runOnBlock);
        code += TAB + ".size" + TAB + function + ", .-" + function + "\n";

        function.identifier = backupFuncName;

        module.globalVarSeg.forEach(globalVar -> {
            AsmFormatter.globalVariableFormat(globalVar).forEach(line -> code += line + "\n");
        });
        module.stringConstSeg.forEach(stringConst -> {
            AsmFormatter.stringConstFormat(stringConst).forEach(line -> code += line + "\n");
        });

        codeStorage.put(function, code);
    }

    @Override
    public void runOnBlock(AsmBlock block) {
        code += block.identifier + ":" + "\n";
        block.instructions.forEach(inst -> code += AsmFormatter.instFormat(inst) + "\n");
    }
}
