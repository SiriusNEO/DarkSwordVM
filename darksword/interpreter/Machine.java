package darksword.interpreter;

import darksword.interpreter.error.NoMainFunc;
import darksword.interpreter.error.SegmentationFault;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.share.error.runtime.StackOverflowError;
import masterball.compiler.share.lang.MxStar;
import masterball.debug.Log;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Stack;

public class Machine {
    // cursor
    public int sp;
    public IRBlock curBlock, lastBlock;
    // return register stack
    public Stack<Value> retValStack;
    public Stack<Integer> retAddrStack;

    // mem
    private LinkedHashMap<Value, Integer> regStore; // i32
    private LinkedHashMap<Integer, Byte> memory;

    // 0 ~ heapStart-1 is for stack
    private final static int __heapStart = 0x4000;
    private int heapCur, stackCur;

    public Machine(IRModule module) {
        sp = 0;
        heapCur = __heapStart;
        stackCur = 0;
        retValStack = new Stack<>();
        retAddrStack = new Stack<>();
        regStore = new LinkedHashMap<>();
        memory = new LinkedHashMap<>();

        // booting
        for (IRFunction function : module.functions) {
            if (Objects.equals(function.name, MxStar.mainKw)) {
                curBlock = function.entryBlock;
                lastBlock = null;

                // Loading BSS to memory

                for (GlobalVariable glbVar : module.globalVarSeg) {
                    int dat = 0;
                    if (glbVar.initValue instanceof IntConst) {
                        assert glbVar.initValue.type.size() == 4;
                        dat = ((IntConst) glbVar.initValue).constData;
                    }
                    else if (glbVar.initValue instanceof BoolConst) {
                        // mem bool
                        assert glbVar.initValue.type.size() == 4;
                        dat = ((BoolConst) glbVar.initValue).constData ? 1 : 0;
                    }

                    for (int i = 0; i < 4; i++) {
                        // Big-Endian
                        store(heapCur, (byte) (dat >> 8*(3-i) & 0xff));
                        ++heapCur;
                    }

                    // first address
                    regWrite(glbVar, heapCur);

                    for (int i = 0; i < 4; i++) {
                        store(heapCur, (byte) (dat >> 8*(3-i) & 0xff));
                        ++heapCur;
                    }
                }

                for (StringConst strCst : module.stringConstSeg) {
                    // todo
                }

                return;
            }
        }

        throw new NoMainFunc();
    }

    public int load(int addr) {
        var ret = memory.get(addr);
        if (ret == null) {
            throw new SegmentationFault("load in " + addr);
        }
        return ret & 0xff;
    }

    public void store(int addr, byte data) {
        memory.put(addr, data);
    }

    public int regRead(Value reg) {
        if (reg instanceof IntConst) {
            return ((IntConst) reg).constData;
        }
        else if (reg instanceof BoolConst) {
            return ((BoolConst) reg).constData ? 1 : 0;
        }
        else if (reg instanceof NullptrConst) {
            return 0;
        }

        var ret = regStore.get(reg);
        if (ret == null) {
            throw new SegmentationFault("read reg " + reg.identifier());
        }
        Log.info("regRead [" + ret + "] from [" + reg.identifier() + "]");
        return ret;
    }

    public void regWrite(Value reg, Integer data) {
        Log.info("regWrite [" + data + "] to [" + reg.identifier() + "]");
        regStore.put(reg, data);
    }

    public int alloc(int size) {
        if (stackCur >= __heapStart) {
            throw new StackOverflowError();
        }
        int ret = stackCur;
        stackCur += size;
        return ret;
    }

    // libc

    public int libcMalloc(int size) {
        int ret = heapCur;
        heapCur += size;
        return ret;
    }

    public int libcStrCat(int str1, int str2) {
        return 0;
    }

    public boolean libcStrEq(int str1, int str2) {
        return false;
    }
    
    public boolean libcStrNeq(int str1, int str2) {
        return false;
    }

    public boolean libcStrSlt(int str1, int str2) {
        return false;
    }

    public boolean libcStrSle(int str1, int str2) {
        return false;
    }

    public boolean libcStrSgt(int str1, int str2) {
        return false;
    }

    public boolean libcStrSge(int str1, int str2) {
        return false;
    }

    public void libcPrint(int str) {

    }

    public void libcPrintln(int str) {

    }

    public void libcPrintInt(int num) {

    }

    public void libcPrintlnInt(int num) {

    }

    public int libcGetString() {
        return 0;
    }

    public int libcGetInt() {
        return 0;
    }

    public int libcToString(int num) {
        return 0;
    }

    public int libcStrLength(int str) {
        return 0;
    }

    public int libcStrSubstring(int str, int left, int right) {
        return 0;
    }

    public int libcStrParseInt(int str) {
        return 0;
    }

    public int libcStrOrd(int str, int pos) {
        return 0;
    }
}
