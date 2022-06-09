package darksword.interpreter.error;

public class InternalError extends VirtualMachineError {

    public static final String internal = "InternalError happened. ";

    public InternalError(String message) {
        super(internal + message);
    }
}
