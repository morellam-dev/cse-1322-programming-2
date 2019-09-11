package module_2.lab_2a;

/**
 * Student
 */
public class Student extends Person {
    private String classStatus;

    /**
     * Construct a new student
     * @param name         The person's name (ex: "Nick Coolkid")
     * @param address      The person's address (ex: "420 Wicked Lane")
     * @param phoneNumber  The person's phone number (ex: "123-456-7890")
     * @param emailAddress The person's email address (ex: "coolkid69@email.com")
     * @param classStatus  The student's class status (ex: "senior")
     */
    public Student(String name, String address, String phone, String email, 
        String classStatus) {
        super(name, address, phone, email);
        this.classStatus = classStatus;
    }

    public String toString() {
        return (
            super.toString() + "\n"
                + "📚  Class Status: " + classStatus
        );
    }
}