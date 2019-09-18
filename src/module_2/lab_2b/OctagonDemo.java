package module_2.lab_2b;

/**
 * OctagonDemo
 */
public class OctagonDemo {
    public static void main(String[] args) {
        Octagon octagonAlice = new Octagon(8.0);
        System.out.println("octagonAlice has side length " + octagonAlice.getSideLength());
        System.out.println("area =  " + octagonAlice.getArea() + "\n"
            + "perimeter = " + octagonAlice.getPerimeter());
        System.out.println();

        Octagon octagonBob = new Octagon(6.0);
        System.out.println("octagonBob has side length " + octagonBob.getSideLength());
        System.out.println("area =  " + octagonBob.getArea() + "\n" + "perimeter = " + octagonBob.getPerimeter());
        System.out.println();
        System.out.println("octagonAlice.equals(octagonBob) == " + octagonAlice.equals(octagonBob));

        Octagon octagonCarl = octagonAlice.clone();
        System.out.println("octagonCarl is a clone of octagonAlice, with side length " + octagonCarl.getSideLength());
        System.out.println();

        System.out.println("octagonAlice.equals(octagonCarl) == " + octagonAlice.equals(octagonCarl));
    }
}