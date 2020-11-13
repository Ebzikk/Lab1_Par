import java.util.Arrays;
import java.util.Random;

public class Application {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = random.ints(0, 10)
                .limit(10)
                .toArray();
        System.out.println("array = " + Arrays.toString(array));
        int[] firstHalfArray = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondHalfArray = Arrays.copyOfRange(array, array.length / 2, array.length);

        ArraySum arrayFirstSum = new ArraySum(firstHalfArray);
        ArraySum arraySecondSum = new ArraySum(secondHalfArray);

        ArrayManager arrayFirstManager = new ArrayManager(arrayFirstSum);
        ArrayManager arraySecondManager = new ArrayManager(arraySecondSum);

        arrayFirstManager.start();
        arraySecondManager.start();

        try {
            arrayFirstManager.join();
            arraySecondManager.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int sum = arrayFirstManager.getSum() + arraySecondManager.getSum();
        System.out.println("sum = " + sum);
    }
}