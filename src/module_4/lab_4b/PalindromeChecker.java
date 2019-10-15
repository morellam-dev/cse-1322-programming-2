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
        if (str.length() < 2) return true;

        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        if (first == last) {
            String inner = str.substring(1, str.length() - 1);
            return isPalindromeRecursive(inner);
        } else {
            return false;
        }
    }
}