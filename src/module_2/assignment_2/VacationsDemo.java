package module_2.assignment_2;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains methods for inputting demo vacations through the console.
 */
public class VacationsDemo extends ConsoleApp {
    

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
        InclusiveVacation userInclusiveVacation = inputInclusive("");
        System.out.println();
        userInclusiveVacation.display();
        System.out.println();

        // Demo: User-generated Piecemeal Vacation
        System.out.println("=== USER GENERATED PIECEMEAL VACATION ===");
        PiecemealVacation userPiecemealVacation = inputPiecemeal("");
        System.out.println();
        userPiecemealVacation.display();
        System.out.println();
    }
}