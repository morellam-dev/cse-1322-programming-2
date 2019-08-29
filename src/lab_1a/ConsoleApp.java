package lab_1a;

import java.util.Scanner;
/** 
 * M.D Morella
 * Lab 1A - Console App
 * Perform basic console user input/output
 */
class Lab1AConsoleApp {
    /**
     * Print a message, then prompt the user for input
     * @param in A scanner object to recieve input from
     * @param prompt A string to print before the user's input.
     * @return A string written by the user
     */
    public static String readLine(Scanner in, String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }
    /**
     * Print a message, then prompt the user for input
     * @param in A scanner object to recieve input from
     * @param prompt A string to print before the user's input.
     * @return An integer entered by the user 
     */
    public static int readInt(Scanner in, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = in.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error! Input must be a valid integer!");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String inputName = readLine(scanner, "Enter your name: "); // > Enter your name: Hi!
        int inputAge = readInt(scanner, "Enter your age: "); // > 

        String output = String.format("Your name is %1$s! You are %2$d years old.", inputName, inputAge);
        System.out.println(output);
    }
}