package module_4.lab_4b;

/**
 * PalindromeChecker
 * @author M Morella
 * @since
 */
public class PalindromeChecker {
    /**
     * Detects palindromic words using a recursive method. A palindrome is defined as any
     * string, which, when all its characters are reversed, produces the same
     * string. As such, both {@code "a"} and {@code ""} are considered valid palindromes.
     * 
     * @param str A string which may or may not contain a palindrome
     * @return Whether or not the input is a valid palindrome
     */
    public static boolean isPalindrome(String word) {
        // Exit case 1: the substring is less than 2 characters.
        if (word.length() < 2) {
            return true;
        }
        
        char firstChar = word.charAt(0);
        char lastChar = word.charAt(word.length() - 1);

        /* Recursive case: If the first and last characters match, 
        then recurse on a substring which excludes the outermost characters. */
        if (firstChar == lastChar) {
            String internal = word.substring(1, word.length() - 1); // "madam" => "ada" => "d"
            return isPalindrome(internal);
        }
        // Exit case 2: the first and last characters do not match.
        return false;
    }

    /**
     * Performs the same functionality as `isPalindrome`, but mutates the input string to 
     * remove all spaces and punctuation. This allows more complicated palindromes like
     * "No 'x' in Nixon" to return true.
     * @param str A string to test.
     * @return Whether or not the string is a palindrome
     */
    public static boolean isPalindromeClean(String sentence) {
        // Remove all non-alphanumeric characters, trim and make lowercase.
        String simplified = sentence.toLowerCase().trim().replaceAll("[^a-zA-Z0-9]", "");
        return isPalindrome(simplified);
    }

    public static void main(String[] args) {
        String[] tests = {
                "Madam, I'm Adam.", 
                "Woh! OwO OwO. How?", 
                "No 'x' in Nixon?", 
                "Able was I, ere I saw Elba",
                "Hello world", 
                "aloha ahola", 
                "bananab",
                "This sentence is not a palindrome.", 
                "Was it a car or a cat I saw?"};
        for (String str : tests) {
            System.out.println("isPalindromeClean(\"" + str + "\") => " + isPalindromeClean(str));
        }
    }
}