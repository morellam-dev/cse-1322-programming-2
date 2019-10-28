package module_6.lab_6a;

import java.util.Scanner;

/**
 * TimeConverter
 */
public class TimeConverterApp {
    protected static final Scanner scanner = new Scanner(System.in);

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args) {

        System.out.println(
            "===================================================\n" +
            "|                                                 |\n" +
            "|           24-HOUR TIME CONVERTER APP            |\n" +
            "|                          by M Morella           |\n" +
            "|                                                 |\n" +
            "===================================================");

        for (int i = 0; ; i++) {
            System.out.println();
            String prompt = "Enter time in 24-hour notation" + (i > 0 ? " ('q' to exit)" : "") + ": ";
            String input = inputString(prompt);
            if (input.matches("[Qq]")) {
                break;
            }
            try {
                Time24Hour t = Time24Hour.parseTime(input);
                System.out.println("That is the same as " + t.get12HourTime());
            } catch (TimeFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("\n"+
            "===================================================\n" +
            "|                                                 |\n" +
            "|        Thank you! The app will now exit.        |\n" +
            "|                      :3 Have a nice day :3      |\n" +
            "|                                                 |\n" +
            "===================================================\n");
        System.exit(0);
    }
}