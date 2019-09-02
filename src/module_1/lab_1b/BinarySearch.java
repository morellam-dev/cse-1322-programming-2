package module_1.lab_1b;
import java.util.Arrays; // Arrays.sort() is used to sort input arrays

/**
 * Lab 1B Binary Search - M. Morella (2019)
 * Demonstrates a simple recursive binary search method.
 */
public class BinarySearch {

  /**
   * Performs a recursive binary search and returns the index of the given key
   * If no key is found, then return -(i + 1)
   * @param arr An array of integers to search
   * @param key The value being searched for
   * @return The first index where key is found.
   */
  public static int binarySearch(int[] arr, int key) {
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    return binarySearchHelper(sorted, key, 0, sorted.length);
  }
  /** 
   * Recursively iterate over smaller and smaller subarrays
   * Pre-condition: The array is sorted
   * @param arr The array to search
   * @param key The value to search for
   * @param start The index to begin searching at
   * @param end The index to stop searching at
   */
  public static int binarySearchHelper(int[] arr, int key, int start, int end) {
    // i: Insertion point, located at the midpoint of the subarray.
    int i = (start + end) / 2;

    // End case 1: KEY was found
    if (arr[i] == key)
      return i;
    // End case 2: KEY was not found
    if (start >= end)
      return -(i + 1);
    // Recursive case 1: If key is before the index
    if (key < arr[i]) {
      // Search again on range [start...i)
      return binarySearchHelper(arr, key, start, i - 1);
    }
    // Recursive case 2: The key is after the index
    if (arr[i] < key)
      // Search again on range (i...end]
      return binarySearchHelper(arr, key, i + 1, end);
    // This code should be unreachable under normal circumstances
    return -(i + 1);
  }

  /**
   * Generate an array filled with random integer values
   * Implementation copied from my response to previous lab module
   * @param len The desired length of the random array
   * @param min The lower bound of values to use
   * @param max The upper bound of values to use (exclusive)
   * @return An array of random integers with range [min...max)
   */
  public static int[] randomArray(int len, int min, int max) {
    int[] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      double rand = (Math.random()) * (max - min) + min;
      arr[i] = (int)rand;
    }
    return arr;
  }

  public static void main(String[] args) {
    // int[] nums = new int[]{10, 12, 13, 14, 15, 16, 17};
    int[] data = randomArray(20, -100, 100);
    Arrays.sort(data);
    System.out.println("int[] data: " + Arrays.toString(data));
    System.out.println("binarySearch(data, 10) => " + binarySearch(data, 10));
  }
}