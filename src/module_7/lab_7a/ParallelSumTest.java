package module_7.lab_7a;

/**
 * ParallelSumTest
 */
public class ParallelSumTest {

    public static int averageArray(int[] arr) {
        return ParallelSum.getLinearSum(arr) / arr.length;
    }

    public static int linearTimeTrial(int[] arr) {
        // Calculate sum linearly
        int linearDuration = (int) System.currentTimeMillis();
        int linearSum = ParallelSum.getLinearSum(arr);
        linearDuration = (int) System.currentTimeMillis() - linearDuration;
        System.out.printf("LINEAR SUM: %,d (in %d ms)\n", linearSum, linearDuration);
        return linearDuration;
    }

    public static int parallelTimeTrial(int[] arr) {
        int parallelDuration = (int) System.currentTimeMillis();
        int parallelSum = ParallelSum.getParallelSum(arr);
        parallelDuration = (int) System.currentTimeMillis() - parallelDuration;
        System.out.printf("PARALLEL SUM: %,d (in %d ms)\n", parallelSum, parallelDuration);
        return parallelDuration;
    }

    public static void main(String[] args) {
        // Experiment with the
        final int ARRAY_SIZE = 100000000;
        final int MAXIMUM_VALUE = 5;
        final int TRIAL_COUNT = 10;

        int[] linearTimes = new int[TRIAL_COUNT];
        int[] parallelTimes = new int[TRIAL_COUNT];

        System.out.printf("==== TRIAL TESTS WITH %d PROCESSOR THREADS (%,d MB memory free) ====\n\n", 
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().freeMemory() / 1000000);

        for (int i = 0; i < TRIAL_COUNT; i++) {
            // Create a random array
            int[] bigRandomArray = ParallelSum.generateRandomArray(ARRAY_SIZE, MAXIMUM_VALUE);
            System.out.printf("==== TRIAL #%d ====\n", i + 1);
            System.out.printf("ARRAY: %,d random elements - RANGE: (0 to %,d)\n", ARRAY_SIZE, MAXIMUM_VALUE);
            linearTimes[i] = linearTimeTrial(bigRandomArray);
            parallelTimes[i] = parallelTimeTrial(bigRandomArray);   
            System.out.println();         
        }
        System.out.println("==== AVERAGE TIME ====");
        System.out.printf("LINEAR AVG: %,d ms\n", averageArray(linearTimes));
        System.out.printf("PARALLEL AVG: %,d ms\n", averageArray(parallelTimes));
    }
}