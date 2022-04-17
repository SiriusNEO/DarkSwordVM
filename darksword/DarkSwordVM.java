package darksword;

import darksword.interpreter.Interpreter;
import darksword.interpreter.ModuleBuilder;
import masterball.compiler.share.error.CompileError;
import masterball.console.Console;
import masterball.console.error.ConsoleError;
import masterball.debug.Timer;

public class DarkSwordVM {

    public static void main(String[] args) throws Exception {
        try {
            Timer.start();

            Console console = new Console(args);
            if (console.showHelp || console.showVersion) return;

            new Interpreter().interpret();

            Timer.display();
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
        else if (e instanceof ConsoleError) {
            ((ConsoleError) e).tell();
            throw new RuntimeException();
        }
        else {
            e.printStackTrace();
        }
    }
}
