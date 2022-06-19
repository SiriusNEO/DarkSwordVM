package darksword.jit;

public class JITScheduler {

    private static final int THRESHOLD = 1000;
    private int counter;

    public JITScheduler() {
        this.counter = 0;
    }

    public boolean signal() {
        this.counter++;
        return this.counter >= THRESHOLD;
    }

    public void acknowledged() {
        this.counter = 0;
    }
}
