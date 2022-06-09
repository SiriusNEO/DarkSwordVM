package darksword.jit;

import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.inst.IRStoreInst;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;

public class FuncProfiler {

    private static final int COMPILED = -1, INVALID = -2;

    // the called times of a function.
    // set to -1 if function is compiled.
    // set to -2 if function has side effect (call others)
    private final LinkedHashMap<IRFunction, Integer> funcHot;

    public final LinkedHashSet<IRFunction> hasLibcCall;

    public FuncProfiler(IRModule irModule) {
        funcHot = new LinkedHashMap<>();
        hasLibcCall = new LinkedHashSet<>();
        for (IRFunction function : irModule.functions) {
            if (function.name.equals("main")) funcHot.put(function, INVALID); // do not JIT main
            else funcHot.put(function, 0);
        }
    }

    public void funcInterpretedSubmit(IRFunction function) {
        if (funcHot.get(function) < 0) {
            return;
        }
        assert funcHot.containsKey(function);
        funcHot.put(function, funcHot.get(function) + 1);
    }

    public void funcCompiledSubmit(IRFunction function) {
        assert funcHot.containsKey(function);
        funcHot.put(function, COMPILED);
    }

    public boolean isCompiled(IRFunction function) {
        assert funcHot.containsKey(function);
        return funcHot.get(function) == COMPILED;
    }

    private boolean checkValidity(IRFunction function) {
        for (IRBlock block : function.blocks)
            for (IRBaseInst inst : block.instructions) {
                if (inst instanceof IRCallInst) {
                    // libc and other user-defined func call not support
                    if (((IRCallInst) inst).callFunc() != function) {
                        if (function.parentModule.builtinFunctions.contains(((IRCallInst) inst).callFunc()) &&
                            function != function.parentModule.getMalloc() )
                            hasLibcCall.add(function);
                        else
                            return false;
                    }
                }

                // modify global variables
                if (inst instanceof IRStoreInst && ((IRStoreInst) inst).storePtr() instanceof GlobalVariable) {
                    return false;
                }
            }

        return true;
    }

    public IRFunction hotSelect() {
        IRFunction hottest = null;

        for (var entry : funcHot.entrySet()) {
            if (entry.getValue() <= 0) continue; // at least execute once!
            if (hottest == null || funcHot.get(hottest) < entry.getValue()) {
                hottest = entry.getKey();
            }
        }

        if (hottest == null) return null;
        else if (checkValidity(hottest)) return hottest;
        else {
            funcHot.put(hottest, INVALID);
            return null;
        }
    }
}
