package module_2.lab_2b;

/**
 * Octagon
 */
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

    /** 
     * Create a Regular Octagon object
     * @param sideLength The length of the 
     */
    public Octagon(double sideLength) {
        super(/* sidecount = */ 8, sideLength);
    }

    /** @return the perimeter of the Octagon, given by the equation `8a` */
    @Override
    public double getPerimeter() {
        double a = getSideLength();
        return a * 8;
    }
    /** @return the area of the Octagon, given by the equation `2(1 + sqrt 2)a^2` */
    @Override
    public double getArea() {
        double a = getSideLength();
        return 2 * (1 + Math.sqrt(2)) * Math.pow(a,2);
    }


    /**
     * Compares one object with another object for order. Returns a negative
     * integer, zero, or a positive integer if the first object is less than, equal
     * to, or greater than the second
     * 
     * @param o1 An octagon
     * @param o2 An octagon to compare the first octagon to
     * @return either <code>-1</code>, <code>0</code>, or <code>1</code>
     */
    public static int compare(Octagon o1, Octagon o2) {
        double len1 = o1.getSideLength();
        double len2 = o2.getSideLength();
        int lengthCompare = Double.compare(len1, len2);
        return lengthCompare;
    }

    /**
     * Compares this object with the specified object for order. Returns a negative
     * integer, zero, or a positive integer as this object is less than, equal to,
     * or greater than the specified object.
     * 
     * @param anotherObj A geometric object to compare to
     * @return either <code>-1</code>, <code>0</code>, or <code>1</code>
     */
    public int compareTo(Octagon o2) {
        return compare(this, o2);
    }

    /** @return */
    public boolean equals(Octagon o2) {
        return (this.compareTo(o2) == 0);
    }

    public Octagon clone() {
        return new Octagon(this.getSideLength());
    }
}