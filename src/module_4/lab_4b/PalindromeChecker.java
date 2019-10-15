package module_4.lab_4b;

/**
 * PalindromeChecker
 * 
 * @author M Morella
 */
public class PalindromeChecker {

    /**
     * Detects palindromes using a recursive method. Ignores all spaces,
     * capitalization, and puncturation. For example, {@code "Madam I'm adam"} is
     * reduced to {@code "madamimadam"}, and returns {@code true}.
     * 
     * @param str The string to test
     * @return If the string is a valid palindrome, {@code true}. Otherwise {@code false}
     */
    public static boolean isPalindrome(String str) {
        String cleanString = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        return isPalindromeRecursive(cleanString);
    }

    private static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1) {
            // If string is 1 or 0 chars long ("_a_" or "__")
            return true;
        }
        int lastIndex = str.length() - 1; // the index of the last character in the array
        if (!(str.charAt(0) == str.charAt(lastIndex))) {
            return false;
        }
        String sub = str.substring(1, lastIndex); // slice off the first and last character of the string.
        return isPalindromeRecursive(sub);
    }
}