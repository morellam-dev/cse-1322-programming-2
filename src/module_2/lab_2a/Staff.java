package module_2.lab_2a;

/**
 * Staff
 */
public class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phone, String email, 
    String office, String salary, MyDate dateHired, 
    String title) {
        super(name, address, phone, email, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" 
            + "TITLE: " + title;
    }
}