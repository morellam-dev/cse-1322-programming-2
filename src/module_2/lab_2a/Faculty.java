package module_2.lab_2a;

/**
 * Faculty
 */
public class Faculty extends Employee {
    private String officeHours;
    private String rank;
    
    /**
     * Construct a new Faculty member
     * @param name         The person's name (ex: "Nick Coolkid")
     * @param address      The person's address (ex: "420 Wicked Lane")
     * @param phoneNumber  The person's phone number (ex: "123-456-7890")
     * @param emailAddress The person's email address (ex: "coolkid69@email.com")
     * @param office       The location of the employee's office
     * @param salary       The employee's yearly salary (ex: "$9999")
     * @param dateHired    The date the employee was hired (ex: new MyDate(2000, 01, 01))
     * @param officeHours  The times when the faculty is available (ex: "MWF 9am - 12pm")
     * @param rank         The faculty member's rank (ex: "teacher")
     */
    public Faculty(String name, String address, String phone, String email, 
        String office, String salary, MyDate dateHired,
        String officeHours, String rank) {
        super(name, address, phone, email, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("🕒  Office Hours: " + officeHours);
        System.out.println("📎  Rank: " + rank);
    }
}