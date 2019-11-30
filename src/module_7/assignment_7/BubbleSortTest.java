package module_7.assignment_7;

import java.util.Arrays;
import java.util.Random;

import java.time.Duration;

/**
 * Performs verbose experiments, comparing the speed at which the serial and
 * parallel bubblesort algorithms can sort a large array of random integers.
 * 
 * @author M Morella
 * @implSpec On my own dual-core machine, parallel sorting only begins to
 *           outperform the serial algorithm at array sizes above 40,000 items.
 */
public class BubbleSortTest {
    /**
     * Generates an array of random integers.
     * 
     * @param size  The length of the array to generate
     * @param bound The upper bound (exclusive) of the random integers
     * @return An array with {@code size} elements within the range {@code [0, bound)}
     */
    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
    /** 
     * Determines the length of time required to sort an array using the parallel algorithm
     * @return the time (in milliseconds) that the operation took 
     */
    public static long parallelTrial(int[] arr) {
        int processors = Runtime.getRuntime().availableProcessors();
        int[] sorted = arr.clone();
        // TIMER START
        long startTime = System.nanoTime();
        BubbleSort.parallelSort(sorted);
        long endTime = System.nanoTime();
        // TIMER STOP
        double durationSeconds = (double)Duration.ofNanos(endTime - startTime).toMillis() / 1000;
        boolean success = isArraySorted(sorted) && arraysSameElements(arr, sorted);
        System.out.printf("%15s %s (took %.2f s) (%d threads)\n", 
                "PARALLEL SORT:", success ? "success" : "failed", durationSeconds, processors);
        return Duration.ofNanos(endTime - startTime).toMillis();
    }

    /**
     * Determines the length of time required to sort an array using the serial algorithm
     * @return the time (in milliseconds) that the operation took
     */
    public static long serialTrial(int[] arr) {
        int[] sorted = arr.clone();
        // TIMER START
        long startTime = System.nanoTime();
        BubbleSort.serialSort(sorted);
        long endTime = System.nanoTime();
        // TIMER STOP

        boolean success = isArraySorted(sorted) && arraysSameElements(arr, sorted);
        double durationSeconds = (double)Duration.ofNanos(endTime - startTime).toMillis() / 1000;
        System.out.printf("%15s %s (took %.2f s) (%d threads)\n", 
                "SERIAL SORT:", success ? "success" : "failed", durationSeconds, 1);
        return Duration.ofNanos(endTime - startTime).toMillis();
    }

    /**
     * A verbose wrapper for the {@code  generateRandomArray} method, which prints the 
     * size of the array, and the amount of time required to generate it.
     * 
     * @return a random array with the given bounds
     */
    private static int[] generateRandomArrayTimed(int size, int bound) {
        long startTime = System.nanoTime();
        int[] array = generateRandomArray(size, bound);
        long endTime = System.nanoTime();
        double durationSeconds = (double)Duration.ofNanos(endTime - startTime).toMillis() / 1000;
        System.out.printf("%15s %,d (took %.3f s)\n", "ARRAY SIZE:", size, durationSeconds);
        return array;
    }

    public static double averageArray(long[] arr) {
        int sum = 0;
        for (long num : arr) {
            sum += num;
        }
        return (double)sum / arr.length;
    }

    public static void timeTest(int trials, int size, int bound) {

        long[] serialResults = new long[trials];
        long[] parallelResults = new long[trials];
        for (int i = 0; i < trials; i++) {
            System.out.println();

            System.out.printf("==== TRIAL #%d ====\n", i + 1);
            int[] array = generateRandomArrayTimed(size, bound);
            serialResults[i] = serialTrial(array);
            System.gc();
            parallelResults[i] = parallelTrial(array);
            System.gc();
            sleep(500);            
        }
        System.out.println();
        System.out.printf("==== TEST RESULTS (%,d elements) ====\n", size);
        double serialAverage = averageArray(serialResults);
        double parallelAverage = averageArray(parallelResults);
        System.out.printf("  %19S %.2f s\n", "PARALLEL AVG TIME:", (double) parallelAverage / 1000);
        System.out.printf("  %19S %.2f s\n", "SERIAL AVG TIME:", (double) serialAverage / 1000);
        System.out.printf("Parallel sort took %.2f times as long as serial sort\n", ((double)parallelAverage / serialAverage));
        System.out.println();
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    private static void pause() {
        try {
            System.out.print("Press enter to continue...");
            System.in.read();
            System.out.println();
        } catch (java.io.IOException e) {}
    }

    /** @return true if the arrays are identical after sorting (i.e. they contain the same elements) */
    public static boolean arraysSameElements(int[] a1, int[] a2) {
        a1 = a1.clone();
        a2 = a2.clone();
        Arrays.sort(a1); 
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
    
    /** @return {@code true} if all elements within the given range are sorted */
    public static boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        timeTest(10, 10000, 10);
        pause();
        timeTest(10, 20000, 10);
        pause();
        timeTest(10, 40000, 10);
        pause();
        timeTest(10, 80000, 10);
        pause();
        timeTest(10, 100000, 10);
    }
}