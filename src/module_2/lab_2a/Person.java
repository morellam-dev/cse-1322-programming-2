package module_2.lab_2a;

/**
 * Person
 */
public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    /**
     * Construct a new <code>Person</code> object
     * 
     * @param name         The <code>Person</code>'s name (ex: "John Egbert")
     * @param address      The <code>Person</code>'s address (ex: "420 Wicked Lane")
     * @param phoneNumber  The <code>Person</code>'s phone number (ex:
     *                     "123-456-7890")
     * @param emailAddress The <code>Person</code>'s email address (ex:
     *                     "sample@address.com")
     */
    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    /** Get's the name of this object's class or sub-class
     * @return a class name like <code>"Person"</code> or <code>"Student"</code>*/
    public String getClassName() {
        return this.getClass().getSimpleName();
    }
    /** @return an appropriate label for the person. */
    public String getTitle() {
        return this.getClassName();
    }
    
    /** Print out all of the person's data */
    public void display() {
        System.out.println("👤  " + this.getTitle().toUpperCase() + ": " + this.name);
        System.out.println("🏠  Address: " + address);
        System.out.println("📞  Phone: " + phoneNumber);
        System.out.println("✉️  Email: " + emailAddress);
    }
}