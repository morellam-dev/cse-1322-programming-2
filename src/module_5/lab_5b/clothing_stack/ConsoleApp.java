package module_5.lab_5b.clothing_stack;

import java.util.Scanner;

/**
 * A base class which declares helper methods for parsing user input from the console
 */
public class ConsoleApp {
    private final static Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return scanner;
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static String readStringNonEmpty(String prompt) {
        String input = "";
        while (input.length() == 0) {
            input = readString(prompt);
        }
        return input;
    }

    public static int readInteger(String prompt) {
        while (true) {
            String input = readStringNonEmpty(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + input + "\" is not a valid integer");
            }
        }
    }

    public static int readIntegerRange(String prompt, int minInclusive, int maxInclusive) {
        while (true) {
            int input = readInteger(prompt);
            if (minInclusive <= input && input <= maxInclusive) {
                return input;
            }
            System.out.printf("Error: %d is not within range [%d, %d]\n", 
                    input, minInclusive, maxInclusive);
        }
    }

    public static boolean readBoolean(String prompt) {
        while (true) {
            String input = readStringNonEmpty(prompt);
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("t")) {
                return true;
            }
            if (input.equalsIgnoreCase("false") || input.equalsIgnoreCase("f")) {
                return false;
            }
        }
    }

    public static void pause() {
        pause("(Press enter to continue...)");
    }

    public static void pause(String prompt) {
        readString(prompt);
    }

    /** A convenience method which conbines System.out.println with System.out.printf */
    public static void printLineFormat(String format, Object ...args) {
        format = format + "\n";
        System.out.printf(format, args);
    }
}