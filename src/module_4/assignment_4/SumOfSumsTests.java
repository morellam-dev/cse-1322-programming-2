package module_4.assignment_4;

import java.util.Arrays;

/**
 * Performs unit tests on the {@code sumOfSums()} method to ensure output is as expected.
 * @author M Morella
 */
public class SumOfSumsTests {
    private static void testSumOfSums(int[] testArray, int expectedValue) {
        int actualValue = SumOfSums.sumOfSums(testArray);
        boolean testPassed = (actualValue == expectedValue);
        
        System.out.printf("TEST: sumOfSums(%1$s) -> %2$d", Arrays.toString(testArray), actualValue);
        System.out.println();
        System.out.printf(" - expected %1$d - returned %2$d", expectedValue, actualValue);
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
/*
CONSOLE OUTPUT:

TEST: sumOfSums([5, 18, 4, 7, 11]) -> 136
 - expected 136 - returned 136 – 👍  Test passed!
TEST: sumOfSums([50, 19, 1, -49, 3, 99, 3, 21, 63]) -> 1260
 - expected 1260 - returned 1260 – 👍  Test passed!
TEST: sumOfSums([]) -> 0
 - expected 0 - returned 0 – 👍  Test passed!
TEST: sumOfSums([1]) -> 1
 - expected 1 - returned 1 – 👍  Test passed!
TEST: sumOfSums([3, 2, 1]) -> 10
 - expected 10 - returned 10 – 👍  Test passed!

 */