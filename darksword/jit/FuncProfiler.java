package darksword.jit;

import masterball.compiler.middleend.analyzer.CallGraphAnalyzer;
import masterball.compiler.middleend.llvmir.constant.GlobalVariable;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRBaseInst;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.middleend.llvmir.inst.IRStoreInst;
import masterball.compiler.share.error.codegen.InternalError;
import masterball.compiler.share.lang.LLVM;
import masterball.compiler.share.lang.MxStar;
import masterball.debug.Log;

import java.util.*;

public class FuncProfiler {

    private static final int COMPILED = -1, INVALID = -2;

    // the called times of a function.
    // set to -1 if function is compiled.
    // set to -2 if function has side effect (call others)
    private final LinkedHashMap<IRFunction, Integer> funcHot;

    private final LinkedHashMap<IRFunction, HashSet<IRFunction>> dependencies;

    public final LinkedHashSet<IRFunction> hasLibcCall;

    public FuncProfiler(IRModule irModule) {
        funcHot = new LinkedHashMap<>();
        hasLibcCall = new LinkedHashSet<>();
        dependencies = new LinkedHashMap<>();

        // don't use CallGraphAnalyzer because it will scan all inst

        for (IRFunction function : irModule.functions) {
            if (function.name.equals("main"))
                funcInvalidate(function); // do not JIT main
            else
                funcHot.put(function, 0);
            dependencies.put(function, new HashSet<>());
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

    private boolean goodDependency(IRFunction caller, IRFunction callee) {
        return funcHot.get(callee) == COMPILED || caller == callee;
    }

    private void funcInvalidate(IRFunction function) {
        Log.info("invalidate:", function.identifier());
        funcHot.put(function, INVALID);
    }

    private boolean checkValidity(IRFunction function) {
        if (funcHot.get(function) == INVALID) {
            return false;
        }

        for (IRBlock block : function.blocks)
            for (IRBaseInst inst : block.instructions) {
                if (inst instanceof IRCallInst) {
                    IRFunction callee = ((IRCallInst) inst).callFunc();
                    if (callee == function.parentModule.getMalloc()) {
                        funcInvalidate(function);
                        return false;
                    }

                    if (function.parentModule.builtinFunctions.contains(callee))
                        hasLibcCall.add(function);
                    else {
                        // dependencies will be ok
                        dependencies.get(function).add(callee);
                        if (!goodDependency(function, callee))
                            return false;
                    }
                }

                // modify global variables
                if (inst instanceof IRStoreInst && ((IRStoreInst) inst).storePtr() instanceof GlobalVariable) {
                    funcInvalidate(function);
                    return false;
                }
            }

        return true;
    }

    public HashSet<IRFunction> dependencyAnalysis(IRFunction function) {
        Queue<IRFunction> workQueue = new LinkedList<>();
        LinkedHashSet<IRFunction> ret = new LinkedHashSet<>();

        workQueue.offer(function);
        ret.add(function);

        while (!workQueue.isEmpty()) {
            IRFunction curFunc = workQueue.poll();
            if (funcHot.get(curFunc) != COMPILED) {
                throw new InternalError("not compiled");
            }

            var curDependencies = dependencies.get(curFunc);

            for (var dependency : curDependencies) {
                if (!ret.contains(dependency)) {
                    workQueue.offer(dependency);
                }
            }

            ret.addAll(curDependencies);
        }

        return ret;
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
            return null;
        }
    }
}
