package module_5.lab_5b.food_queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FoodQueueTest
 * @author M. Morella
 */
public class FoodQueueApp {
    private static Scanner console = new Scanner(System.in);

    public static void pause() {
        pause("\n\nPress enter to continue...", "\n");
    }
    
    public static void pause(String before, String after) {
        System.out.println(before);
        console.nextLine();
        System.out.print(after);
    }

    public static void verboseAdd(FoodQueue queue, Food f) {
        boolean success = queue.enqueue(f);
        if (success) {
            System.out.printf("ADD: Inserted \"%s\" at as the %dth food\n", f.getName(), queue.size());
        } else {
            if (queue.isFull()) {
                System.out.printf("ADD: Tried to insert \"%s\", but queue can only hold %d elements\n", f.getName(), queue.capacity()); 
            }
        }
        pause("(press enter)", "");
    }

    public static void verbosePop(FoodQueue queue) {
        Food f = queue.dequeue();
        if (f == null) {
            return;
        } else {
            System.out.printf("POP: Food #%d: %s\n", queue.size() + 1, f.toString());
        }
        pause("(press enter)", "");
    }

    public static void main(String[] args) {
        System.out.println();
        FoodQueue queueTest1 = new FoodQueue(5, Arrays.asList(
            new Food("Hot Dog", 300, 1),
            new Food("Barbecue Lays", 120, 4),
            new Food("Pringles", 130, 10)
        ));
        queueTest1.displayAllFoods();

        pause();
        System.out.println("=== DEMO: ENQUEUE METHOD ===");
        verboseAdd(queueTest1, (new Food("Pizza", 500, 8))); // -> true
        verboseAdd(queueTest1, (new Food("Diet Coke", 0, 6))); // -> true
        verboseAdd(queueTest1, (new Food("Jumbo Slushie", 500, 2))); // -> false (array is full)
        queueTest1.displayAllFoods();
        pause();
        System.out.println("=== DEMO: DEQUEUE METHOD ===");
        for (int i = 0; i < 4; i++) {
            verbosePop(queueTest1);
        }
        queueTest1.displayAllFoods();
    }
    
}


/**
Console Output: <code>

=== DISPLAY: QUEUE EXAMPLE WITH 3/5 ELEMENTS ===
 * Hot Dog - 300 calories per serving (1 servings)
 * Barbecue Lays - 120 calories per serving (4 servings)
 * Pringles - 130 calories per serving (10 servings)

Press enter to continue...

=== DEMO: ENQUEUE METHOD ===
ADD: Inserted "Pizza" at as the 4th food
(press enter)
ADD: Inserted "Diet Coke" at as the 5th food
(press enter)
ADD: Tried to insert "Straw", but queue can only hold 5 elements
(press enter)
=== DISPLAY: QUEUE HAS 5/5 ELEMENTS ===
 * Hot Dog - 300 calories per serving (1 servings)
 * Barbecue Lays - 120 calories per serving (4 servings)
 * Pringles - 130 calories per serving (10 servings)
 * Pizza - 500 calories per serving (8 servings)
 * Diet Coke - 0 calories per serving (6 servings)

Press enter to continue...

=== DEMO: DEQUEUE METHOD ===
POP: Food #5: Hot Dog - 300 calories per serving (1 servings)
(press enter)
POP: Food #4: Barbecue Lays - 120 calories per serving (4 servings)
(press enter)
POP: Food #3: Pringles - 130 calories per serving (10 servings)
(press enter)
POP: Food #2: Pizza - 500 calories per serving (8 servings)
(press enter)
=== DISPLAY: QUEUE HAS 1/5 ELEMENTS ===
 * Diet Coke - 0 calories per serving (6 servings)

</code>
*/