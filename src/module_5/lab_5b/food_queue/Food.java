package module_5.lab_5b.food_queue;

/**
 * Represents an item of food, the number of calories per serving and the number of servings per container 
 * @author M Morella
 */
public class Food implements Cloneable {
    final private String name;
    final private int calories;
    final private int servings;

    /**
     * Initialize a new Food object
     * @param name The name of the food
     * @param calories The number of calories per serving
     * @param servings The number of servings per container
     */
    public Food(String name, int calories, int servings) {
        this.name = name;
        this.calories = calories;
        this.servings = servings;
    }
    /** @return The name of the food */
    public String getName() {
        return this.name;
    }
    /** @return The number of calories per serving */
    public int getCalories() {
        return this.calories;
    }
    /** @return The number of servings per container */
    public int getServings() {
        return this.servings;
    }
    /** @return the total number of calories per container */
    public int getTotalCalories() {
        return calories * servings;
    }
    @Override
    public String toString() {
        return String.format("%s - %s calories per serving (%s servings)", name, calories, servings);
    }

    public Food clone() {
        return new Food(name, calories, servings);
    }
}