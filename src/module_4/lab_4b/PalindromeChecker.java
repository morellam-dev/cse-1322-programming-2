package module_4.lab_4b;

/**
 * PalindromeChecker
 * @author M Morella
 */
public class PalindromeChecker {
    /**
     * Detects palindromic words and phrases using a recursive method which ignores non-alphanumeric characters. 
     * A palindrome is defined as a string at least 2 characters long, which is the same forward as it is backward.
     * is converted to {@code "madamimadam"}, and is considered a valid palindrome.
     * 
     * @param str A string which may or may not contain a palindrome
     * @return Whether or not the input is a valid palindrome
     */

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }
        int end = str.length() - 1; // the index of the last character in the array
        if (str.charAt(0) == str.charAt(end)) {
            String sub = str.substring(1, end);
            return isPalindrome(sub);
        }
        return false;
    }

    public static String clean(String str) {
        return str.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void main(String[] args) {
        String[] tests = {
                "abba",
                "abcba",
                "atlanta",
                "Madam, I'm Adam.", "This isn't a palindrome",
                "Woh! OwO OwO. How?", 
                "No 'x' in Nixon?", 
                "Able was I, ere I saw Elba",
                "Was it a car or a cat I saw?",
                "aloha ahola", 
                "Hello world", 
                "bananab",
                "This sentence is not a palindrome.", 
                };
        for (String str : tests) {
            System.out.println("\"" + str + "\" -- \"" + clean(str) + "\" " 
            + (isPalindrome(clean(str)) ? "IS a palindrome" : "is NOT a palindrome"));
        }
    }
}