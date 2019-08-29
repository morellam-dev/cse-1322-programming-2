package lab_1a;

/**
 * M Morella
 * Lab 1A - Array Operations
 * Demonstrate basic functions for manipulating arrays
 */
public class ArrayOperations {
    /** Convert an array's contents as a JSON-style string
     * @param arr An integer array to display.
     * @return A string formatted like "[3, -2, 7]"
     */
    public static String arrayToString(int[] arr) {
        String children = "";
        for (int i = 0; i < arr.length; i++) {
            // Append number
            children += arr[i];
            if (i < arr.length - 1) {
                children += ", ";
            }
        }
        return "[" + children + "]";
    }
    /** Search an array and return the largest value 
     * @param arr The array of integers, with at least one element
     * @return The largest value found in the array.
    */
    public static int findLargest(int[] arr) {
        int largest = arr[0];
        for (int el : arr) {
            largest = Math.max(el, largest);
        }
        return largest;
    }
    /** Generate an array filled with random integer values
     * @param len The desired length of the random array
     * @param min The lower bound of values to use
     * @param max The upper bound of values to use (exclusive)
     * @return An int[] array of random integers [min, max)
     */
    public static int[] randomArray(int len, int min, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            // Random number between min and max
            double rand = (Math.random()) * (max - min) + min;
            arr[i] = (int) rand;
        }
        return arr;
    }
    /**
     * Determine the length of the longest continuous series of positive integers. 
     * For example [-1, 8, 7, 5, -6] yields a length of 3
     * @param arr An array of at least one integer
     * @return The length of this streak
     */
    public static int positiveStreakLength(int[] arr) {
        int currentStreak = 0;
        int longestStreak = 0;
        for (int el : arr) {
            if (el > 0) {
                currentStreak++;
                longestStreak = Math.max(currentStreak, longestStreak);
            } else {
                currentStreak = 0;
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 13, 43, -25, 17, 22, -37, 29 };
        System.out.println("int[] nums = " + arrayToString(nums));

        /* Print the largest value in int[] nums */
        System.out.println("findLargest(nums) => " + findLargest(nums));
        System.out.println();

        /* Create an array called data and fill it with random numbers [-100, 100) */
        int[] data = randomArray(20, -100, 100);
        System.out.println("int[] data = " + arrayToString(data));

        /* Print the largest value in int[] data */
        System.out.println("findLargest(data) => " + findLargest(data));

        /* Print the sum of the largest values from nums and data */
        System.out.println("findLargest(nums) + findLargest(data) => " + (findLargest(nums) + findLargest(data)));

        /* Find the length of the longest continuous series of positive numbers */
        System.out.println("positiveStreakLength(data) == " + positiveStreakLength(data));
    }
}