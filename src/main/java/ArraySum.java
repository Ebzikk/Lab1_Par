import java.util.Arrays;

public class ArraySum {
    private final int[] array;

    public ArraySum(int[] array) {
        this.array = array;
    }

    public int sum() {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}