package module_2.lab_2a;

/**
 * Employee
 */
public class Employee extends Person {
    private String office;
    private String salary;
    private MyDate dateHired;
    
    /**
     * Construct a new Employee
     * 
     * @param name         The person's name (ex: "Nick Coolkid")
     * @param address      The person's address (ex: "420 Wicked Lane")
     * @param phoneNumber  The person's phone number (ex: "123-456-7890")
     * @param emailAddress The person's email address (ex: "coolkid69@email.com")
     * @param office       The location of the employee's office
     * @param salary       The employee's yearly salary (ex: "$9999")
     * @param dateHired    The date the employee was hired (ex: new MyDate(2000, 01, 01))
     */
    public Employee(String name, String address, String phone, String email, 
        String office, String salary, MyDate dateHired) {
        super(name, address, phone, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public void display() {
        super.display(); // Name
        System.out.println("📅  Hire Date: " + dateHired.toString());
        System.out.println("💵  Salary: " + salary);
        System.out.println("💼  Office: " + office + "");
    }
}