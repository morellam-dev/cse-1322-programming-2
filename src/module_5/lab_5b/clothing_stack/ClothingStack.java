package module_5.lab_5b.clothing_stack;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Collection which implements a fixed-capacity stack of Clothing items. 
 * 
 * @implSpec This is an non-standard, incomplete implementation of the Collection interface, 
 * which only supports modification using the custom {@code push}, {@code pop}, and {@code peek} methods. 
 * The stack does not allow modification of its inner elements, 
 * so {@code add} and {@code remove} are not implemented.  
 * 
 * @author M Morella
 */
public class ClothingStack extends AbstractCollection<Clothing> implements Iterable<Clothing>, Cloneable {
    private static final int DEFAULT_CAPACITY = 20;
    /** An array representing the elements in the stack */
    private Clothing[] elements;
    /** The number of items in the stack. The topmost element is located at index {@code size - 1}. */
    private int size;
    /** The maximum number of items the stack can hold; this is the size of the array. */
    private final int capacity;

    /**
     * Create a new ClothingStack with a capacity of 20
     */
    public ClothingStack() {
        this(null);
    }
    
    /**
     * Create a new ClothingStack with a capacity of 20
     * 
     * @param clothes A collection of Clothes, such as another Stack.
     */
    public ClothingStack(Collection<Clothing> clothes) {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        elements = new Clothing[capacity];

        if (clothes != null) {
            for (Clothing c : clothes) {
                this.push(c);
            }
        }
    }

    /** Add an element to the top of the stack */
    public boolean push(Clothing c) {
        if (isFull()) {
            return false;
        }
        elements[size++] = c;
        return true;
    }

    /** @return the element at the top of the stack, and remove it */
    public Clothing pop() {
        if (isEmpty()) {
            return null;
        }
        return elements[--size];
    }

    /** @return the element at the top of the stack, without removing it */
    public Clothing peek() {
        if (isEmpty()) {
            return null;
        }
        return elements[size - 1];
    }

    @Override
    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    /** @return {@code true} if the stack has reached its maximum capacity */
    public boolean isFull() {
        return (size == capacity);
    }

    @Override
    public Iterator<Clothing> iterator() {
        return new Iterator<Clothing>() {
            private int nextIndex = size - 1; // index of the next
			@Override
			public boolean hasNext() {
				return (nextIndex != -1);
			}
			@Override
			public Clothing next() {
				if (hasNext()) {
                    return elements[nextIndex--];
                }
				throw new IndexOutOfBoundsException();
			}
        };
    }

    @Override
    public ClothingStack clone() {
        return new ClothingStack(this);
    }

    public void displayAllClothes() {
        System.out.println();
        for (Clothing c : this) {
            System.out.println(" * " + c.toString());
        }
    }

    public ClothingStack filterColor(String color) {
        ClothingStack filtered = new ClothingStack();
        for (Clothing c : this) {
            if (c.getColor().matches(color)) {
                filtered.push(c);
            }
        }
        return filtered;
    }

    public ClothingStack filterWashable(boolean machineWashable) {
        ClothingStack filtered = new ClothingStack();
        for (Clothing c : this) {
            if (c.isMachineWashable() == machineWashable) {
                filtered.push(c);
            }
        }
        return filtered;
    }

    public static void main(String[] args) {
        ClothingStack c = new ClothingStack();
        c.push(new Clothing("Shirt", "Red", true));
    }
}