package module_2.assignment_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains methods for inputting demo vacations through the console, 
 * and a demo application for displaying them.
 */
public class VacationsDemo extends ConsoleApp {
    
    /**
     * Prompt the user to input several fields, then construct an
     * <code>InclusiveVacation</code> using them
     * 
     * @param prompt The text to show before the user's input
     * @return an <code>InclusiveVacation</code> object with its fields filled via
     *         user input
     */
    public static InclusiveVacation inputInclusive(String prompt) {
        System.out.print(prompt);
        return new InclusiveVacation(inputStringNonEmpty("Enter destination: "), inputDouble("Enter budget: $"),
                inputDouble("Enter price: $"), inputStringNonEmpty("Enter brand: "),
                inputIntWithinRange("Enter rating (0-5 stars): ", 0, 5));
    }

    /**
     * Prompt the user to input several fields, then construct a
     * <code>PiecemealVacation</code> using them
     * 
     * @param prompt The text to show before the user's input
     * 
     * @return a <code>PiecemealVacation</code> object with its fields filled via
     *         user input
     */
    public static PiecemealVacation inputPiecemeal(String prompt) {
        System.out.print(prompt);
        String destination = inputStringNonEmpty("Enter destination: ");
        double budget = inputDouble("Enter budget: $");

        HashMap<String, Double> items = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            if (i != 0) {
                System.out.println("Press enter when finished");
            }
            String item = inputString("Enter item #" + (i + 1) + ": ");
            if (item.matches("")) {
                break;
            }
            Double price = inputDouble("Enter " + item + " price: $");
            items.put(item, price);
        }
        return new PiecemealVacation(destination, budget, items);
    }

    public static void main(String[] args) {
        // Create demo Inclusive Vacation
        InclusiveVacation exampleInclusiveOne = new InclusiveVacation("Honolulu", 5000, 4000, "Delta Vacations", 4);
        // Demo piecemeal vacation
        PiecemealVacation examplePiecemeal = new PiecemealVacation("Italy", 4500, new HashMap<String, Double>(
            Map.of(
                "Hotel", 600.0, 
                "Airfare", 3000.0, 
                "Meals", 400.0)
            )
        );
        // Print incusive to console
        System.out.println("=== EXAMPLE ALL-INCLUSIVE VACATION ===");
        exampleInclusiveOne.display();
        System.out.println();
        pause();
        System.out.println();
        // Print piecemeal to console
        System.out.println("=== EXAMPLE PIECEMEAL VACATION ===");
        examplePiecemeal.display();
        System.out.println();
        pause();
        System.out.println();

        // Demo: User-generated All-inclusive Vacation
        System.out.println("=== CREATE YOUR OWN ALL-INCLUSIVE VACATION ===");
        Vacation userInclusiveVacation = inputInclusive("");
        System.out.println();
        System.out.println("=== USER GENERATED ALL-INCLUSIVE VACATION ===");
        userInclusiveVacation.display();
        System.out.println();
        pause();
        System.out.println();

        // Demo: User-generated Piecemeal Vacation
        System.out.println("=== CREATE YOUR OWN ALL-INCLUSIVE VACATION ===");
        Vacation userPiecemealVacation = inputPiecemeal("");
        System.out.println();
        System.out.println("=== USER GENERATED PIECEMEAL VACATION ===");
        userPiecemealVacation.display();
        System.out.println();
        pause();
        System.out.println();
    }
}