package darksword.interpreter.error;

public class StackOverflowError extends VirtualMachineError {
    public StackOverflowError() {
        super("STACK OVERFLOW!!!");
    }
}
