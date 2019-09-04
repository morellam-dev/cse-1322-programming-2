package module_2.lab_2b;

/**
 * Octagon
 */
public class Octagon extends GeometricObject {

    /** 
     * Create an equilateral Octagon object
     * @param sideLength The length of the 
     */
    public Octagon(double sideLength) {
        super(/* sidecount = */ 8, sideLength);
    }

    /** @return the perimeter of the Octagon, given by the equation `8a` */
    public double getPerimeter() {
        double a = getSideLength();
        return a * 8;
    }
    /** @return the area of the Octagon, given by the equation `2(1 + sqrt 2)a^2` */
    public double getArea() {
        double a = getSideLength();
        return 2 * (1 + Math.sqrt(2)) * Math.pow(a,2);
    }
}