package module_4.assignment_4;
/**
 * SumOfSums
 */
public class SumOfSums {

    /**
     * Return a "sum of sums" found by adding together the value of an array element
     * with every element after it, then repeating at the next index.
     * 
     * @param arr An array of integers to sum
     * @return For the values between {@code a0} and {@code n} located from {@code arr[0]} to {@code arr[n]}, the sum of sums
     * equals {@code Σ(a0..n) + Σ(a1..an) + Σ(a2..n) ... Σ(n..n)}
     */
    public static int sumOfSums(int[] arr) {
        return sumOfSums(arr, 0);
    }

    private static int sumOfSums(int[] arr, int index) {
        if (index == arr.length) return 0;
        int sums = sumOfSums(arr, 1 + index);
        for (int i = index; i < arr.length; i++) {
            sums += arr[i];
        }
        return sums;
    }
    /* An alternate solution could be accomplished without the index variable,
    though this would require execting Array.copyOfRange, or some other cloning method,
    on every iteration which would be extremely inefficient.
    */
}