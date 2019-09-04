package module_2.lab_2b;

/**
 * GeometricObject
 * Describes an equilateral polygon
 */
public abstract class GeometricObject implements Comparable<GeometricObject>, Cloneable {
    private int sideCount;
    private double sideLength;

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

    /** Numerically compare two shapes based on their number of sides, then their side lengths */
    public static int compare(GeometricObject o1, GeometricObject o2) {
        /*
         * Multi-field comparison method inspired by this thread on StackOverflow
         * https://stackoverflow.com/questions/369512/how-to-compare-objects-by-multiple
         * -fields
         */
        int i = Integer.compare(o1.getSideCount(), o2.getSideCount());
        if (i != 0)
            return i;
        return Double.compare(o1.getSideLength(), o2.getSideLength());
    }

    public int compareTo(GeometricObject anotherObj) {
        return compare(this, anotherObj);
    }

    /** Abstract method getArea */
    public abstract double getArea();


    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
}