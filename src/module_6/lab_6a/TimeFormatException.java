package module_6.lab_6a;

/**
 * Indicates an error in parsing a time
 */
public class TimeFormatException extends Exception {
    private static final long serialVersionUID = -2928895735526016619L;

    public TimeFormatException(String message) {
        super(message);
    }
}