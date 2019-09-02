package module_2.lab_2a;

/**
 * Person
 * Getters and constructor generated from fields using Sohibe's Java Code Generator plugin
 */
public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress
    ) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    @Override
    public String toString() {
        String className = this.getClass().getSimpleName();
        return className.toUpperCase() + ": " + this.getName() + "\n"
            + "ADDR: " + address + "\n" 
            + "PHONE: " + phoneNumber + "\n" 
            + "EMAIL: " + emailAddress;
    }
}