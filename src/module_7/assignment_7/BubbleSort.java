package module_7.assignment_7;

/**
 * BubbleSort
 */
public class BubbleSort {


    /** @return {@code true} if all elements within the given range are sorted */
    public static boolean isArraySorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    /** Bubble sort the elements of the array within the given range. */
    public static void bubbleSortSerial(int[] arr) {
        while (true) {
            boolean isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    // Switch positions of unsorted elements.
                    int first = arr[i];
                    int second = arr[i + 1];
                    arr[i] = second;
                    arr[i + 1] = first;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    public static int[] bubbleSortParallel(int[] arr) {
        // arr = arr.clone();
        final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[THREAD_COUNT];
        // int sliceLength = (int)Math.ceil(arr.length / threads.length);

        // int offset = (int)Math.ceil(arr.length / threads.length);
        for (int i = 0; i < threads.length; i++) {
            // final int index = i;
            Thread t = new Thread(
                () -> bubbleSortSerial(arr)
            );
            threads[i] = t;
            t.start();
        }
        try {
            for (Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arr;
    }
}