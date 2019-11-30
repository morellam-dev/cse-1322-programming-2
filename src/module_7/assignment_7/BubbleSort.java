/*
 * Live demo: https://repl.it/@MaxMorella/Assignment-7-Bubble-Sort
 */

package module_7.assignment_7;

import java.util.concurrent.*;

/**
 * Provides static methods, implementing a bubble sort using both 
 * a serial algorithm (linear bubble sort) and a parallel algorithm (even-odd transposition).
 */
public class BubbleSort {
    private int[] arr;
    private boolean sorted;
    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    private BubbleSort(int[] arr) {
        this.arr = arr;
        sorted = false;
    }
    /**
     * Sorts the specified array into ascending numerical order 
     * using a highly inefficient bubble sorting algorithm.
     * 
     * @param a The array to sort
     */
    public static void parallelSort(int[] a) {
        BubbleSort sorter = new BubbleSort(a);
        sorter.bubbleSort();
    }

    /*
     * Parallel bubble sort algorithm:
     * 1) Divide all even pairs between worker threads. 
     * 2) The threads compare each pair, and swap them into the correct order.
     * 3) Wait for threads to complete, then repeat with odd pairs.
     * 4) If any thread performed a swap operation, then the array is not sorted.
     * 5) Repeat process until the array is sorted.
     */
    
    private void bubbleSort() {
        ForkJoinPool pool = new ForkJoinPool(); // Create threadpool
        final int THREAD_COUNT = pool.getParallelism();
        final int sliceLength = (int) Math.ceil(arr.length / THREAD_COUNT);
        sorted = false;
        while (!sorted) {
            sorted = true;
            for (int k = 0; k < 2; k++) { // Even pass, then odd pass
                for (int i = 0; i < THREAD_COUNT; i++) {
                    final int start = i * sliceLength + k;
                    final int end = Math.min((i + 1) * sliceLength, arr.length - 1);
                    Runnable task = () -> {
                        for (int j = start; j < end; j += 2) {
                            if (arr[j] > arr[j + 1]) {
                                int temp = arr[j];
                                arr[j] = arr[j + 1];
                                arr[j + 1] = temp;
                                sorted = false;
                            }
                        }
                    };
                    pool.execute(task); // Start thread
                }
                pool.awaitQuiescence(1000, TimeUnit.SECONDS); // Wait for threads to finish
            }
        }
        pool.shutdown();
    }

    /**
     * Sorts the specified array into ascending numerical order using a linear, 
     * single-threaded bubble sort algorithm.
     * 
     * @param a The array to sort
     */
    public static void serialSort(int[] a) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    sorted = false;
                    // Switch positions of unsorted elements.
                    int first = a[i];
                    int second = a[i + 1];
                    a[i] = second;
                    a[i + 1] = first;
                }
            }
        }
    }
}