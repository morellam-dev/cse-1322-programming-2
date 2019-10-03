package module_5.lab_5a;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ArrayListSum
 */
public class GenericListSum {
    public static double doubleSumList(List<? extends Number> arr) {
        double sum = 0;
        for (Number number : arr) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public static int intSumList(List<? extends Number> arr) {
        double sum = 0;
        for (Number number : arr) {
            sum += number.intValue();
        }
        return (int)sum;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> intArrayList = new ArrayList<>(List.of(11, 22, 33, 44));
        System.out.println("intArrayList = {11, 22, 33, 44}");
        ArrayList<Double> doubleArrayList = new ArrayList<>(List.of(1.1, 2.2, 3.3, 4.4));
        System.out.println("doubleArrayList = {1.1, 2.2, 3.3, 4.4}");
        LinkedList<Integer> intLinkedList = new LinkedList<>(List.of(11, 22, 33, 44));
        LinkedList<Double> doubleLinkedList = new LinkedList<>(List.of(1.1, 2.2, 3.3, 4.4));
        
        doubleSumList(doubleArrayList);
        doubleSumList(doubleLinkedList);
        System.out.println("intSumList(intArrayList) -> " + intSumList(intArrayList));
        System.out.println("doubleSumList(doubleLinkedList) -> " + doubleSumList(doubleLinkedList));
    }
}