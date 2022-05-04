package darksword.interpreter;

import darksword.console.Config;
import darksword.interpreter.error.NoMainFunc;
import darksword.interpreter.error.OutOfMemoryError;
import darksword.interpreter.error.StackOverflowError;

import masterball.compiler.middleend.llvmir.Value;
import masterball.compiler.middleend.llvmir.constant.*;
import masterball.compiler.middleend.llvmir.hierarchy.IRBlock;
import masterball.compiler.middleend.llvmir.hierarchy.IRFunction;
import masterball.compiler.middleend.llvmir.hierarchy.IRModule;
import masterball.compiler.share.lang.MxStar;

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

        public StackLayer(Value retVal, int retAddr, IRBlock lastBlock) {
            this.retVal = retVal;
            this.retAddr = retAddr;
            this.lastBlock = lastBlock;
            this.regScope = new LinkedHashMap<>();
        }
    }

    // cursor
    public int sp;
    public IRBlock curBlock, lastBlock;
    // stack
    public Stack<StackLayer> runStack;

    // env
    public InputStream stdin;
    public PrintStream stdout;
    public Scanner scanner;

    // mem
    private LinkedHashMap<Value, Integer> glbRegScope;
    private final byte[] memory;
    private final boolean[] memValid;

    // 0 ~ heapStart-1 is for stack
    private final static int __heapStart = 0x400000;
    private int heapCur, stackCur;

    public Machine(IRModule module) {
        stdin = (InputStream) Config.getArgValue(Config.Option.Stdin);
        stdout = (PrintStream) Config.getArgValue(Config.Option.Stdout);
        scanner = new Scanner(stdin);

        sp = 0;
        heapCur = __heapStart;
        stackCur = 0;
        runStack = new Stack<>();
        glbRegScope = new LinkedHashMap<>();
        memory = new byte[64*1024*1024];   //64MB
        memValid = new boolean[64*1024*1024];

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

                return;
            }
        }

        throw new NoMainFunc();
    }

    public int load(int addr) {
        if (!memValid[addr]) {
            throw new OutOfMemoryError("load in " + addr);
        }
        int ret = memory[addr];
        // Log.info("load [" + ret + "] from [" + addr + "]");
        return ret & 0xff;
    }

    public void store(int addr, byte data) {
        if (!memValid[addr]) {
            throw new OutOfMemoryError("load in " + addr);
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
        if (stackCur >= __heapStart) {
            throw new StackOverflowError();
        }
        int ret = stackCur;
        for (int i = stackCur; i < stackCur+size; ++i)
            memValid[i] = true;
        storeBySize(stackCur, 0, size); // initialize 0
        stackCur += size;
        return ret;
    }

    public int loadBySize(int addr, int size) {
        int loadData = 0;
        for (int i = 0; i < size; ++i) {
            // Big-Endian load
            loadData = (loadData << 8) + load(addr);
            addr++;
        }
        // Log.info(loadData);
        return loadData;
    }

    public int storeBySize(int addr, int dat, int size) {
        for (int i = 0; i < size; i++) {
            // Log.info((int) (byte) ((dat >> 8*(size-1-i) & 0xff)));
            // Big-Endian
            store(addr, (byte) (dat >> 8*(size-1-i) & 0xff));
            ++addr;
        }
        return addr;
    }

    private int strMalloc(String str) {
        byte[] dat = str.getBytes();
        int ret = libcMalloc(dat.length), addr = ret;
        for (byte b : dat) {
            store(addr, b);
            ++addr;
        }
        return ret;
    }

    private String strLoad(int addr) {
        ArrayList<Byte> bytes = new ArrayList<>();

        while (true) {
            byte byt = (byte) load(addr);
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
        for (int i = heapCur; i < heapCur+size; ++i)
            memValid[i] = true;
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
