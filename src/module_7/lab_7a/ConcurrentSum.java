package module_7.lab_7a;

public class ConcurrentSum {
    public static long getLinearSum(int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static long getLinearSum(short[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     * Calculate a sum of the integers in an array, using multithreading.
     * 
     * @implNote This implementation uses four threads, and as such, is best optimized for quad-core processers. 
     * @param arr An array of integers
     * @return The sum of the numbers in the array
     */
    public static long getConcurrentSum(int[] arr) {
        long[] results = new long[3];
        int sliceLength = (int)Math.ceil(arr.length / 3);
        // Create threads, each of which sums one quarter of the array.
        
        Thread t1 = new Thread(() -> results[0] = getPartialSum(arr, sliceLength * 0, sliceLength));
        Thread t2 = new Thread(() -> results[1] = getPartialSum(arr, sliceLength * 1, sliceLength));
        Thread t3 = new Thread(() -> results[2] = getPartialSum(arr, sliceLength * 2, sliceLength * 2));
        // Start the threads
        t1.start(); t2.start(); t3.start();
        try {
            // Wait for all threads to finish
            t1.join(); t2.join(); t3.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        return results[0] + results[1] + results[2];
    }

    public static long getConcurrentSum(short[] arr) {
        long[] results = new long[3];
        int sliceLength = (int) Math.ceil(arr.length / 3);
        // Create threads, each of which sums one quarter of the array.
        Thread t1 = new Thread(() -> results[0] = getPartialSum(arr, sliceLength * 0, sliceLength));
        Thread t2 = new Thread(() -> results[1] = getPartialSum(arr, sliceLength * 1, sliceLength));
        Thread t3 = new Thread(() -> results[2] = getPartialSum(arr, sliceLength * 2, sliceLength + 1));
        // Start the threads
        t1.start();
        t2.start();
        t3.start();
        try {
            // Wait for all threads to finish
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        return results[0] + results[1] + results[2];
    }

    /**
     * Calculates the sum of all the elements within a segment of an array.
     * The search ends after the element with index {@code startIndex + sliceLength - 1}
     * @param arr An array of integers to search
     * @param startIndex The index to begin the count from
     * @param sliceLength The number of elements to include. 
     */
    private static long getPartialSum(int[] arr, int startIndex, int sliceLength) {
        long sum = 0;
        int endIndex = startIndex + sliceLength;
        for (int i = startIndex; i < endIndex && i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    /**
     * Calculates the sum of all the elements within a segment of an array. The
     * search ends after the element with index {@code startIndex + sliceLength - 1}
     * 
     * @param arr         An array of integers to search
     * @param startIndex  The index to begin the count from
     * @param sliceLength The number of elements to include.
     */
    private static long getPartialSum(short[] arr, int startIndex, int sliceLength) {
        long sum = 0;
        int endIndex = startIndex + sliceLength;
        for (int i = startIndex; i < endIndex && i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}