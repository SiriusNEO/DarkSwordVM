package darksword.ravel;

import darksword.console.Config;

public class RavelControl {

    static {
        String path = (String) Config.getArgValue(Config.Option.LibRavel);
        if (path.length() > 0) {
            System.load(path);
        }
    }

    public native static int connect(String testWord);

    public native static int simulate(String src, String lib, int[] externRegs, byte[] externMem, int memSize, boolean display);

    /*
    public static int test(String code, int[] externRegs, byte[] externMem) {
        Log.info("code:", code);
        Log.info("regs num:", externRegs.length);
        Log.info("mem size:", externMem.length, "(bytes)");
        externRegs[0] = 233;
        externMem[0] = 42;
        return 233;
    }
    */
}
