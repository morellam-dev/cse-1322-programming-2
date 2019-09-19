package module_2.lab_2b;

import java.util.*;
import java.util.Map.Entry;

class OctagonList {
    public HashMap<String, Octagon> octagonList = new HashMap<>();

    /** @return the octagon located at the given key, or {@code null} if no such Octagon was found */
    public Octagon getOctagon(String key) {
        return octagonList.get(key);
    }

    /**
     * @return the octagon located at the given key, or {@code null} if no such
     *         Octagon was found
     */
    public void addOctagon(String key, Octagon o1) {
        octagonList.put(key, o1);
    }

    /** 
     * Removes the Octagon at the given key.
     * @param The name of the Octagon to remove.
     * @return {@code true} if successful, or {@code false} if no such octagon was found */
    public boolean removeOctagon(String key) {
        return octagonList.remove(key) != null;
    }

    /** @return whether or not an octagon exists with the given key */
    public boolean octagonExists(String key) {
        return octagonList.containsKey(key);
    }
}

public class OctagonApp extends ConsoleApp {
    public static Scanner console = new Scanner(System.in);

    public HashMap<String, Octagon> octagonList = new HashMap<>();

    /**
     * Helper method for creating {@code Octagon} objects from user input
     * 
     * @return A new {@code Octagon} with a sidelength entered by the user
     */
    public static Octagon inputOctagon() {
        double length = inputDouble("Enter side length: ");
        return new Octagon(length);
    }

    public void addOctagon() {
        System.out.println("=== ADD AN OCTAGON ===");
        String name = inputString("Enter Octagon name: ");
        Octagon octagon = inputOctagon();
        octagonList.put(name, octagon);
    }

    public void deleteOctagon() {
        System.out.println("=== DELETE AN OCTAGON ===");
        String name = inputString("Name of the octagon to delete: ");
        if (octagonList.containsKey(name)) {
            octagonList.remove(name);
            System.out.printf("Octagon %s was removed\n", name);
        } else {
            System.out.printf("Octagon %s was not found\n", name);
        }
    }

    public void cloneOctagon() {
        System.out.println("=== CLONE AN OCTAGON ===");
        String oldName = inputString("Name of the octagon to clone: ");
        if (octagonList.containsKey(oldName)) {
            Octagon oldOctagon = octagonList.get(oldName);
            String newName = inputString("Name of the new octagon: ");
            octagonList.put(newName, oldOctagon.clone());
            System.out.printf("%s was cloned into %s \n", oldName, newName);
        } else {
            System.out.printf("Octagon %s was not found\n", oldName);
        }
    }

    public void compareOctagons() {
        System.out.println("=== COMPARE TWO OCTAGONS ===");
        Octagon o1 = octagonList.get(inputString("Name of first Octagon: "));
        Octagon o2 = octagonList.get(inputString("Name of second Octagon: "));
        if (o1 == null || o2 == null) {
            System.out.println("Octagons not found. Exiting...");
            return;
        }

        System.out.println();
    }

    public void displayOctagons() {
        String tableFormat = "%-15s %-10s %-10s %-10s\n";
        System.out.printf(tableFormat, "Octagon", "Side", "Area", "Perimeter");
        System.out.println("=======================================");
        for (Entry<String, Octagon> entry : octagonList.entrySet()) {
            String name = entry.getKey();
            String edge = entry.getValue().getEdgeLength() + "";
            String area = entry.getValue().getArea() + "";
            String perimeter = entry.getValue().getPerimeter() + "";
            System.out.printf(tableFormat, name, edge, area, perimeter);
        }
    }

    public void printCommands() {
        System.out.println("=== COMMAND LIST ===");
        System.out.println("a: add new Octagon");
        System.out.println("d: delete an Octagon");
        System.out.println("c: clone an Octagon");
        System.out.println("s: compare two Octagons");
    }

    public void commandEntry() {

        String command = inputString("Enter command (h to list commands): ").toLowerCase().trim();
        switch (command) {
        default:
            printCommands();
        case "h":
            printCommands();
            break;
        case "a":
            addOctagon();
            break;
        case "d":
            deleteOctagon();
            break;
        case "c":
            cloneOctagon();
            break;
        case "s":
            compareOctagons();
            break;
        }
    }

    public static void main(String[] args) {
        OctagonApp app = new OctagonApp();
        app.octagonList.put("Octagon #1", new Octagon(8));
        app.octagonList.put("Octagon #2", new Octagon(6));
        while (true) {
            app.displayOctagons();
            System.out.println();
            app.commandEntry();
            System.out.println();
        }
    }
}