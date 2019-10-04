package module_5.lab_5b;

/**
 * A data-type referring to a single article of clothing
 * @author M. Morella
 */
public class Clothing {
    final private String name;
    final private String color;
    final private boolean highTempWashable;
 
    /**
     * Initializes a newly created Clothing object
     * @param name The name of the clothing
     * @param color The color of the clothing
     * @param highTemp Whether or not the clothes can be washed at high temperatures
     */
    public Clothing(String name, String color, boolean highTempWashable) {
        this.name = name;
        this.color = color;
        this.highTempWashable = highTempWashable;
    }

    /** @return The name of the clothing */
    public String getName() {
        return this.name;
    }

    /** @return The color of the clothing */
    public String getColor() {
        return this.color;
    }

    /** @return Whether or not the clothes can be washed at high temperatures */
    public boolean isHighTempWashable() {
        return this.highTempWashable;
    }


    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", color='" + getColor() + "'" +
            ", highTempWashable='" + isHighTempWashable() + "'" +
            "}";
    }

    public String toSimpleString() {
        String washable = highTempWashable? " (high-temp washable)" : "";
        return color + " " + name + washable;
    }
}