package module_5.lab_5b.clothing_stack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * StackTest 
 * @author M. Morella
 */
public class ClothingStackTest {
    private static Scanner console = new Scanner(System.in);

    public static void pause() {
        System.out.print("\nPress enter to continue...");
        console.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println();
        ClothingStack stackTest1 = new ClothingStack(Arrays.asList(
                new Clothing("red", "shirt", true),
                new Clothing("white", "shirt", true),
                new Clothing("blue", "shirt", true),
                new Clothing("blue", "jeans", false),
                new Clothing("black", "tuxedo", false),
                new Clothing("white", "dress shirt", false),
                new Clothing("red", "hoodie", true)
        ));
        // Show all clothes
        System.out.println("=== CLOTHING STACK ===");
        stackTest1.displayAllClothes();
        pause();
        // Show only "red" clothes
        System.out.println("=== FILTER CLOTHING STACK – (ONLY \"red\") ===");
        stackTest1.filterColor("red").displayAllClothes();
        pause();
        // Show only hightemp washable clothes
        System.out.println("=== FILTER CLOTHING STACK – (ONLY machine washable) ===");
        stackTest1.filterWashable(true).displayAllClothes();
        pause();
        // Demo accessing 3 elements by pop()
        System.out.println("=== RETRIEVE 4 ELEMENTS VIA POP() ===");
        for (int i = 0; i < 4; i++) {
            System.out.println("POP: " + stackTest1.pop().toString());
        }
        // Show popped stack
        System.out.println("=== CLOTHING STACK (AFTER POP) ===");
        stackTest1.displayAllClothes();
    }
}
/* Console output: 

=== CLOTHING STACK ===
#1: red shirt (high-temp washable)
#2: white shirt (high-temp washable)
#3: blue shirt (high-temp washable)
#4: blue jeans
#5: black tuxedo
#6: white dress shirt
#7: red hoodie (high-temp washable)

=== CLOTHING STACK – (ONLY WHITES) ===
#1: red shirt (high-temp washable)
#2: red hoodie (high-temp washable)

=== CLOTHING STACK – (ONLY HIGH-TEMP) ===
#1: red shirt (high-temp washable)
#2: white shirt (high-temp washable)
#3: blue shirt (high-temp washable)
#4: red hoodie (high-temp washable)

=== RETRIEVE 3 ELEMENTS VIA POP() ===
POP: red hoodie (high-temp washable)
POP: white dress shirt
POP: black tuxedo
POP: blue jeans

=== CLOTHING STACK ===
#1: red shirt (high-temp washable)
#2: white shirt (high-temp washable)
#3: blue shirt (high-temp washable)

*/