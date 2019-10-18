package module_4.assignment_4;

/**
 * A simple demonstration of recursive methods, which prints 
 * a string, then prints a string in reverse.
 * @author M Morella
 */
public class StringReverser {
    /**
     * Prints a string to the console, character by character.
     * @param str A string
     */
    public static void printString(String str) {
        if (str.length() == 0) {
            System.out.print('\n');
        } else {
            System.out.print(str.charAt(0));
            printString(str.substring(1));
        }
    }
    /**
     * Prints a string to the console in reverse. For instance, {@code "Hello world!"} 
     * results in printing {@code "!dlrow olleH"}
     * @param str
     */
    public static void printStringReverse(String str) {
        if (str.length() == 0) {
            System.out.print('\n');
        } else {
            char lastChar = str.charAt(str.length() - 1);
            System.out.print(lastChar);
            printStringReverse(str.substring(0, str.length() - 1));
        }
    }
    /** 
     * Demonstrates the "Hello world!" example shown in the assignemnt instructions.
     * Outputs to the console, <code>"Hello world!"</code> and <code>"!dlrow olleH"</code>
     */
    public static void main(String[] args) {
        System.out.println();
        String demo = "Hello world!";
        printString(demo); 
        // -> "Hello world!"
        printStringReverse(demo); 
        // -> "!dlrow olleH"
        
    }
}
