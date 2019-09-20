package module_2.lab_2b;
import java.util.StringJoiner;

/**
 * A regular polygon with a discrete number of sides, each one of the same
 * length. Subclasses must implement a {@code getArea} method, as well as a
 * {@code getSideLength} method, to determine how many sides the shape has.
 */
abstract class GeometricObject implements Comparable<GeometricObject> {
    private final double edgeLength;

    /**
     * Create a new {@code GeometricObject} instance
     * 
     * @param edgeLength The length of this shape's sides
     */
    public GeometricObject(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    /** @return The length of this shape's sides */
    public double getEdgeLength() {
        return this.edgeLength;
    }

    /** @return This shape's perimeter */
    public double getPerimeter() {
        double perimExact = this.getSideCount() * this.getEdgeLength();
        return Math.round(perimExact * 100) / 100;
    }

    /** @return The number of sides this shape has */
    public abstract int getSideCount();

    /** @return This shape's area */
    abstract public double getArea();

    /**
     * Compare a shape to another by its side count, then its area. The sign of the
     * integer returned will be in line with that of {@code Double.compare}.
     * 
     * @param o1 The first shape to compare
     * @param o2 The second shape to compare
     * @return {@code 0} if the objects are equal.
     */
    public static int compare(GeometricObject o1, GeometricObject o2) {
        // Compare first by number of sides
        int sidesCompare = Integer.compare(o1.getSideCount(), o2.getSideCount());
        if (sidesCompare != 0) {
            return sidesCompare;
        }
        // If they are the same, then compare by side length.
        int lengthCompare = Double.compare(o1.getEdgeLength(), o2.getEdgeLength());
        return lengthCompare;
    }

    /**
     * Compare this shape to another by its side count, then its area. The sign of
     * the integer returned will be in line with that of {@code Double.compare}.
     * 
     * @param o1 The first shape to compare
     * @param o2 The second shape to compare
     * @return {@code 0} if the objects are equal.
     */
    public int compareTo(GeometricObject o2) {
        return compare(this, o2);
    }

    /**
     * @param o2 Another shape to compare this one to
     * @return Whether or not this and another shape are equivalent, determined by
     *         whether or not they have the same number of sides, and the same
     *         length.
     */
    public boolean equals(GeometricObject o2) {
        return (compareTo(o2) == 0);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + " edgeLength='" + getEdgeLength() + "'" + "}";
    }
}

/**
 * A regular octagon, with sides of all the same length. Implements the abstract
 * methods in its parent class, as well as the {@code Cloneable} interface
 */
class Octagon extends GeometricObject implements Cloneable {
    public static final int sideCount = 8;

    /**
     * Construct a new regular Octagon
     * @param edgeLength The length of each side
     */
    public Octagon(double edgeLength) {
        super(edgeLength);
    }

    public int getSideCount() {
        return 8;
    }

    public double getArea() {
        double a = this.getEdgeLength();
        double areaExact = 2 * (1 + Math.sqrt(2)) * a * a;
        return (int)(areaExact * 100) / 100;
    }

    @Override
    public Octagon clone() {
        double edge = this.getEdgeLength();
        return new Octagon(edge);
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("Edge length: " + this.getEdgeLength());
        joiner.add("Area: " + this.getArea());
        joiner.add("Perimeter: " + this.getPerimeter());
        return joiner.toString();
    }
}

/**
 * A regular octagon, with sides of all the same length. Implements the abstract
 * methods in its parent class, as well as the {@code Cloneable} interface
 */
class OctagonDemo {
    public static void main(String[] args) {
        Octagon o1 = new Octagon(8);
        Octagon o2 = new Octagon(6);
        Octagon o3 = o1.clone();
        System.out.println("=== OCTAGON o1 ===");
        System.out.println(o1.toString());
        System.out.println();
        System.out.println("=== OCTAGON o2 ===");
        System.out.println(o1.toString());
        System.out.println();
        System.out.println("=== OCTAGON o3 (clone of o1) ===");
        System.out.println(o1.toString());
        System.out.println();
        System.out.println("o3.equals(o1) => " + o3.equals(o1));
        System.out.println("o3.compareTo(o2) => " + o3.compareTo(o2));
    }
}