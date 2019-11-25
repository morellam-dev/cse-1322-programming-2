package module_7.assignment_7;

import java.util.concurrent.*;

/**
 * BubbleSorter
 */
public class BubbleSort {
    private int[] arr;
    private boolean sorted;
    public static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    public BubbleSort(int[] arr) {
        this.arr = arr;
        sorted = false;
    }

    public static int[] sort(int[] a) {
        BubbleSort sorter = new BubbleSort(a.clone());
        sorter.bubbleSort();
        return sorter.arr;
    }

    public static int[] sortSerial(int[] a) {
        a = a.clone();
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
        return a;
    }

    private void bubbleSort() {
        // Create threadpool
        ForkJoinPool pool = new ForkJoinPool(THREAD_COUNT);
        // For each thread, start a thread which begins sorting part of the array
        final int sliceLength = (int) Math.ceil(arr.length / THREAD_COUNT);
        sorted = false;
        // Alternate between even/odd 
        while (!sorted) {
            sorted = true;
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < THREAD_COUNT; i++) {
                    int start = i * sliceLength + k;
                    int end = Math.min((i + 1) * sliceLength, arr.length - 1);
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
                    pool.execute(task);
                }
                pool.awaitQuiescence(3000, TimeUnit.MILLISECONDS);
            }
        }
        pool.shutdown();
    }

}