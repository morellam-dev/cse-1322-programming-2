package module_4.lab_4b;

/**
 * PalindromeChecker
 * 
 * @author M Morella
 */
public class PalindromeChecker {
    /**
     * Detects palindromic words and phrases using a recursive method. A palindrome
     * is defined as any string which is the same forward as it is backward.
     * {@code "abba"}, {@code "madamimadam"}, {@code "aa"}, and
     * {@code ""} are all considered valid palindromes.
     * 
     * @param str A string which may or may not contain a palindrome
     * @return Whether or not the input is a valid palindrome
     */

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            // If string is 1 or 0 chars long ("_a_" or "__")
            return true;
        }
        int lastIndex = str.length() - 1; // the index of the last character in the array
        if (!(str.charAt(0) == str.charAt(lastIndex))) {
            return false;
        }
        String sub = str.substring(1, lastIndex); // slice off the first and last character of the string.
        return isPalindrome(sub);
    }

    public static boolean isPalindromeClean(String str) {
        return isPalindrome(cleanString(str));
    }

    public static String cleanString(String str) {
        return str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    }
}