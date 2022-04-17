package darksword.interpreter.error;

import masterball.compiler.share.error.RuntimeError;

public class NoMainFunc extends RuntimeError {
    public NoMainFunc() {
        super("no main function found!");
    }
}
