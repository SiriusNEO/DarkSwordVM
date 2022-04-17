package darksword.interpreter.error;

import masterball.compiler.share.error.RuntimeError;

public class ZeroDivisionError extends RuntimeError {
    public ZeroDivisionError() {
        super("divided by Zero!");
    }
}
