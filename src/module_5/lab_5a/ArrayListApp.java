package module_5.lab_5a;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * ArrayListApp
 */
public class ArrayListApp {
    protected static final Scanner scanner = new Scanner(System.in);
    private ArrayList<Integer> myList = new ArrayList<>();

    /**
     * Given a List object, return the sum of its values as a double
     * 
     * @param list A list of integers
     * @return The sum of the list's numbers
     */
    public static int sumIntegerList(List<? extends Number> list) {
        int sum = 0;
        for (Number num : list) {
            sum += num.intValue();
        }
        return sum;
    }
    /**
     * Given a List object, return the sum of its values as a double
     * 
     * @param list A list of numbers
     * @return The sum of the list's numbers
     */
    public static double sumDoubleList(List<Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }


    /** Prompt the user for input, then return their input as an integer.
     * If the user's input is invalid, the method will repeat until valid input is returned.
     * 
     * @prompt A message to print 
     * @return An integer
     */
    public static int inputInteger(String prompt) {
        while (true) {
            System.out.print(prompt); // "Input #1: "
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.printf("Error! \"%s\" is not a valid integer\n", input);
            }
        }
    }
    /**
     * 
     */
    public void addIntegers(int amount) {
        int total = myList.size() + amount;
        while (myList.size() < total) {
            int index = myList.size() + 1;
            int input = inputInteger("Enter input #" + index + ": ");
            myList.add(input);
            display();
        }
    }

    public void display() {
        System.out.println(myList.toString() + " - SUM: " + sumIntegerList(myList));
    }

    public static void main(String[] args) {
        ArrayListApp app = new ArrayListApp();
        app.addIntegers(10);
    }
}