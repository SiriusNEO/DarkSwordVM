package darksword.jit;

import darksword.console.Config;
import darksword.interpreter.ModuleBuilder;
import masterball.compiler.backend.optim.*;
import masterball.compiler.backend.regalloc.RegisterAllocator;
import masterball.compiler.backend.regalloc.StackAllocator;
import masterball.compiler.backend.rvasm.AsmBuilder;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.middleend.analyzer.CFGBuilder;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.constant.StringConst;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.optim.*;
import masterball.compiler.middleend.optim.ssa.Mem2Reg;
import masterball.compiler.middleend.optim.ssa.SSADestructor;
import masterball.debug.Log;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class JITCompiler {

    private final ModuleBuilder compilingIRBuilder;
    private final HashMap<String, IRFunction> name2Func;

    public JITCompiler() throws IOException {

        // split running IR and compiling IR
        this.compilingIRBuilder = new ModuleBuilder();
        this.name2Func = new HashMap<>();

        for (IRFunction function : compilingIRBuilder.irModule.functions) {
            new CFGBuilder().runOnFunc(function);
            name2Func.put(function.name, function);
        }
    }

    public AsmFunction compile(String funcName) {
        assert name2Func.containsKey(funcName);

        // running2Compiling: their name must be identical
        IRFunction compiling = name2Func.get(funcName);

        // IR Optimization

        Value.rename = true;

        int optLevel = (int) Config.getArgValue(Config.Option.OptLevel);

        if (optLevel == 1) {
            new Mem2Reg().runOnFunc(compiling);
            new CFGSimplifier().runOnFunc(compiling);
            new GVN().runOnFunc(compiling);
            new SCCP().runOnFunc(compiling);
            new ADCE().runOnFunc(compiling);
            new CFGSimplifier().runOnFunc(compiling);
            new LICM().runOnFunc(compiling);
            new SSADestructor().runOnFunc(compiling);
        }

        if (optLevel == 2) {
            new Mem2Reg().runOnFunc(compiling);
            for (int i = 1; i <= 7; i++) {
                new CFGSimplifier().runOnFunc(compiling);
                new GVN().runOnFunc(compiling);
                new SCCP().runOnFunc(compiling);
                new ADCE().runOnFunc(compiling);
                new CFGSimplifier().runOnFunc(compiling);
                new IVTrans().runOnFunc(compiling);
                new LICM().runOnFunc(compiling);
                new LocalMO().runOnFunc(compiling);
                new CFGSimplifier().runOnFunc(compiling);
            }
            new SSADestructor().runOnFunc(compiling);
        }

        AsmBuilder asmBuilder = new AsmBuilder();

        // not run, otherwise the builder will compile all codes
        asmBuilder.buildModuleSkeleton(compilingIRBuilder.irModule);
        asmBuilder.runOnFunc(compiling);

        AsmFunction asmFunc = (AsmFunction) compiling.asmOperand;
        // because we build skeleton first, the block removed in IR still remains in Asm (but they must be empty!)

        // Assembly Optimization
        new RegisterAllocator().runOnFunc(asmFunc);
        new StackAllocator().runOnFunc(asmFunc);
        new CoalesceMoves().runOnFunc(asmFunc);
        new ZeroInstPeephole().runOnFunc(asmFunc);
        new BlockMerge().runOnFunc(asmFunc);
        new ReorderBlock().runOnFunc(asmFunc);
        new RedundantInst().runOnFunc(asmFunc);
        new LoadStorePeephole().runOnFunc(asmFunc);

        return asmFunc;
    }
}
