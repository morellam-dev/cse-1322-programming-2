package module_5.lab_5a;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Simple implementation of Array List using Java's AbstractList skeleton
 */
public class ArrayList<E> extends AbstractList<E> {
    private E[] arr;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        /* Java does not allow instantiating new generic arrays 
        without performing an unchecked type cast. Suppress this warning. */
        arr = (E[])new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index < 0 || size <= index) {
            throw new IndexOutOfBoundsException(index);
        }
        return arr[index];
    }
    @Override
    public boolean add(E elem) {
        int index = size;
        if (index == arr.length) {
            resizeArray(2); // If the array is full, double its size.
        }
        arr[index] = elem;
        size++;
        return true;
    }

    private void resizeArray(int factor) {
        int newSize = arr.length * factor;
        arr = Arrays.copyOf(arr, newSize);
    }

    @Override
    public E set(int index, E elem) {
        E old = get(index);
        arr[index] = elem;

        return old;
    }

    @Override
    public E remove(int index) {
        E old = get(index);

        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        return old;
    }
    
}