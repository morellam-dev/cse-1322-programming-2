package module_7.lab_7a;

import java.util.Random;

/**
 * Performs experiments, comparing the speed of single-threaded vs. multithreaded
 * summing algorithms. 
 */
public class ConcurrentSumTest {

    public static final int TRIAL_COUNT = 10;

    public static void main(String[] args) {
        pause();
        runExperiment(100000, 10);
        pause();
        runExperiment(1000000, 10);
        pause();
        runExperiment(10000000, 10);
        pause();
        runExperiment(100000000, 10);
        pause();
        runExperiment(500000000, 10);
    }

    public static int[] generateIntArray(int size, int maximumValue) {
        int[] arr = new int[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(maximumValue + 1);
        }
        return arr;
    }

    public static short[] generateShortArray(int size, short maximumValue) {
        short[] arr = new short[size];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (short)r.nextInt(maximumValue + 1);
        }
        return arr;
    }

    public static void pause() {
        try {
            System.out.print("Press enter to continue...");
            System.in.read();
            System.out.println();
        } catch (java.io.IOException e) {} 
    }

    public static void runExperiment(int size, int bound) {
        int[] linearTimes = new int[TRIAL_COUNT];
        int[] concurrentTimes = new int[TRIAL_COUNT];

        System.out.printf("==== MULTITHREADING TESTS (ARRAY SIZE: %,d - BOUND: %,d) ====\n\n",
                size, bound);
        try {
            for (int i = 0; i < TRIAL_COUNT; i++) {
            // Create a random array
            int arrayDuration = (int)System.currentTimeMillis();
            short[] bigRandomArray = generateShortArray(size, (short)bound);
            arrayDuration = (int)System.currentTimeMillis() - arrayDuration;
            System.out.printf("===== TRIAL #%d =====\n", i + 1);
            System.out.printf("%15s %,d (took %,d ms)\n", "ARRAY LENGTH:", size, arrayDuration);
            linearTimes[i] = linearTimeTrial(bigRandomArray);
            concurrentTimes[i] = concurrentTimeTrial(bigRandomArray);
            System.out.println();
            bigRandomArray = null;
            System.gc(); // garbage collect, in the hopes of freeing up memory
            }
        } catch (java.lang.OutOfMemoryError e) {
            e.printStackTrace();
        }
        
        System.out.printf("==== MULTITHREADING TESTS (ARRAY SIZE: %,d - BOUND: %,d) ====\n\n", size, bound);
        System.out.println("==== AVERAGE TIME ====");
        System.out.printf("%15s %,d ms\n", "LINEAR AVG:", averageArray(linearTimes));
        System.out.printf("%15s %,d ms\n", "CONCURRENT AVG:", averageArray(concurrentTimes));

    }
    
    public static int averageArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }

    public static int linearTimeTrial(int[] arr) {
        // Calculate sum linearly
        int duration = (int) System.currentTimeMillis();
        long sum = ConcurrentSum.getLinearSum(arr);
        duration = (int) System.currentTimeMillis() - duration;
        System.out.printf("%15s %,d (in %d ms)\n", "LINEAR SUM:", sum, duration);
        return duration;
    }
    
    public static int linearTimeTrial(short[] arr) {
        // Calculate sum linearly
        int duration = (int) System.currentTimeMillis();
        long sum = ConcurrentSum.getLinearSum(arr);
        duration = (int) System.currentTimeMillis() - duration;
        System.out.printf("%15s %,d (in %d ms)\n", "LINEAR SUM:", sum, duration);
        return duration;
    }

    public static int concurrentTimeTrial(int[] arr) {
        int duration = (int) System.currentTimeMillis();
        long sum = ConcurrentSum.getConcurrentSum(arr);
        duration = (int) System.currentTimeMillis() - duration;
        System.out.printf("%15s %,d (in %d ms)\n", "CONCURRENT SUM:", sum, duration);
        return duration;
    }

    public static int concurrentTimeTrial(short[] arr) {
        int duration = (int) System.currentTimeMillis();
        long sum = ConcurrentSum.getConcurrentSum(arr);
        duration = (int) System.currentTimeMillis() - duration;
        System.out.printf("%15s %,d (in %d ms)\n", "CONCURRENT SUM:", sum, duration);
        return duration;
    }
}