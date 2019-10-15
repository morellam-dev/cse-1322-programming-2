package module_4.assignment_4;

import java.util.Arrays;

/**
 * Performs manual unit tests on the SumOfSums class to ensure output is as expected.
 * @author M Morella
 */
public class SumOfSumsTests {
    private static void testSumOfSums(int[] testArray, int expectedValue) {
        int sum = SumOfSums.sumOfSums(testArray);
        boolean testPassed = (sum == expectedValue);
        
        System.out.printf("TEST: sumOfSums(%1$s) -> %2$d", Arrays.toString(testArray), sum);
        System.out.println();
        System.out.printf(" - expected %1$d - returned %2$d", expectedValue, sum);
        System.out.print(" – ");
        System.out.println(testPassed ? "👍  Test passed!" : "❌  Test failed!");
    }

    public static void main(String[] args) {
        testSumOfSums(new int[] { 5, 18, 4, 7, 11 }, 136);
        testSumOfSums(new int[] { 50, 19, 1, -49, 3, 99, 3, 21, 63 }, 1260);
        testSumOfSums(new int[] { }, 0);
        testSumOfSums(new int[] { 1 }, 1);
        testSumOfSums(new int[] { 3, 2, 1 }, 10);
    }
}