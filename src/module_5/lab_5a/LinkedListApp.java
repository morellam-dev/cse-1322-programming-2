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

    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    public void inputInteger() throws NumberFormatException {
        int i = myList.size();
        System.out.print("Input number #" + (i + 1) + ": ");
        String input = console.nextLine();
        try {
            myList.add(Integer.parseInt(input));
        } catch (NumberFormatException e) {
        }
    }

    public void display() {
        System.out.print("ARRAY: " + myList.toString() + " - " 
        + "SUM: " + sum(myList));
        System.out.println();
    }

    public int size() {
        return myList.size();
    }

    public static void main(String[] args) {
        var demo = new LinkedListApp();
        while (demo.size() < 10) {
            demo.inputInteger();
            demo.display();
        }
    }
}
