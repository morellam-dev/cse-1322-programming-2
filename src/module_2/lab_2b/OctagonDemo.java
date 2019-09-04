package module_2.lab_2b;

/**
 * OctagonDemo
 */
public class OctagonDemo {
    public static void main(String[] args) {
        Octagon octagonJoe = new Octagon(8.0);
        System.out.println("octagonJoe has side length " + octagonJoe.getSideLength());
        System.out.println("area =  " + octagonJoe.getArea() + ", "
            + "perimeter = " + octagonJoe.getPerimeter());
            
    }
}