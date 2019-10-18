package module_4.lab_4b;

import java.util.HashMap;
import java.util.Map;

/**
 * An emoji-rich console-based app which iterates over a map of palindromes, and determines
 * whether the isPalindrome() method returns the expected result.
 * @author M Morella
 */
public class PalindromeCheckerTests {
    private final static HashMap<String, Boolean> WORD_TESTS = new HashMap<>(Map.of(
        // test string –– expected value of isPalindrome()
        "", true,
        "a", true,
        "abca", false,
        "abba", true,
        "aloha ahola", true,
        "atlanta", false,
        "toy boat", false,
        "bananab", true
    ));
    private final static HashMap<String, Boolean> SENTENCE_TESTS = new HashMap<>(Map.of(
        // test string –– expected value
        "Able was I, ere I saw Elba", true,
        "Hello world", false,
        "Madam, I'm Adam.", true,
        "This isn't a palindrome", false, 
        "No 'x' in Nixon?", true,
        "This sentence is not a palindrome.", false,
        "Was it a car or a cat I saw?", true,
        "Woh! OwO OwO. How?", true,
        "NOTICE: This test is expected to fail", true
    ));

    public static boolean palindromeTest(String palindrome, boolean expectedValue) {
        boolean isPalindrome, testPassed;
        try {
            isPalindrome = PalindromeChecker.isPalindrome(palindrome);
            testPassed = (isPalindrome == expectedValue);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (!testPassed) {
            System.out.print("❌  ");
        } else {
            System.out.print(isPalindrome ? "✅  " : "❎  ");
        }
        
        System.out.print("\"" + palindrome + "\" -> " + (isPalindrome ? "TRUE" : "FALSE") + "; ");
        System.out.println("expected " + (expectedValue ? "TRUE" : "FALSE"));
        return testPassed;
    }

    public static void runTests(HashMap<String, Boolean> tests) {
        int testCount = 0;
        int passCount = 0;
        for (Map.Entry<String, Boolean> t : tests.entrySet()) {
            testCount++;
            String str = t.getKey();
            boolean expectedValue = t.getValue();
            boolean pass = palindromeTest(str, expectedValue);
            if (pass) {
                passCount++;
            }
        }
        System.out.println(passCount + " out of " + testCount + " tests passed\n");
    }

    public static void main(String[] args) {
        System.out.println("=== LEGEND ===\n"
        + "✅ — \"test passed, palindrome detected as expected\"\n"
        + "❎ — \"test passed, no palindrome detected, as expected\"\n"
        + "❌ — \"test failed! isPalindrome did not return expected value\"\n");
        
        System.out.println();
        System.out.println("=== PALINDROME TEST #1 (SIMPLE WORDS) ===");
        runTests(WORD_TESTS);
        System.out.println("=== PALINDROME TEST #2 (COMPLEX SENTENCES) ===");
        runTests(SENTENCE_TESTS);
    }
}
/* CONSOLE OUTPUT:

=== LEGEND ===
✅ — "test passed, palindrome detected as expected"
❎ — "test passed, no palindrome detected, as expected"
❌ — "test failed! isPalindrome did not return expected value"


=== PALINDROME TEST #1 (SIMPLE WORDS) ===
✅  "" -> TRUE; expected TRUE
✅  "a" -> TRUE; expected TRUE
❎  "abca" -> FALSE; expected FALSE
✅  "aloha ahola" -> TRUE; expected TRUE
❎  "toy boat" -> FALSE; expected FALSE
✅  "bananab" -> TRUE; expected TRUE
❎  "atlanta" -> FALSE; expected FALSE
✅  "abba" -> TRUE; expected TRUE
8 out of 8 tests passed

=== PALINDROME TEST #2 (COMPLEX SENTENCES) ===
✅  "Able was I, ere I saw Elba" -> TRUE; expected TRUE
❌  "NOTICE: This test is expected to fail" -> FALSE; expected TRUE
✅  "No 'x' in Nixon?" -> TRUE; expected TRUE
✅  "Was it a car or a cat I saw?" -> TRUE; expected TRUE
❎  "This sentence is not a palindrome." -> FALSE; expected FALSE
✅  "Madam, I'm Adam." -> TRUE; expected TRUE
❎  "This isn't a palindrome" -> FALSE; expected FALSE
✅  "Woh! OwO OwO. How?" -> TRUE; expected TRUE
❎  "Hello world" -> FALSE; expected FALSE
8 out of 9 tests passed
*/