package darksword.interpreter.error;

public class VirtualMachineError extends RuntimeException {
    public String message;

    public VirtualMachineError(String message) {
        this.message = message;
    }

    public void tell() {System.err.println("<darksword interpreter>: [VM Error]: " + message);}
}
