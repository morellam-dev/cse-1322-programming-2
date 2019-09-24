package module_4.lab_4a;

/**
 * VowelCounter
 */
public class VowelCounter {

    public static int vowelCount(String str) {
        return vowelCount(str, 0);
    }

    public static int vowelCount(String str, int index) {
        // EXIT CASE: We've reached the end of the string.
        if (index >= str.length()) {
            return 0;
        }
        char ch = str.charAt(index);
        if  (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            // RECURSE CASE 1: Vowel found, add 1 to total
            return 1 + vowelCount(str, index + 1);
        } else {
            // RECURSE CASE 2: Vowel not found, add 0 to total
            return vowelCount(str, index + 1);
        }     
    }

    public static void main(String[] args) {
        System.out.println("=== RECURSIVE VOWEL COUNTER DEMO ===");

        final String[] demoStrings = {
            "queueing", "buffalo", "hachi machi", "hello world", "bienvenue", "power bottoms"
        };
        for (String s : demoStrings) {
            System.out.println("vowelCount(\"" + s + "\") => " + vowelCount(s));
        }
    }

}