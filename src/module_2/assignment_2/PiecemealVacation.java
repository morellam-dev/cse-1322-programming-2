package module_2.assignment_2;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;


/**
 * PiecemealVacation
 */
public class PiecemealVacation extends Vacation {
    private HashMap<String, Double> items;

    /**
     * Construct a PiecemealVacation
     * 
     * @param destination The vacation's destination
     * @param budget      The budget (in dollars) alloted for the vacation
     * @param items       A data set containing items and their prices.
     */
    public PiecemealVacation(String destination, double budget, HashMap<String, Double> items) {
        super(destination, budget);
        this.items = items;
    }

    public double getTotalCost() {
        double total = 0;
        for (double i : items.values()) {
            total += i;
        }
        return total;
    }

    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("DESTINATION: " + this.getDestination());
        joiner.add("BUDGET: " + moneyFormat(getBudget()));
        joiner.add("ITEMS:");
        // forEach key-value pair in the HashMap
        for (Map.Entry<String, Double> entry : this.items.entrySet()) {
            String key = entry.getKey();
            double val = entry.getValue();
            String line = String.format("%-10s %-10s", key, moneyFormat(val));
            joiner.add(" • " + line);
        };
        joiner.add(String.format("%-10s %-10s","TOTAL PRICE: ", moneyFormat(getTotalCost())));
        joiner.add(getSurplusString());
        return joiner.toString();
    }
}