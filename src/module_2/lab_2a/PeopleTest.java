package module_2.lab_2a;

/**
 * PeopleTest
 */
public class PeopleTest {
    public static void main(String[] args) {
        // Person demo
        Person johnEgbert = new Person(
            "John Egbert", 
            "999 Sample Street", 
            "123-456-7890", 
            "ectoBiologist@pesterchum.net");
        System.out.println(johnEgbert.toString());
        System.out.println();

        // Student demo
        Student daveStrider = new Student("Dave Strider", 
            "420 Wicked Lane", 
            "420-555-6969", 
            "coolguy6969@radical.biz",
            /* classStatus: */ "senior");
        System.out.println(daveStrider.toString());
        System.out.println();

        // Employee demo
        Employee tereziPyrope = new Employee(
            "Terezi Pyrope",
            "612 Alternia Drive",
            "413-612-0101",
            "g4llowsCallibrator@troll.ian",
            "Room BR34K-H34DS", 
            "$41,309", 
            new MyDate(2011, 11, 11));
        
        System.out.println(tereziPyrope.toString());
        System.out.println();

        Faculty principalSkinner = new Faculty(
            "Seymour Skinner",
            "123 Springfield Lane",
            "789-555-8080",
            "steamed.hams@springfield.edu",
            "Room H4-M5", 
            "$123,456", 
            new MyDate(1989, 12, 17),
            "MTWRF - 9am – 5pm",
            "Principal"
        );
        System.out.println(principalSkinner.toString());
        System.out.println();

        Staff janitorScruffy = new Staff(
            "Scruffy the Janitor",
            "4321 New New York",
            "555-555-5555",
            "scruffy.the.janitor@planetexpress.com",
            "JC-3000", 
            "$12,345", 
            new MyDate(3000, 01, 01),
            "Janitor"
        );
        System.out.println(janitorScruffy.toString());
        System.out.println();

    }
}