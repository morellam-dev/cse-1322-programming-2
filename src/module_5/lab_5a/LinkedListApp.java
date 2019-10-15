package module_5.lab_5a;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * LinkedListApp
 */
public class LinkedListApp {

    private List<Integer> myList = new LinkedList<>();
    private static Scanner console = new Scanner(System.in);

    /**
     * @param list a List of Integer values
     * @return A sum of those integers
     */
    public static int sumIntegerList(List<Integer> list) {
        int sum = 0;
        for (int n : list)
            sum += n;
        return sum;
    }

    /**
     * @param list a List of double values
     * @return A sum of those integers
     */
    public static double sumDoubleList(List<Double> list) {
        double sum = 0;
        for (double n : list)
            sum += n;
        return sum;
    }

    public void addInteger() throws NumberFormatException {
        int i = myList.size();
        System.out.print("Input number #" + (i + 1) + ": ");
        String input = console.nextLine();
        try {
            myList.add(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            return;
        }
    }

    public void addIntegers(int amount) {
        int maximum = myList.size() + amount;
        while (myList.size() < maximum) {
            addInteger();
            display();
        }
    }

    public void display() {
        System.out.print("ARRAY: " + myList.toString() + " - " + "SUM: " + sumIntegerList(myList));
        System.out.println();
    }

    public int size() {
        return myList.size();
    }

    public static void main(String[] args) {
        var demo = new LinkedListApp();
        demo.addIntegers(10);
    }
}
