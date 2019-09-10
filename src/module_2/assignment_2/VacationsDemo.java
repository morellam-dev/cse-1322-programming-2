package module_2.assignment_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains methods for inputting demo vacations through the console.
 */
public class VacationsDemo extends ConsoleApp {
    /**
     * Prompt the user to input several fields, then construct an
     * <code>InclusiveVacation</code> using them
     * 
     * @return an <code>InclusiveVacation</code> object with its fields filled via
     *         user input
     */
    public static InclusiveVacation inputInclusive() {
        return new InclusiveVacation(
            inputString("Enter destination: "), 
            inputDouble("Enter budget: $"), 
            inputDouble("Enter price: $"), 
            inputString("Enter brand: "), 
            inputIntWithinRange("Enter rating (0-5 stars): ", 0, 5)
        );
    }

    /**
     * Prompt the user to input several fields, then construct a
     * <code>PiecemealVacation</code> using them
     * 
     * @return a <code>PiecemealVacation</code> object with its fields filled via
     *         user input
     */
    public static PiecemealVacation inputPiecemeal() {
        String destination = inputString("Enter destination: ");
        double budget = inputDouble("Enter budget: $");

        HashMap<String, Double> items = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            if (i != 1) {
                System.out.println("Press enter when finished");
            }
            String item = inputString("Enter item #" + (i + 1) + ": ");
            if (item.matches("")) {
                break;
            }
            Double price = inputDouble("Enter "+ item + " price: $");
            items.put(item, price);
        }
        return new PiecemealVacation(destination, budget, items);
    }

    public static void main(String[] args) {
        System.out.println("=== EXAMPLE ALL-INCLUSIVE VACATION ===");
        InclusiveVacation exampleInclusiveOne = new InclusiveVacation("Honolulu", 5000, 4000, "Delta Vacations", 4);
        exampleInclusiveOne.display();
        System.out.println();

        System.out.println("=== EXAMPLE PIECEMEAL VACATION ===");
        
        HashMap<String, Double> exampleItems = new HashMap<>(
            Map.of(
                "Hotel", 600.0,
                "Airfare", 3000.0,
                "Meals", 400.0
            )
        );

        PiecemealVacation examplePiecemeal = new PiecemealVacation("Honolulu", 5000, exampleItems);
        examplePiecemeal.display();
        System.out.println();

        // Demo: User-generated All-inclusive Vacation
        System.out.println("=== USER GENERATED ALL-INCLUSIVE VACATION ===");
        InclusiveVacation userInclusiveVacation = inputInclusive();
        System.out.println();
        userInclusiveVacation.display();
        System.out.println();

        // Demo: User-generated Piecemeal Vacation
        System.out.println("=== USER GENERATED PIECEMEAL VACATION ===");
        PiecemealVacation userPiecemealVacation = inputPiecemeal();
        System.out.println();
        userPiecemealVacation.display();
        System.out.println();
    }
}