package darksword.jit;

public class JITScheduler {

    private static final int THRESHOLD = 12;
    private int counter;

    public JITScheduler() {
        this.counter = 0;
    }

    public void update() {
        this.counter++;
    }

    public boolean signal() {
        return this.counter >= THRESHOLD;
    }

    public void reset() {
        this.counter = 0;
    }
}
