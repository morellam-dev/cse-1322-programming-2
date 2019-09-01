package playground;

import java.util.Objects;
/**
 * SimpleClass
 */
public class SimpleClass {
    private String name;
    private int age;
    private double gpa;

    public SimpleClass(String myName, int myAge, double myGPA) {
        this.name = myName;
        this.age = myAge;
        this.gpa = myGPA;
    }

    public String getMyName() {
        return this.name;
    }

    public void setMyName(String myName) {
        this.name = myName;
    }

    public int getMyAge() {
        return this.age;
    }

    public void setMyAge(int myAge) {
        this.age = myAge;
    }

    public double getMyGPA() {
        return this.gpa;
    }

    public void setMyGPA(double myGPA) {
        this.gpa = myGPA;
    }

    public SimpleClass myName(String myName) {
        this.name = myName;
        return this;
    }

    public SimpleClass myAge(int myAge) {
        this.age = myAge;
        return this;
    }

    public SimpleClass myGPA(double myGPA) {
        this.gpa = myGPA;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SimpleClass)) {
            return false;
        }
        SimpleClass simpleClass = (SimpleClass) o;
        return Objects.equals(name, simpleClass.name) && age == simpleClass.age && gpa == simpleClass.gpa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gpa);
    }

    @Override
    public String toString() {
        return "{" +
            " myName='" + getMyName() + "'" +
            ", myAge='" + getMyAge() + "'" +
            ", myGPA='" + getMyGPA() + "'" +
            "}";
    }


}