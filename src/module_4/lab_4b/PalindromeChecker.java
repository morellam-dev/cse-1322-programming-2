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
    public static boolean isPalindrome(String sentence) {
        String str = sentence.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "");
        if (str.length() < 2) {
            return false;
        }
        return isPalindromeHelper(str, 0, str.length() - 1);
    }

    // Recursive method
    private static boolean isPalindromeHelper(String str, int indexBegin, int indexEnd) {
        // End case 1: the characters at the two indexes are not equal.
        if (str.charAt(indexBegin) != str.charAt(indexEnd))
            return false;
        // End case 2: the string has reached the middle, and all checks so far have
        // returned true.
        if (indexBegin >= indexEnd)
            return true;
        return isPalindromeHelper(str, ++indexBegin, --indexEnd);
    }

    public static void main(String[] args) {
        String[] tests = {
                "Madam, I'm Adam.", 
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
            System.out.println("isPalindrome(\"" + str + "\") => " + isPalindrome(str));
        }
    }
}