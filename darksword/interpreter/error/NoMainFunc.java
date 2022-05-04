package darksword.interpreter.error;

public class NoMainFunc extends VirtualMachineError {
    public NoMainFunc() {
        super("no main function found!");
    }
}
