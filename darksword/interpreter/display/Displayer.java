package darksword.interpreter.display;

import java.io.PrintStream;

public class Displayer {

    private static PrintStream ps = System.out;

    private static final String hint = "<darksword interpreter>: ";

    private static final int InterpretColor = 34, FinishColor = 36;

    private static void colorPrintln(int color, String content){
        ps.format("\033[%dm%s\033[0m\n", color, content);
    }

    public static void interpretRow(RowMark mark) {
        colorPrintln(InterpretColor, hint + "now >>> " + mark.row + ": " + mark.code);
    }

    public static void interpretFinish(int exitCode) {
        colorPrintln(InterpretColor, hint + "interpret finish. Exit Code: " + exitCode);
    }

}
