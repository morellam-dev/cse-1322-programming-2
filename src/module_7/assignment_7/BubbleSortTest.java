package module_7.assignment_7;

import java.util.Random;

/**
 * BubbleSortTest
 */
public class BubbleSortTest {
    public static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }
    /** @return the time (in milliseconds) that the operation took */
    public static int parallelTrial(int[] arr) {
        int[] sorted = arr.clone();
        int duration = (int) System.currentTimeMillis();
        int processors = Runtime.getRuntime().availableProcessors();
        // TIMER START
        BubbleSort.bubbleSortParallel(sorted);
        // TIMER STOP
        duration = (int) System.currentTimeMillis() - duration;
        boolean success = BubbleSort.isArraySorted(sorted);

        System.out.printf("%15s %s (took %.2f s) (%d threads)\n", "PARALLEL SORT:", success ? "success" : "failed", 
                (double) duration / 1000, processors);
        return duration;
    }

    /** @return the time (in milliseconds) that the operation took */
    public static int serialTrial(int[] arr) {
        int[] sorted = arr.clone();
        int duration = (int) System.currentTimeMillis();
        // TIMER START
        BubbleSort.bubbleSortSerial(sorted);
        // TIMER STOP
        duration = (int) System.currentTimeMillis() - duration;
        boolean success = BubbleSort.isArraySorted(sorted);
        System.out.printf("%15s %s (took %.2f s) (1 thread )\n", "SERIAL SORT:", success ? "success" : "failed", (double)duration / 1000);
        return duration;
    }

    /** @return a random array with the given bounds */
    public static int[] generateArray(int size, int bound) {
        int duration = (int) System.currentTimeMillis();
        int[] array = generateRandomArray(size, bound);
        duration = (int) System.currentTimeMillis() - duration;
        System.out.printf("%15s %,d (took %.2f s)\n", "ARRAY SIZE:", size, (double) duration / 1000);
        return array;
    }

    public static double averageArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double)sum / arr.length;
    }

    public static void timeTest(int trials, int size, int bound) {

        int[] serialResults = new int[trials];
        int[] parallelResults = new int[trials];
        for (int i = 0; i < trials; i++) {
            System.out.println();

            System.out.printf("==== TRIAL #%d ====\n", i + 1);
            int[] array = generateArray(size, bound);
            parallelResults[i] = parallelTrial(array);
            serialResults[i] = serialTrial(array);
            sleep(500);            
        }
        System.out.println();
        System.out.printf("==== TEST RESULTS (%,d elements) ====\n", size);
        double serialAverage = averageArray(serialResults);
        double parallelAverage = averageArray(parallelResults);
        System.out.printf("%15S %.2f s\n", "PARALLEL AVG TIME:", (double) parallelAverage / 1000);
        System.out.printf("%15S %.2f s\n", "SERIAL AVG TIME:", (double) serialAverage / 1000);
        System.out.printf("Parallel sort was %.2f times faster\n", ((double)serialAverage / parallelAverage));
        System.out.println();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    public static void pause() {
        try {
            System.out.print("Press enter to continue...");
            System.in.read();
            System.out.println();
        } catch (java.io.IOException e) {}
    }

    public static void main(String[] args) {
        timeTest(10, 10000, 10);
        pause();
        timeTest(10, 20000, 10);
        pause();
        timeTest(10, 40000, 10);
        pause();
        timeTest(10, 80000, 10);
    }
}