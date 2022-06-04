package darksword.ravel;

import darksword.console.Config;

public class RavelControl {

    static {
        if (Config.getPath(Config.Option.LibRavel).length() > 0)
            System.load(Config.getPath(Config.Option.LibRavel));
    }

    public native static int connect(String testWord);

    public native static int simulate(String code, int[] externRegs, byte[] externMem, int memSize, boolean display);

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
