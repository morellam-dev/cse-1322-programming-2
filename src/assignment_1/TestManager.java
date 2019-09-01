package assignment_1;
import java.util.Scanner;

/** 
 * A program for manipulating a class of students 
 * represented by Tests objects
 */

class TestManager {
    public Tests[] students;

    /** 
     * Create a TestManager using a pre-defined array of Tests
     * @param newStudent An array of Tests objects
     */
    public TestManager(Tests[] newStudent) {
        this.students = newStudent.clone();
    }
    /**
     * Generate a TestManager using input from the console
     * @param in  A Scanner object to recieve input from, as in 'new Scanner(System.in)'
     * @param len The length of array to populate.
     */
    public TestManager(Scanner in, int len) {
        students = new Tests[len];
        for (int i = 0; i < len; i++) {
            String prompt = "Student #" + (i + 1) + ":\n";
            students[i] = inputStudent(in, prompt);
            System.out.println(students[i].toString());
        }
    }

    /**
     * Calculate and return the total average grade of every student
     * @return (sum of student avgs) / class size
     */
    public int getClassAverage() {
        int average = 0;
        for (int i = 0; i < students.length; i++) {
            average += students[i].getAverage();
        }
        return average / students.length;
    }

    /** 
     * Prompt the user for input via the console, then return their input as a string.
     * @param in     A Scanner object, as in 'new Scanner(System.in)'
     * @param prompt The message to display, like "Enter name: "
     * @return       The user's input.
     */
    public static String inputLine(Scanner in, String prompt) {
        System.out.print(prompt);
        return in.nextLine();
    }
    /**
     * Prompt the user for input via the console, then return their input as an integer.
     * @param in     A Scanner object, as in 'new Scanner(System.in)'
     * @param prompt The message to display, like "Enter name: "
     * @return The user's input.
     */
    public static int inputInt(Scanner in, String prompt) {
        while (true) {
            try {
                String input = inputLine(in, prompt);
                return Integer.parseInt(input);
            } catch (Exception e) {
            }
        }
    }
    /**
     * Using several prompts, ask the user to input a student's name and scores, then
     * return their input as a new Tests object.
     * @param in     A Scanner object, as in 'new Scanner(System.in)'
     * @param prompt The message to display, like "Enter name: "
     * @return       A new Tests object with a populated scores array.
     */
    public static Tests inputStudent(Scanner in, String prompt) {
        System.out.print(prompt);
        String firstName = inputLine(in, "First name: ");
        String lastName = inputLine(in, "Last name: ");
        int[] scores = new int[5];
        for (int i = 0; i < 5; i++) {
            scores[i] = inputInt(in, "Enter score #" + (i + 1) + ": ");
        }
        return new Tests(firstName, lastName, scores);
    }
    /** 
     * Returns a formatted row 
     */
    public static String tableHelper(String name, String scores, String avg, String grade) {
        return String.format("%-25s %-20s %-5s %-5s", name, scores, avg, grade);
    }

    /** 
     * Print the full class data as a formatted table.
     */
    public void displayTable() {
        String tableHeader = tableHelper("Name", "Scores", "AVG", "Grade");
        System.out.println(tableHeader);
        // Table divider
        System.out.println("========================================================");
        for (Tests student : students) {
            String tableRow = tableHelper(
                student.getFullName(), // Name
                student.getScoreList(), // Scores
                student.getAverage() + "", // Average
                student.getLetterGrade() // Grade
            );
            System.out.println(tableRow);
        }
        System.out.println("Class Average: " + this.getClassAverage());
    }
    
    public static void main(String[] args) {
        try (Scanner console = new Scanner(System.in)) {
            Tests[] exampleData = new Tests[]{
                new Tests("Jack", "Johnson", new int[]{85, 83, 77, 91, 76}),
                new Tests("Lisa", "Aniston", new int[]{80, 90, 95, 93, 48}),
                new Tests("Andy", "Cooper", new int[]{78, 81, 11, 90, 73}),
                new Tests("Ravi", "Gupta", new int[]{92, 83, 30, 69, 87}),
                new Tests("Bonny", "Blair", new int[]{23, 45, 96, 38, 59}),
                new Tests("Danny", "Clark", new int[]{60, 85, 45, 39, 67}),
                new Tests("Samantha", "Kennedy", new int[]{77, 31, 52, 74, 83}),
                new Tests("Robin", "Bronson", new int[]{93, 94, 89, 77, 97}),
                new Tests("Sun", "Xie", new int[]{79, 85, 28, 93, 82}),
                new Tests("Kiran", "Patel", new int[]{85, 72, 49, 75, 63}),
            };

            TestManager example = new TestManager(console, 5);
            example.displayTable();
        }
    }
}