package module_5.lab_5b.clothing_stack;

/**
 * ClothingStackApp
 */
public class ClothingStackApp extends ConsoleApp {
    private ClothingStack stack = new ClothingStack();

    public ClothingStackApp() {
        this.stack = new ClothingStack();
    }

    public ClothingStackApp(Clothing ...clothes) {
        this.stack = new ClothingStack();
        for (Clothing c : clothes) {
            stack.push(c);
        }
    }

    public void push() {
        System.out.println("=== ADD NEW CLOTHING ITEM ===");
        Clothing c = new Clothing(
            readStringNonEmpty("Enter color (i.e. \"red\"): ").trim(),
            readStringNonEmpty("Enter name (i.e. \"shirt\"): ").trim(),
            readString("Machine washable? (y/N) ").equalsIgnoreCase("y")
        );
        System.out.println();
        if (!stack.isFull()) {
            stack.push(c);
            System.out.println("Added " + c.toString() + " to the stack! Stack now has " + stack.size() + " items!");
        } else {
            System.out.println("ERROR: Stack is full! Clothing could not be added.");
        }
        System.out.println();
        pause();
    }

    public void pop() {
        System.out.println("=== POP TOPMOST CLOTHING ITEM ===");
        if (stack.isEmpty()) {
            System.out.println("ERROR: Stack is empty!");
        } else {
            Clothing c = stack.pop();
            System.out.println("\nPOP: " + c.toString() + "\n");


        }
        
        System.out.println();
        pause();
    }

    public void filter() {
        System.out.println("=== FILTER CLOTHES BY COLOR ===");
        String color = readString("Enter color: ");
        ClothingStack filtered = stack.filterColor(color);
        filtered.displayAllClothes();
        System.out.println();
        pause();
    }

    public void washable() {
        System.out.println("=== FILTER CLOTHES BY WASHABLE ===");
        ClothingStack filtered = stack.filterWashable(true);
        filtered.displayAllClothes();
        System.out.println();
        pause();
    }

    public void reset() {
        stack = new ClothingStack();
    }

    public void showStackItems() {
        System.out.printf("=== STACK HAS %d/%d ITEMS ===\n", stack.size(), stack.getCapacity());
        for (Clothing c : stack) {
            boolean isTop = c == stack.peek();
            String clothingString = c.toString();
            System.out.printf(" %s %s\n", (isTop ? "**" : "*"), clothingString);
        }
    }

    public void listCommands() {
        System.out.println();
        System.out.println("=== COMMANDS LIST ===");
        String[] cmds = {
            "? - Display help message",
            "a - Add new Clothing to stack",
            "p - Remove topmost Clothing item",
            "f - Filter by color",
            "w - Show only washable",
            "r - Reset stack to empty"
        };
        for (String cmd : cmds) {
            System.out.println(cmd);
        }
        System.out.println();
        inputCommand();
    }

    public void inputCommand() {
        String command = readStringNonEmpty("Enter command (? for help): ");
        command = command.toLowerCase().trim();
        switch (command) {
            case "?": 
                listCommands();
                break;
            case "a":
                push();
                break;
            case "p":
                pop();
                break;
            case "f":
                filter();
                break;
            case "w":
                washable();
            break;
            case "r":
                reset();
                break;
            default:
                System.out.println("Invalid command! Type \"?\" to list all available commands.");
        }
    }

    public static void main(String[] args) {
        ClothingStackApp app = new ClothingStackApp(
                new Clothing("red", "shirt", true), new Clothing("white", "shirt", true),
                new Clothing("blue", "shirt", true), new Clothing("blue", "jeans", false),
                new Clothing("black", "tuxedo", false), new Clothing("white", "dress shirt", false),
                new Clothing("red", "hoodie", true)
        );
        while (true) {
            System.out.println();
            app.showStackItems();
            System.out.println();
            app.inputCommand();
        }
    }
}