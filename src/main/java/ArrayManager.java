public class ArrayManager extends Thread {
    private final ArraySum arraySum;
    private int sum;

    public ArrayManager(ArraySum arraySum) {
        this.arraySum = arraySum;
    }

    @Override
    public void run() {
        synchronized (arraySum) {
            sum = arraySum.sum();
        }
    }

    public int getSum() {
        return sum;
    }
}