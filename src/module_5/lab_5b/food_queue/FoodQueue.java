package module_5.lab_5b.food_queue;

/**
 * ClothingStack
 * 
 * @author M Morella
 */
public class FoodQueue implements Cloneable {
    /** The size of the queue when constructed with the default constructor */
    private final static int DEFAULT_CAPACITY = 20;
    /** The number of elements that the queue can contain */
    final private int capacity;
    /** An array containing the queue's elements */
    private Food[] queue;
    /** The index of the element at the start of the queue. 
     * This is the element that {@code peek} and {@code dequeue} return */
    private int front = 0; 
    /** The index of the element at the end of the queue. 
     * The {@code enqueue} method inserts elements at {@code rear + 1} */
    private int rear = -1;
    /** The number of elements currently in the queue */
    private int size = 0;

    /**
     * Initialize a new queue of foods
     * 
     * @param capacity The maximum number of foods that can fit in the array
     * @param clothes  An optional array of foods to start the stack with
     */
    public FoodQueue(int capacity, Food... foods) {
        this.capacity = capacity;
        this.queue = new Food[capacity];
        for (Food f : foods) {
            this.enqueue(f);
        }
    }
    /**
     * Initialize a new empty queue of food with the default size of 20
     */
    public FoodQueue() {
        this(DEFAULT_CAPACITY);
    }
    /**
     * Access the item at the front of the queue without removing it
     * 
     * @return The least recently added piece of Food or {@code null} if the queue is empty
     */
    public Food peek() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }
    /**
     * Access the item at the front of the queue, and remove it.
     * 
     * @return The least recently added piece of Food or {@code null} if the queue is empty
     */
    public Food dequeue() {
        if (isEmpty()) {
            return null;
        }
        Food pop = queue[front];
        front = (front + 1) % capacity;
        size--;
        return pop;
    }
    /**
     * Insert an item into the end of the queue.
     * 
     * @return {@code true} is the insertion is successful, or {@code false} if the stack is full
     */
    public boolean enqueue(Food f) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = f;
        size++;
        return true;
    }
    /** @return the average calories per serving of all the foods in the queue */ 
    public int getAverageCalories() {
        int sum = 0;
        /* Because this class doesn't implement Collections or Iteratable, 
        performing a "for-each" requires cloning the class and dequeueing each element. */
        FoodQueue clone = this.clone();
        while (!clone.isEmpty()) {
            Food f = clone.dequeue();
            sum += f.getCalories();
        }
        return sum;
    }

    /** @return the food items with the highest total calories per container */
    public Food getHighestCalorieFood() {
        FoodQueue clone = this.clone();
        Food highest = clone.dequeue();
        while (!clone.isEmpty()) {
            Food f = clone.dequeue();
            if (f.getTotalCalories() > highest.getTotalCalories()) {
                highest = f;
            }
        }
        return highest;
    }

    /** @return the maximum number of Food items in the queue */
    public int getCapacity() {
        return capacity;
    }
    /** @return the current number of Food items in the queue */
    public int getSize() {
        return size;
    }
    /** @return whether or not the queue is empty */
    public boolean isEmpty() {
        return size <= 0;
    }
    /** @return whether or not the queue is full */
    public boolean isFull() {
        return size == capacity;
    }
    /** A constructor intended for accurately cloning a queue's state */
    private FoodQueue(int capacity, Food[] queue, int front, int rear, int size) {
        this.capacity = capacity;
        this.queue = queue;
        this.front = front;
        this.rear = rear;
        this.size = size;
    }
    @Override
    public FoodQueue clone() {
        return new FoodQueue(capacity, queue.clone(), front, rear, size);
    }

    public void display() {
        FoodQueue clone = this.clone();
        int index = 0;
        while (!clone.isEmpty() && clone.peek() != null) {
            Food f = clone.dequeue();
            System.out.println("Food #" + (++index) + ": " + f.toSimpleString());
        }
    }
}