package playground;

import java.util.ArrayList;

class ArrayListPractice {
    static class Car {
        private String make;
        public Car(String make) {
            this.make = make;
        }
        public String getMake() {
            return this.make;
        }
    }
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Hey"));
        cars.add(new Car(""));
    }
}