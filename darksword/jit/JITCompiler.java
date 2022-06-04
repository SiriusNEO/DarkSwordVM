package darksword.jit;

import masterball.compiler.backend.optim.*;
import masterball.compiler.backend.regalloc.RegisterAllocator;
import masterball.compiler.backend.regalloc.StackAllocator;
import masterball.compiler.backend.rvasm.AsmBuilder;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;

public class JITCompiler {

    public final AsmBuilder builder;

    public JITCompiler(IRModule irModule) {
        this.builder = new AsmBuilder();
        for (IRFunction function : irModule.functions)
            new CFGBuilder().runOnFunc(function);
        builder.buildModuleSkeleton(irModule); // not run, otherwise the builder will compile all codes
    }

    public AsmFunction compile(IRFunction function) {
        this.builder.runOnFunc(function);
        AsmFunction asmFunc = (AsmFunction) function.asmOperand;
        new RegisterAllocator().runOnFunc(asmFunc);
        new StackAllocator().runOnFunc(asmFunc);
        // new TCO().runOnFunc(asmFunc);
        new CoalesceMoves().runOnFunc(asmFunc);
        new ZeroInstPeephole().runOnFunc(asmFunc);
        new BlockMerge().runOnFunc(asmFunc);
        new ReorderBlock().runOnFunc(asmFunc);
        new RedundantInst().runOnFunc(asmFunc);
        new LoadStorePeephole().runOnFunc(asmFunc);
        return asmFunc;
    }
}
