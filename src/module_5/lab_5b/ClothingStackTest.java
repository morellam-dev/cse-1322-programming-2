package module_5.lab_5b;

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
        ClothingStack stackTest1 = new ClothingStack(20, new Clothing[] {
                new Clothing("shirt", "red", true),
                new Clothing("shirt", "white", true),
                new Clothing("shirt", "blue", true),
                new Clothing("jeans", "blue", false),
                new Clothing("tuxedo", "black", false),
                new Clothing("dress shirt", "white", false),
                new Clothing("hoodie", "red", true)
            }
        );
        // Show all clothes
        System.out.println("=== CLOTHING STACK ===");
        stackTest1.display();
        pause();
        // Show only "red" clothes
        System.out.println("=== FILTER CLOTHING STACK – (ONLY REDS) ===");
        stackTest1.matchesColor("red").display();
        pause();
        // Show only hightemp washable clothes
        System.out.println("=== FILTER CLOTHING STACK – (ONLY HIGH-TEMP) ===");
        stackTest1.matchesWashable(true).display();
        pause();
        // Demo accessing 3 elements by pop()
        System.out.println("=== RETRIEVE 4 ELEMENTS VIA POP() ===");
        for (int i = 0; i < 4; i++) {
            System.out.println("POP: " + stackTest1.pop().toSimpleString());
        }
        pause();
        // Show popped stack
        System.out.println("=== CLOTHING STACK (AFTER POP) ===");
        stackTest1.display();
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