package module_1.lab_1b;
import java.util.Arrays; // Arrays.toString(int[]) is used to print array contents.

/**
 * Lab 1B Linear Search - M. Morella (2019) Demonstrates a simple linear search
 * method.
 */
public class LinearSearch {
  /**
   * Performs a linear search and returns the index of the key
   * @param arr An array of integers to search
   * @param key The value being searched for
   * @param start The index to begin searching at (inclusive)
   * @return The first index where key appears. Returns -1 if not found.
   */
  public static int linearSearch(int[] arr, int key, int start) {
    for (int i = start; i < arr.length; i++) {
      if (arr[i] == key) {
        return i;
      }
    }
    return -1;
  }
  public static int linearSearch(int[] arr, int key) {
    return linearSearch(arr, key, 0);
  }

  /**
   * Search an array for a key, and print all results
   * If more than one result, also print the number of results found
   */
  public static void linearSearchDemo(int[] arr, int key) {
    int index = -1;
    int foundCount = 0;

    while(linearSearch(arr, key, index + 1) != -1) {
      index = linearSearch(arr, key, index + 1);
      System.out.println("Value " + key + " found at index [" + index + "]");
      foundCount++;
    }
    if (foundCount > 1) {
      System.out.println("Value " + key + " was found " + foundCount + " times");
    }
    if (foundCount == 0) {
      System.out.println("Value " + key + " not found in array.");
    }
  }
  /**
   * Generate an array filled with random integer values
   * Implementation copied from my response to previous lab module
   * @param len The desired length of the random array
   * @param min The lower bound of values to use
   * @param max The upper bound of values to use (exclusive)
   * @return An array of random integers [min, max)
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
    // int[] nums = new int[]{1, 4, 4, 22, -5, 10, 21, -47, 23};
    int[] data = randomArray(20, 0, 20);
    System.out.println(Arrays.toString(data));
    linearSearchDemo(data, 10);
  }
}
