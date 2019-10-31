package module_6.lab_6a;

/**
 * Represents a time in a 24-hour format as a number of hours and minutes. Ranges from [00:00 and 23:59]
 */
public class Time24Hour {
    protected final int hours;
    protected final int minutes;
    
    /**
     * Create a new Time24Hour object, representing a time between (00:00 and 23:59)
     * 
     * @throws TimeFormatException If the time is not within the given range 
     * @hours A number of hours in range [0, 24)
     * @minutes A number of minutes within range [0, 60)
     */
    public Time24Hour(int hours, int minutes) throws TimeFormatException {
        this.hours = hours % 24;
        this.minutes = minutes;
        if (hours < 0 || 24 <= hours || minutes < 0 || 60 <= minutes) {
            throw new TimeFormatException("Error: " + this.toString() + " is out of bounds [00:00–23:59]");
        }
    }
    /** @return the first component of the time – the number of hours */
    public int getHours() {
        return this.hours;
    }

    /** @return the second component of the time – the number of hours */
    public int getMinutes() {
        return this.minutes;
    }

    /**
     * Create a new Time24Hour object by parsing a string
     * 
     * @param time A string formatted like {@code "12:34"}, representing a 24-hour time
     * @throws TimeFormatException if time cannot be parsed, or is out of bounds.
     */
    public static Time24Hour parseTime(String time) throws TimeFormatException {
        int hours, minutes;
        String[] components = time.split(":", 2); // "12:34" => [12, 34];
        if (components.length != 2) {
            throw new TimeFormatException("Error: time must be in the format \"xx:xx\"");
        }
        try {
            hours = Integer.parseInt(components[0]);
            minutes = Integer.parseInt(components[1]);
        } catch (NumberFormatException e) {
            throw new TimeFormatException("Error: \"" + time + "\" is not a valid 24-hour time (ex. \"12:34\")");
        }
        return new Time24Hour(hours, minutes);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }
    /**  */
    public String get12HourTime() {
        int hours = this.getHours();
        int minutes = this.getMinutes();
        boolean isPm = (hours >= 12);
        hours %= 12;
        if (hours == 0) {
            hours = 12;
        }
        return String.format("%02d:%02d %s", hours, minutes, (isPm ? "PM" : "AM"));
    }
}