package module_2.lab_2a;

/**
 * Person
 */
public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    /** @return the person's name */
    public String getName() {
        return this.name;
    }
    /** @return the Person's home address */
    public String getAddress() {
        return this.address;
    }
    /** @return the Person's phone number */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    /** @return the Person's email address */
    public String getEmailAddress() {
        return this.emailAddress;
    }

    /** @return the name of the current class (ex: "Person", "Student", etc.) */
    public String getType() {
        return this.getClass().getSimpleName();
    }
    
    /** Print out all of the person's data */
    public void display() {
        System.out.println("👤  " + this.getType().toUpperCase() + ": " + this.name);
        System.out.println("🏠  Address: " + address);
        System.out.println("📞  Phone: " + phoneNumber);
        System.out.println("✉️  Email: " + emailAddress);
    }
}