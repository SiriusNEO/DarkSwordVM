package darksword.interpreter;

import darksword.console.Config;
import darksword.interpreter.error.NoMainFunc;
import darksword.interpreter.error.OutOfMemoryError;
import darksword.interpreter.error.StackOverflowError;

import darksword.jit.LibReader;
import darksword.ravel.RavelControl;
import masterball.compiler.backend.rvasm.hierarchy.AsmFunction;
import masterball.compiler.backend.rvasm.operand.PhysicalReg;
import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.middleend.llvmir.inst.IRCallInst;
import masterball.compiler.share.lang.MxStar;
import masterball.compiler.share.lang.RV32I;
import masterball.debug.Log;
import masterball.debug.Statistics;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class Machine {

    // handle dfs
    public static class StackLayer {
        public Value retVal;
        public int retAddr;
        public IRBlock lastBlock;
        public LinkedHashMap<Value, Integer> regScope;
        public int stackUse;

        public StackLayer(Value retVal, int retAddr, IRBlock lastBlock) {
            this.retVal = retVal;
            this.retAddr = retAddr;
            this.lastBlock = lastBlock;
            this.regScope = new LinkedHashMap<>();
            this.stackUse = 0;
        }
    }

    // cur
    public int cursor;
    public IRBlock curBlock, lastBlock;
    // stack
    public Stack<StackLayer> runStack;

    // env
    public InputStream stdin;
    public PrintStream stdout;
    public Scanner scanner;

    // builtin
    private LibReader libReader;

    // mem
    private final LinkedHashMap<Value, Integer> glbRegScope;
    private final byte[] memory;

    // RISCV-32 registers
    public final int[] regs;
    public final int regNum = PhysicalReg.phyRegs.size(); // 32

    // 0 ~ heapStart-1 is for stack
    private final static int __machineMem = 64*1024*1024,
                             __ravelTextSpace = 0x1000000,    // 16MB for ravel inst
                             __stackSpace = 0x100000, // 1MB stack
                             __ravelStackSpace = 0x100000;

    private int heapCur, stackCur;

    public Machine(IRModule module) throws IOException {
        stdin = (InputStream) Config.getArgValue(Config.Option.Stdin);
        stdout = (PrintStream) Config.getArgValue(Config.Option.Stdout);
        scanner = new Scanner(stdin);

        libReader = new LibReader();

        cursor = 0;
        heapCur = __ravelTextSpace;
        stackCur = __machineMem - __ravelStackSpace;
        runStack = new Stack<>();
        glbRegScope = new LinkedHashMap<>();

        regs = new int[regNum];
        memory = new byte[__machineMem];   //64MB

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

                    // first address
                    int addr = libcMalloc(4);
                    regWrite(glbVar, addr);
                    storeBySize(addr, dat, 4);
                }

                for (StringConst strCst : module.stringConstSeg) {
                    regWrite(strCst, strMalloc(strCst.constData));
                }

                Log.info("Virtual machine booted. MemSize= ", this.memory.length, "(bytes)");
                return;
            }
        }

        throw new NoMainFunc();
    }

    public void testRavel() {
        Statistics.plus("test_ravel");
        Statistics.show("test_ravel");
        RavelControl.simulate(".text\n.globl main\nmain:\nnop\nret", libReader.getLib(), this.regs, this.memory, __machineMem, false);
    }

    public int callRavel(IRCallInst call, String code, AsmFunction compiledFunc, boolean linkLib) {

        for (int i = 0; i < this.regNum; ++i) this.regs[i] = 0;
        this.regs[2] = __machineMem - compiledFunc.totalStackUse; // stack pointer.

        // 0~7
        for (int i = 0; i < Integer.min(call.callFunc().getArgNum(), RV32I.MaxArgRegNum); i++) {
             // a0 ~ a7
             this.regs[10+i] = this.regRead(call.getArg(i));
        }

        // spill to mem
        for (int i = RV32I.MaxArgRegNum; i < call.callFunc().getArgNum(); i++) {
            this.regs[2] -= call.getArg(i).type.size();
        }

        for (int i = RV32I.MaxArgRegNum; i < call.callFunc().getArgNum(); i++) {
            this.storeBySize(this.regs[2] + compiledFunc.arguments.get(i).stackOffset.value,
                             this.regRead(call.getArg(i)),
                             call.getArg(i).type.size());
        }

        String linkCode = linkLib ? libReader.getLib() : "";

        return RavelControl.simulate(
                                code,
                                linkCode,
                                this.regs,
                                this.memory,
                                __machineMem,
                         false);
    }

    private int byteLoad(int addr) {
        if (addr < __ravelTextSpace) {
            throw new OutOfMemoryError("load in " + addr);
        }
        int ret = memory[addr];
        // Log.info("load [" + ret + "] from [" + addr + "]");
        return ret & 0xff;
    }

    private void byteStore(int addr, byte data) {
        if (addr < __ravelTextSpace) {
            throw new OutOfMemoryError("store in " + addr);
        }
        memory[addr] = data;
        // Log.info("store [" + data + "] to [" + addr + "]");
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

        Integer ret = null;
        if (reg instanceof GlobalValue) {
            ret = glbRegScope.get(reg);
        }
        else {
            ret = runStack.peek().regScope.get(reg);
        }

        if (ret == null) {
            throw new OutOfMemoryError("read reg " + reg.identifier());
        }
        // Log.info("regRead [" + ret + "] from [" + reg.identifier() + "]");
        return ret;
    }

    public void regWrite(Value reg, Integer data) {
        // Log.info("regWrite [" + data + "] to [" + reg.identifier() + "]");

        if (reg instanceof GlobalValue) {
            glbRegScope.put(reg, data);
        }
        else {
            runStack.peek().regScope.put(reg, data);
        }
    }

    public int alloc(int size) {
        if (stackCur <= __machineMem - __stackSpace - __ravelStackSpace) {
            throw new StackOverflowError();
        }
        stackCur -= size;
        runStack.peek().stackUse += size;
        storeBySize(stackCur, 0, size); // initialize 0
        return stackCur;
    }

    public void releaseStack() {
        stackCur += runStack.peek().stackUse;
    }

    public int loadBySize(int addr, int size) {
        int loadData = 0;
        for (int i = 0; i < size; ++i) {
            // Big-Endian load
            loadData = (loadData << 8) + byteLoad(addr+size-i-1);
        }
        // Log.info(loadData);
        return loadData;
    }

    public void storeBySize(int addr, int dat, int size) {
        for (int i = 0; i < size; i++) {
            // Log.info((int) (byte) ((dat >> 8*(size-1-i) & 0xff)));
            // Small-Endian
            byteStore(addr+i, (byte) ((dat >> 8*i) & 0xff));
        }
    }

    private int strMalloc(String str) {
        byte[] dat = str.getBytes();
        int ret = libcMalloc(dat.length), addr = ret;
        for (byte b : dat) {
            byteStore(addr, b);
            ++addr;
        }
        return ret;
    }

    private String strLoad(int addr) {
        ArrayList<Byte> bytes = new ArrayList<>();

        while (true) {
            byte byt = (byte) byteLoad(addr);
            bytes.add(byt);
            if (byt == 0) {
                break;
            }
            ++addr;
        }

        byte[] dat = new byte[bytes.size()];

        for (int i = 0; i < dat.length; ++i)
            dat[i] = bytes.get(i);

        String ret = new String(dat);
        return ret.substring(0, ret.length()-1); // emit /0
    }

    // libc

    public int libcMalloc(int size) {
        int ret = heapCur;
        heapCur += size;
        return ret;
    }

    public int libcStrCat(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return strMalloc(str1 + str2 + "\0");
    }

    public boolean libcStrEq(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return str1.equals(str2);
    }
    
    public boolean libcStrNe(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return !str1.equals(str2);
    }

    public boolean libcStrSlt(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return str1.compareTo(str2) < 0;
    }

    public boolean libcStrSle(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return str1.compareTo(str2) <= 0;
    }

    public boolean libcStrSgt(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return str1.compareTo(str2) > 0;
    }

    public boolean libcStrSge(int addr1, int addr2) {
        String str1 = strLoad(addr1), str2 = strLoad(addr2);
        return str1.compareTo(str2) >= 0;
    }

    public void libcPrint(int addr) {
        String str = strLoad(addr);
        stdout.print(str);
    }

    public void libcPrintln(int addr) {
        String str = strLoad(addr);
        stdout.println(str);
    }

    public void libcPrintInt(int num) {
        stdout.print(num);
    }

    public void libcPrintlnInt(int num) {
        stdout.println(num);
    }

    public int libcGetString() {
        String str = scanner.next();
        return strMalloc(str + "\0");
    }

    public int libcGetInt() {
        return scanner.nextInt();
    }

    public int libcToString(int num) {
        return strMalloc(num + "\0");
    }

    public int libcStrLength(int addr) {
        return strLoad(addr).length();
    }

    public int libcStrSubstring(int addr, int left, int right) {
        return strMalloc(strLoad(addr).substring(left, right) + "\0");
    }

    public int libcStrParseInt(int addr) {
        return Integer.parseInt(strLoad(addr));
    }

    public int libcStrOrd(int addr, int pos) {
        return strLoad(addr).charAt(pos);
    }
}
