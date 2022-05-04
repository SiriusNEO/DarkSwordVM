package darksword.interpreter.error;

public class ZeroDivisionError extends VirtualMachineError {
    public ZeroDivisionError() {
        super("divided by Zero!");
    }
}
