package module_2.lab_2a;
import java.io.IOException;

/**
 * PeopleTest: Demonstrate functionality of Employee, Faculty, PeopleTest
 */
public class Main {

    public static void displayPause() {
        try {
            System.in.read();
        } catch (IOException e) {}
    }
    public static void main(String[] args) {
        // Declare one example Person of each type 
        Person[] people = {
            // example Person
            new Person("John Egbert", 
                "999 Sample Street", 
                "123-456-7890", 
                "ectoBiologist@pesterchum.net"
            ),
            // example Student
            new Student(
                "Dave Strider", 
                "420 Wicked Lane", 
                "420-555-6969", 
                "coolguy6969@radical.biz",
                "senior"
            ),
            // example Employee
            new Employee(
                "Terezi Pyrope",
                "612 Alternia Drive",
                "413-612-0101",
                "g4llowsCallibrator@troll.ian",
                "Room BR34K-H34DS", 
                "$612612", 
                new MyDate(2009, 04, 13)
            ),
            // example Faculty
            new Faculty(
                "Seymour Skinner",
                "123 Springfield Lane",
                "789-555-8080",
                "steamed.hams@springfield.edu",
                "Room H4-M5", 
                "$123,456", 
                new MyDate(1989, 12, 17),
                "MTWRF - 9am – 5pm",
                "Principal"
            ),
            // example Staff
            new Staff(
                "Scruffy the Janitor",
                "4321 New New York",
                "555-555-5555",
                "scruffy.the.janitor@planetexpress.com",
                "JC-3000", 
                "$12,345", 
                new MyDate(3000, 01, 01),
                "Janitor"
            )
        };

        // Demo functionality
        while (true) {
            for (Person person : people) {
                System.out.println("\n\n\n\n\n\n\n\n");
                // PRINT all class fields
                System.out.println(person.toString());
                
                
                // PRINT some instructions
                System.out.println("=== OOP Demonstration: " + person.getClassName() + " Class ===");
                    
                // PAUSE for input
                System.out.print("Press Enter to continue...");
                displayPause();

                System.out.println();
            }
        }
    }
}