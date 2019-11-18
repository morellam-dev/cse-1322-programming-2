package module_6.assignment_6;

import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Assignment 6 - File I/O
 * Demonstration: {@link https://youtu.be/olEf6f1j9bM}
 * 
 * @author M Morella
 */
public class CopyTool {

    private static Scanner scanner = new Scanner(System.in); 

    public static File askFile(String promptMessage) {
        String path = "";
        while (path.length() < 1) {
            System.out.print(promptMessage + " ");
            path = scanner.nextLine();
        }
        if (path.equalsIgnoreCase(":q")) {
            exit();
            return null;
        } else {
            return new File(path);
        }
    }


    public static File askSourceFile() {
        while(true) {
            File file = askFile("Enter path to source file (ex. \"./textfile.txt\"):");
            if (!file.canRead()) {
                System.out.printf("Error: Could not read file at '%s' (Enter ':q' to quit)\n", file.getAbsolutePath());
                continue;
            } else {
                return file;
            }
        }
    }

    public static File askDestinationFile() {
        while (true) {
            File file = askFile(("Enter path to destination (ex. \"./textfile2.txt\"):"));
            if (file.exists() && !file.canWrite()) {
                System.out.printf("Error: File at '%s' is not writable\n", file.getAbsolutePath());
                continue;
            } else {
                return file;
            }
        }
    }

    public static void printFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)) ) {
            int lineNumber = 0;
            System.out.printf("=== %s ===\n", file.getName());
            while (reader.ready()) {
                String line = reader.readLine();
                lineNumber++;
                System.out.printf("%-3d: %s\n", lineNumber, line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readStringFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringJoiner s = new StringJoiner("\n");
            while (reader.ready()) {
                String line = reader.readLine();
                s.add(line);
            }
            return s.toString();
        } catch (IOException e) {
            System.out.printf("Error occured reading file at '%s'\n", file.getAbsolutePath());
        }
        return null;
    }

    public static void writeStringToFile(String str, File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(str);
            System.out.printf("Successfully wrote to %s\n", file.getName());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.println("\n");
        while(true) {
            File source = askSourceFile();
            printFile(source);
            System.out.println();
            File destination = askDestinationFile();
            if (destination.exists()) {
                System.out.printf("'%s' already exists. Overwrite? (y/N): ", destination.getName());
                boolean overwrite = scanner.nextLine().equalsIgnoreCase("y");
                if (!overwrite) {
                    continue;
                }
            }
            writeStringToFile(readStringFromFile(source), destination);
            System.out.println();
        }
    }
}