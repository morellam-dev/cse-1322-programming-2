/**
 * LinkedListSum
 */
package module_5.lab_5a;

import java.util.LinkedList;

/**
 * ArrayListSum
 */
public class LinkedListSum {
    private static LinkedList<Integer> integerList = new LinkedList<>();
    private static LinkedList<Double> doubleList = new LinkedList<>();

    public static void main(String[] args) {
        integerList.add(3);
        integerList.add(6);
        doubleList.add(3.0);
        doubleList.add(6.0);

        System.out.println((int)(sumArrayList(integerList)));
        System.out.println(sumArrayList(doubleList));
    }

    public static double sumArrayList(LinkedList<? extends Number> arr) {
        double sum = 0;
        for (Number number : arr) {
            sum += number.doubleValue();
        }
        return sum;
    }
}