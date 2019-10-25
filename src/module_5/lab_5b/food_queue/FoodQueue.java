package module_5.lab_5b.food_queue;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * A Collection which implements a fixed-capacity queue of Food items. 
 * @implSpec This is an non-standard, partial implementation of the Collection interface,
 * which only supports modification using the {@code enqueue}, {@code dequeue},
 * and {@code peek} methods. The Queue does not allow modification of its inner
 * elements, so {@code add}, {@code remove}, and {@code set} are not implemented.
 * 
 * @author M Morella
 */
public class FoodQueue extends AbstractCollection<Food> implements Iterable<Food>, Cloneable {
    /** The default capacity of FoodQueue elements which do not specify a capacity  */
    public static final int DEFAULT_CAPACITY = 20;

    private Food[] elements;
    private int size = 0;
    private int tail = -1; // FIRST IN - enqueue new elements at tail + 1
    private int head = 0; // LAST OUT - dequeue elements at head
    private final int capacity;
    
    
    // Constructors
    
    /**
     * Create a new FoodQueue with no elements and the default capacity of 20
     */
    public FoodQueue() {
        this(DEFAULT_CAPACITY, null);
    }
    /**
     * Create a FoodQueue from a Collection, with the default capacity of 20
     * 
     * @param clothes A collection of foods, such as another FoodQueue.
     */
    public FoodQueue(Collection<Food> foods) {
        this(DEFAULT_CAPACITY, foods);
    }    
    /**
     * Create a new FoodQueue with a custom capacity
     * @param capacity The maximum number of elements the queue can contain
     */
    public FoodQueue(int capacity) {
        this(capacity, null);
    }
    /**
     * Create a new FoodQueue
     * @param capacity The maximum number of elements the queue can contain
     * @param clothes A collection of foods, such as another FoodQueue.
     */
    public FoodQueue(int capacity, Collection<Food> foods) {
        this.capacity = capacity;
        this.tail = -1; // the first element goes at 0;
        this.head = 0;
        elements = new Food[capacity];

        if (foods != null) {
            for (Food f : foods) {
                this.enqueue(f);
            }
        }
    }

    // Modification methods

    /** Add a new element to the tail of the queue */
    public boolean enqueue(Food f) {
        if (isFull()) {
            return false;
        }

        tail = (tail + 1) % capacity;
        elements[tail] = f;
        size++;
        return true;
    }
    /** Retrieve and remove the least recent element from the head of the queue */
    public Food dequeue() {
        if (isEmpty()) {
            return null;
        }
        int get = head;
        head = (head + 1) % capacity;
        size--;
        return elements[get];
    }
    /** Retrieve the least recent element from the head of the queue without removing it */
    public Food peek() {
        return elements[head];
    }

    /** @return {@code true} if the Queue has reached its maximum capacity */
    public boolean isFull() {
        return (size == capacity);
    }
    /** @return The maximum number of elements this queue can contain */
    public int capacity() {
        return this.capacity;
    }

    // Display Method

    public void displayAllFoods() {
        System.out.printf("=== QUEUE WITH %d / %d ELEMENTS ===\n", size, capacity);
        for (Food f : this) {
            System.out.println(" * " + f.toString());
        }
        System.out.println("AVG CALORIES: " + averageCaloriesPerServing() + " per serving");
        Food highest = getHighestCalorieFood();
        System.out.printf("Highest Calorie Food: %s (%d total calories)", highest.getName(), highest.getTotalCalories());
    }

    // Calculation methods

    /** @return average calories per serving of all the foods in the queue */
    public int averageCaloriesPerServing() {
        int sum = 0;
        for (Food f : this) {
            sum += f.getCaloriesPerServing();
        }
        return sum / this.size();
    }
    /** @return the food with the highest total calories */
    public Food getHighestCalorieFood() {
        Food maximum = this.peek();
        for (Food f : this) {
            if (f.getTotalCalories() > maximum.getTotalCalories()) {
                maximum = f;
            }
        }
        return maximum;
    }

    // Collection Methods

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<Food> iterator() {
        return new Iterator<Food>() {
            private int nextIndex = head; // index of the first element is at tail;
            private int lastAccessed = -1;
            @Override
            public boolean hasNext() {
                return (lastAccessed != tail);
            }
            @Override
            public Food next() {
                if (hasNext()) {
                    lastAccessed = nextIndex;
                    nextIndex = (nextIndex + 1) % capacity;
                    return elements[lastAccessed];
                }
                throw new IndexOutOfBoundsException();
            }
        };
    }

    @Override
    public FoodQueue clone() {
        return new FoodQueue(this);
    }
}