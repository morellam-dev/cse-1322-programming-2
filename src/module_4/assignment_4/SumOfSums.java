package module_4.assignment_4;
/**
 * SumOfSums
 */
public class SumOfSums {

    /**
     * Return a "sum of sums" found by repeatedly compounding the values of an
     * array.
     * 
     * @param arr An array of integers to sum
     * @return For the values {@code arr[0]..arr[n]}, the sum of sums
     * equals {@code Σ[0,n] + Σ[1,n] + Σ[2,n] ... Σ[n,n]}
     */
    public static int sumOfSums(int[] arr) {
        return sumOfSums(arr, 0);
    }

    private static int sumOfSums(int[] arr, int index) {
        if (index == arr.length) return 0;
        int sums = sumOfSums(arr, 1 + index); // do sums from (i+1, n]
        for (int i = index; i < arr.length; i++) {
            sums += arr[i];
        }
        return sums;
    }
}