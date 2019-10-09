package module_4.lab_4a;

/**
 * VowelCounter
 */
public class VowelCounter {
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    /**
     * Uses recursive methods to count the number of vowels (a-e-i-o-u) in a word or phrase
     * @param str The string to count
     * @return The number of vowels to count
     */
    public static int vowelCount(String str) {
        if (str.length() == 0)
            return 0;
        int count = vowelCount(str.substring(1)); // Recurse until string is empty
        if (str.substring(0, 1).matches("[aeiouAEIOU]")) // check the first character in the string
            return count + 1;
        return count;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("=== RECURSIVE VOWEL COUNTER DEMO ===");

        final String[] demoStrings = {
            "aaa", "aab", "queueing", "buffalo", "hachi machi", "hello world", "bienvenue", "power bottoms"
        };
        for (String s : demoStrings) {
            System.out.printf("vowelCount(\"%s\") => %d\n", s, vowelCount(s));
        }
    }

}