package module_5.lab_5b.clothing_stack;

/**
 * Clothing
 */
public class Clothing {
    private final String name;
    private final String color;
    private final boolean machineWashable;

    /** Create a new article of Clothing 
     * @param color           The color of the clothing (ex. "red")
     * @param name            The name of the clothing (ex. "shirt")
     * @param machineWashable Whether the clothing is machine washable
    */
    public Clothing(String color, String name, boolean machineWashable) {
        this.name = name;
        this.color = color;
        this.machineWashable = machineWashable;
    }
    /** @return the name of the clothing */
    public String getName() {
        return this.name;
    }

    /** @return the color of the clothing */
    public String getColor() {
        return this.color;
    }

    

    /** @return whether or not the clothing is machine-washable */
    public boolean getMachineWashable() {
        return this.machineWashable;
    }
    /** @return whether or not the clothing is machine-washable */
    public boolean isMachineWashable() {
        return getMachineWashable();
    }


    @Override
    /**
     * @return a string representation of the string, like
     *         {@code "red hoodie (machine-washable)"}
     */
    public String toString() {
        return color + " " + name 
            + (machineWashable ? " (machine-washable)" : "");
    }

    
}