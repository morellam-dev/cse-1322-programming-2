package module_5.lab_5b;

/**
 * StackTest
 */
public class StackTest {

    public static void main(String[] args) {
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
        System.out.println();
        // Show only "red" clothes
        System.out.println("=== CLOTHING STACK – (ONLY WHITES) ===");
        stackTest1.matchesColor("red").display();
        System.out.println();
        // Show only hightemp washable clothes
        System.out.println("=== CLOTHING STACK – (ONLY HIGH-TEMP) ===");
        stackTest1.matchesWashable(true).display();
        System.out.println();
        // Demo accessing 3 elements by pop()
        System.out.println("=== RETRIEVE 3 ELEMENTS VIA POP() ===");
        for (int i = 0; i < 4; i++) {
            System.out.println("POP: " + stackTest1.pop().toSimpleString());
        }
        System.out.println();
        // Show popped stack
        System.out.println("=== CLOTHING STACK ===");
        stackTest1.display();
        System.out.println();
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