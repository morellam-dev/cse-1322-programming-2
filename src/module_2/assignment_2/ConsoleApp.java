package module_2.assignment_2;

import java.util.Scanner;

/**
 * ConsoleApp
 * Provides helper methods for reading user input from the console.
 * Allows for input validation and default values
 */
public class ConsoleApp {
    public static final Scanner console = new Scanner(System.in);
    /**
     * Prompt the user for input and return a <code>String</code>
     * 
     * @param prompt        The text to show before the user's input (ex.
     *               <code>"Enter name (John Smith): "</code>)
     * @return a <code>String</code> input by the user, or the <code>defaultValue</code>
     */
    public static String inputString(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }

    /**
     * Prompt the user for input and return a <code>String</code> other than <code>""</code>. 
     * 
     * @param prompt The text to show before the user's input (ex.
     *               <code>"Enter name (John Smith): "</code>)
     * @return a <code>String</code> input by the user, or the
     *         <code>defaultValue</code>
     */
    public static String inputStringNonEmpty(String prompt) {
        while (true) {
            String input = inputString(prompt);
            if (input.length() > 0) {
                return input;
            } else {
                System.out.println("ERROR: Input must not be empty");
            }
        }
    }
    /**
     * Prompt the user for input and return an <code>int</code>
     * 
     * @param prompt The text to show before the user's input (ex. <code>"Enter num: "</code>)
     * @return an <code>int</code> input by the user
     */
    public static int inputInt(String prompt) {
        while (true) {
            String input = inputStringNonEmpty(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: input must be a valid integer");
            }
        }
    }
    
    /**
     * Prompt the user to input an integer within a specified range
     * 
     * @param prompt The text to show before the user's input (ex.
     *               <code>"Enter num (0-10): "</code>)
     * @param min    The minimum valid integer to accept (inclusive)
     * @param max    The maximum valid integer to accept (inclusive)
     * @return An integer between the minimum and maximum values
     */
    public static int inputIntWithinRange(String prompt, int min, int max) {
        while (true) {
            int input = inputInt(prompt);
            if (min <= input && input <= max) {
                return input;
            }
            System.out.println("ERROR: input must be between " + min + " and " + max);

        }
    }

    /**
     * Prompt the user for input and return an <code>double</code>
     * 
     * @param prompt The text to show before the user's input (ex. <code>"Enter num: "</code>)
     * @return an <code>double</code> input by the user
     */
    public static double inputDouble(String prompt) {
        while (true) {
            String input = inputString(prompt);
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: input must be a valid double");
            }
        }
    }
}