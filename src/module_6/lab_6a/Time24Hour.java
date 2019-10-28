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

    public int getHours() {
        return this.hours;
    }

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
        try {
            String[] components = time.split(":", 2); // "12:34" => [12, 34];
            hours = Integer.parseInt(components[0]);
            minutes = Integer.parseInt(components[1]);
        } catch (Exception e) {
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