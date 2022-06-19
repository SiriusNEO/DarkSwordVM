package darksword;

import darksword.console.Config;
import darksword.console.Console;
import darksword.interpreter.Interpreter;
import darksword.interpreter.Machine;
import darksword.interpreter.error.VirtualMachineError;
import darksword.ravel.RavelControl;
import masterball.compiler.share.error.CompileError;
import masterball.console.error.ConsoleError;
import masterball.debug.Log;
import masterball.debug.Statistics;
import masterball.debug.Timer;

import java.util.ArrayList;
import java.util.Arrays;

public class DarkSwordVM {

    public static void main(String[] args) throws Exception {
        try {
            Console console = new Console(args);
            if (console.showHelp || console.showVersion) return;

            Interpreter interpreter = new Interpreter(console);

            Timer.start();
            interpreter.interpret();

            // absolute running time
            Timer.display();

            benchmark();
        }
        catch (Exception e) {
            errorHandle(e);
        }
        System.exit(0);
    }

    private static void benchmark() {
        // a simple benchmark
        int optLevel = (int) Config.getArgValue(Config.Option.OptLevel);

        double interpreterWeight = 10, ravelWeight = 0.1,
                o0Weight = 100, o1Weight = 300, o2Weight = 500;

        double interpreterCost = interpreterWeight * Statistics.get("interpreter");
        double ravelCost = ravelWeight * Statistics.get("ravel");
        double compilingCost = 0;

        switch (optLevel) {
            case 0: compilingCost = o0Weight * Statistics.get("compile"); break;
            case 1: compilingCost = o1Weight * Statistics.get("compile"); break;
            case 2: compilingCost = o2Weight * Statistics.get("compile"); break;
        }

        System.out.println("[darksword] simple JIT benchmark: ");
        System.out.printf("interpreter cost=%f, ravel cost=%f, compiling cost=%f, total=%f\n",
                            interpreterCost, ravelCost, compilingCost, interpreterCost + ravelCost + compilingCost);
    }

    private static void errorHandle(Exception e) {
        if (e instanceof CompileError) {
            ((CompileError) e).tell();
            throw new RuntimeException();
        }
        else if (e instanceof VirtualMachineError) {
            ((VirtualMachineError) e).tell();
            throw new RuntimeException();
        }
        else if (e instanceof ConsoleError) {
            ((ConsoleError) e).tell();
            throw new RuntimeException();
        }
        else {
            e.printStackTrace();
        }
    }
}
