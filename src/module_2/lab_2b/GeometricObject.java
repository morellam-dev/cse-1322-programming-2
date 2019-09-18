package module_2.lab_2b;

/**
 * An equilateral polygon with a discrete number of sides
 */
public abstract class GeometricObject {
    private final int sideCount;
    private final double sideLength;
    
    /** Construct a new GeometricObject
     * @param sideCount How many sides the shape has
     * @param sideLength How long each side is
     */
    public GeometricObject(int sideCount, double sideLength) {
        this.sideCount = sideCount;
        this.sideLength = sideLength;
    }

    /** @return the number of sides the shape has */
    public int getSideCount() {
        return this.sideCount;
    }

    /** @return the length of sides */
    public double getSideLength() {
        return this.sideLength;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}