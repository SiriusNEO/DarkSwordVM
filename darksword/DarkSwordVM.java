package darksword;

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

            // for (int i = 1; i <= 1000000; ++i)
            //    RavelControl.connect("test" + i);

            Timer.start();
            interpreter.interpret();
            Timer.display();
            Statistics.show("ravel");
        }
        catch (Exception e) {
            errorHandle(e);
        }
        System.exit(0);
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
