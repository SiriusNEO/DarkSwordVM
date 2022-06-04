package darksword.jit;

import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;

import java.util.LinkedHashMap;

public class Profiler {

    private static final int COMPILED = -1, INVALID = -2;

    // the called times of a function.
    // set to -1 if function is compiled.
    // set to -2 if function has side effect (call others)
    private final LinkedHashMap<IRFunction, Integer> funcHot;

    public Profiler(IRModule irModule) {
        funcHot = new LinkedHashMap<>();
        for (IRFunction function : irModule.functions)
            funcHot.put(function, 0);
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

    public void funcInvalidSubmit(IRFunction function) {
        assert funcHot.containsKey(function);
        funcHot.put(function, INVALID);
    }

    public boolean isCompiled(IRFunction function) {
        assert  funcHot.containsKey(function);
        return funcHot.get(function) == COMPILED;
    }

    public IRFunction hotSelect() {
        IRFunction hottest = null;

        for (var entry : funcHot.entrySet()) {
            if (entry.getValue() <= 0) continue; // at least execute once!
            if (hottest == null || funcHot.get(hottest) < entry.getValue()) {
                hottest = entry.getKey();
            }
        }

        return hottest;
    }

}
