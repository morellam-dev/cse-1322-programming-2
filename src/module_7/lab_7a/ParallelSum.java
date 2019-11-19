package module_7.lab_7a;

import java.util.Random;

class ParallelSumHelper extends Thread {
    private final int[] arr;
    private final int startIndex;
    private final int endIndex;
    private int partialSum;

    public ParallelSumHelper(int[] arr, int startIndex, int endIndex) {
        this.arr = arr;
        this.startIndex = startIndex;
        this.endIndex = endIndex > arr.length ? arr.length : endIndex; // exclusive
    }

    public static int sumArraySection(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int getPartialSum() {
        try {
            this.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        return partialSum;
    }

    @Override
    public void run() {
        partialSum = sumArraySection(arr, startIndex, endIndex);
    }
}

/**
 * ParallelSum
 */

public class ParallelSum {
    public static int getLinearSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int getParallelSum(int[] arr) {
        int threadCount = Runtime.getRuntime().availableProcessors();
        ParallelSumHelper[] threads = new ParallelSumHelper[threadCount];
        int sliceLength = (int) Math.ceil(arr.length / threadCount);
        for (int i = 0; i < threads.length; i++) {
            ParallelSumHelper t = new ParallelSumHelper(arr, i * sliceLength, (i + 1) * sliceLength);
            threads[i] = t;
            t.start();
        }
        int sum = 0;
        for (ParallelSumHelper t : threads) {
            sum += t.getPartialSum();
        }
        return sum;
    }

    public static int[] generateRandomArray(int size, int maximumValue) {
        // The array's sum must not exceed Java's integer limit
        try {
            Math.multiplyExact(size, maximumValue);
        } catch (ArithmeticException e) {
            System.err.printf("WARNING: Array (%d * %d) is too large. Maximum possible sum must be less than %,d\n", 
                    size, maximumValue, Integer.MAX_VALUE);
            return new int[0];
        }

        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(maximumValue + 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        final int SIZE = 100000;
        final int MAX = 20000;
        // Create a random array
        int[] bigRandomArray = generateRandomArray(SIZE, MAX);
        System.out.printf("ARRAY: %,d random elements - RANGE: (0 to %,d)\n", SIZE, MAX);
        System.out.printf("PARALLEL SUM: %,d\n", getParallelSum(bigRandomArray));
    }
}