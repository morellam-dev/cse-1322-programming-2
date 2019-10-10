package module_5.lab_5b;

/**
 * ClothingStackApp
 */
public class ClothingStackApp extends ConsoleApp {
    private ClothingStack stack = new ClothingStack(20, 
        new Clothing[] {
            new Clothing("shirt", "red", true),
            new Clothing("shirt", "white", true),
            new Clothing("hoodie", "red", true),
            new Clothing("jeans", "blue", false),
            new Clothing("tuxedo", "black", false),
        }
    );

    public static void main(String[] args) {
        ClothingStackApp main = new ClothingStackApp();
        System.out.println();
        main.doHelp();


        while(true) {
            main.display(main.stack);
            String command = inputString("Enter command (? for help): ");
            main.command(command);
        }
    }
    public void command(String command) {
        switch(command.substring(0, 0+1)) {
            case "1": 
                doPush();
                break;
            case "2":
                doPop();
                break;
            case "3":
                doFilterColor();
                break;
            case "4":
                doFilterTemperature();
                break;
            case "?":
                doHelp();
                break;
            default:
                System.out.println("Invalid input!");
                doHelp();
        }
    }

    public void doHelp() {
        System.out.println(
            "=== COMMAND LIST ===\n"
            + "1 - Push a new clothing to the stack\n"
            + "2 - Pop a piece of clothing from the stack\n"
            + "3 - Filter clothes by color\n"
            + "4 - Filter clothes by temperature\n"
            + "? - Show this help dialog\n"
        );
    }
    public void doPop() {
        if (stack.isEmpty()) {
            System.out.println("Error: the stack is empty!");
        }
        System.out.println("=== POPPED ELEMENT AT " + stack.count() + "===");
        Clothing c = stack.pop();
        System.out.println(c.toSimpleString());
        if (inputString("Put back in array? [y/N]: ").matches("[Yy]")) {
            stack.push(c);
        }
    }
    public void doPush() {
        if (stack.isFull()) {
            System.out.println("Error: the stack is full!");
            return;
        }
        System.out.println("=== PUSH NEW CLOTHING ITEM ===");
        Clothing c = new Clothing(
            inputString("Enter name: "),
            inputString("Enter color: "),
            inputString("High-temp washable? (Y/n): ").substring(0, 1).toLowerCase().matches("n")
        );
        stack.push(c);
        System.out.println("Added " + c.getName() + " to stack!");
        System.out.println();
    }

    public void doFilterColor() {
        System.out.println("=== FILTER BY COLOR ===");
        String color = inputString("Enter color: ");
        display(stack.matchesColor(color));
    }
    public void doFilterTemperature() {
        System.out.println("=== SHOWING ONLY HIGH-TEMP WASHABLE ===");
        display(stack.matchesWashable(true));
    }
    public void display(ClothingStack stack) {
        ClothingStack clone = stack.clone();
        int index = 0; 
        System.out.println("=== STACK HAS " + clone.count() + "/" + clone.capacity() + " ELEMENTS ===");
        while (!clone.isEmpty()) {
            index++;
            System.out.println("- #" + index + ": " + clone.pop().toSimpleString());
        }
    }
}