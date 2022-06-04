package darksword.console;

import masterball.compiler.share.lang.LLVM;
import darksword.console.Config;

public class CmdDoc {

    private final static String TAB = "\t";

    public static String version() {
        StringBuilder ret = new StringBuilder("DarkSword Virtual Machine 1.0.0 using JDK 11\n");
        ret.append("Copyright (C) 2022 ACM Class 2020, SiriusNEO.\n");
        ret.append("Env: Linux\n");
        ret.append("OS Arch: x86_" + LLVM.PointerSize * 8 + "\n");
        return ret.toString();
    }

    public static String help() {
        StringBuilder ret = new StringBuilder("Overview: DarkSwordVM, a toy just-in-time (JIT) VM in LLVM IR by SiriusNEO.\n");
        ret.append("Github: https://github.com/SiriusNEO/DarkSwordVM\n\n");
        ret.append("Usage: java -jar DarkSword.jar [options] file...\n");
        ret.append("Options\n");

        for (Config.Option option : Config.argSetting.keySet()) {
            ret.append(TAB).append(Config.argSetting.get(option).argName).append(TAB.repeat(3));
            switch (option) {
                case Help: {
                    ret.append("Display this information\n");
                    break;
                }
                case Version: {
                    ret.append("Display the version of the compiler\n");
                    break;
                }
                case Input: {
                    ret.append("Redirect the input of the compiler\n");
                    break;
                }
                case LogOutput: {
                    ret.append("Redirect the log output path of the compiler\n");
                    break;
                }
                case OJMode: {
                    ret.append("Automatically fitted to Online Judge\n");
                    break;
                }
                case Stdin: {
                    ret.append("Standard Input of this VM\n");
                    break;
                }
                case Stdout: {
                    ret.append("Standard Output of this VM\n");
                    break;
                }
                case LibRavel: {
                    ret.append("The absolute path of the libravel-sim.so file\n");
                    break;
                }
                case JIT: {
                    ret.append("Start JIT mode (otherwise only the interpreter is running)");
                    break;
                }
            }
        }
        return ret.toString();
    }
}
