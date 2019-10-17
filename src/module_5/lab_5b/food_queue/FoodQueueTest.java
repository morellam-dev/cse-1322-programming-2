package module_5.lab_5b.food_queue;

import java.util.Scanner;

/**
 * FoodQueueTest
 * @author M. Morella
 */
public class FoodQueueTest {
    private static Scanner console = new Scanner(System.in);

    public static void pause() {
        System.out.print("\nPress enter to continue...");
        console.nextLine();
        System.out.println();
    }

    public static void verboseAdd(FoodQueue queue, Food f) {
        boolean success = queue.enqueue(f);
        if (success) {
            System.out.printf("ADD: Inserted \"%s\" at as the %dth food\n", f.getName(), queue.getSize());
        } else {
            if (queue.isFull()) {
                System.out.printf("ADD: Tried to insert \"%s\", but queue can only hold %d elements\n", f.getName(), queue.getCapacity()); 
            }
            
        }
    }

    public static void verbosePop(FoodQueue queue) {
        Food f = queue.dequeue();
        if (f == null) {
            System.out.println("ERR: Queue is empty.");
            return;
        } else {
            System.out.printf("POP: Food #%d: %s\n", queue.getSize() + 1, f.toSimpleString());
        }
    }

    public static void main(String[] args) {
        System.out.println();
        FoodQueue queueTest1 = new FoodQueue(5, 
            new Food("Hot Dog", 300, 1),
            new Food("Barbecue Lays", 120, 4),
            new Food("Pringles", 130, 10)
        );
        System.out.println("=== DISPLAY: QUEUE EXAMPLE WITH " + queueTest1.getSize() +  " ELEMENTS" 
        + " - MAX " + queueTest1.getCapacity() + " ===");
        queueTest1.display();
        pause();
        System.out.println("=== DEMO: ENQUEUE METHOD ===");
        verboseAdd(queueTest1, (new Food("Pizza", 500, 8))); // -> true
        verboseAdd(queueTest1, (new Food("Diet Coke", 0, 6))); // -> true
        verboseAdd(queueTest1, (new Food("Straw", 500, 2))); // -> false (array is full)
        pause();
        System.out.println("=== DISPLAY: QUEUE HAS " + queueTest1.getSize() + " ELEMENTS ===");
        queueTest1.display();
        pause();
        System.out.println("=== DEMO: DEQUEUE METHOD ===");
        for (int i = 0; i < 4; i++) {
            verbosePop(queueTest1);
        }
        pause();
        System.out.println("=== DISPLAY: QUEUE HAS " + queueTest1.getSize() + " ELEMENTS ===");
        queueTest1.display();
    }
    
}

/* Console output:

 * === DISPLAY: QUEUE EXAMPLE WITH 3 ELEMENTS - MAX 5 === Food #1: Hot Dog - 300
 * calories per serving (1 servings) Food #2: Barbecue Lays - 120 calories per
 * serving (4 servings) Food #3: Pringles - 130 calories per serving (10
 * servings)
 * 
 * 
 * === DEMO: ENQUEUE METHOD === 
 * ADD: Inserted "Pizza" at as the 4th food 
 * ADD: Inserted "Diet Coke" at as the 5th food 
 * ADD: Tried to insert "Straw", but queue can only hold 5 elements
 * 
 * 
 * === DISPLAY: QUEUE HAS 5 ELEMENTS === 
 * Food #1: Hot Dog - 300 calories per serving (1 servings) 
 * Food #2: Barbecue Lays - 120 calories per serving (4 servings) 
 * Food #3: Pringles - 130 calories per serving (10 servings) 
 * Food #4: Pizza - 500 calories per serving (8 servings) 
 * Food #5: Diet Coke - 0 calories per serving (6 servings)
 * 
 * 
 * === DEMO: DEQUEUE METHOD === 
 * POP: Food #5: Hot Dog - 300 calories per serving (1 servings) 
 * POP: Food #4: Barbecue Lays - 120 calories per serving (4 servings) 
 * POP: Food #3: Pringles - 130 calories per serving (10 servings)
 * POP: Food #2: Pizza - 500 calories per serving (8 servings)
 * 
 * === DISPLAY: QUEUE HAS 1 ELEMENTS === 
 * Food #1: Diet Coke - 0 calories per serving (6 servings)
 */