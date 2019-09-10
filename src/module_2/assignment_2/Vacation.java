package module_2.assignment_2;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Vacation
 */
public abstract class Vacation {
    private final String destination;
    private final double budget;

    /** Construct a Vacation object
     * 
     * @param destination The vacation's destination
     * @param budget      The budget alloted for the vacation
     */
    public Vacation(String destination, double budget) {
        this.destination = destination;
        this.budget = budget;
    }
    /** @return the Vacation's destination */
    public String getDestination() {
        return this.destination;
    }
    /** @return the Vacation's budget */
    public double getBudget() {
        return this.budget;
    }
    /** @return The price of the vacation */
    public abstract double getTotalCost();
    
    /**
     * @return The difference between the budget and the cost. If money is leftover,
     *         the surplus is positive, if over-budget, the surplus is negative.
     */
    public double getSurplus() {
        return getBudget() - getTotalCost();
    }

    /**
     * @param n A number (in dollars) to convert for a display format 
     * @return a <code>String</code> formatted as US currency, such as <code>"$1,500.00"</code> */
    public static String moneyFormat(double n) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        return format.format(n);
    }

    /** Print out all relevant class information */
    public abstract void display();
    

}