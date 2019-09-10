package module_2.assignment_2;

import java.util.HashMap;

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
    public PiecemealVacation(
        String destination, double budget,
        HashMap<String, Double> items) {
            super(destination, budget);
            this.items = items;
    }

    public double getTotalCost() {
        double total = 0;
        for (Double i : items.values()) {
            total += i;
        }
        return total;
    }
    
    public void display() {
        System.out.println("DESTINATION: " + getDestination());
        System.out.println("BUDGET: " + moneyFormat(getBudget()));
        System.out.println("ITEMS: ");
        items.forEach(
            (k, v) -> {
                System.out.println(" • " + k + ": " + moneyFormat(v));
            }
        );
        System.out.println("TOTAL PRICE:" + moneyFormat(getTotalCost()));
        if (0 <= getSurplus()) {
            System.out.println("You have " + moneyFormat(getSurplus()) + " leftover.");
        }
        if (getSurplus() < 0) {
            System.out.println("You are " + moneyFormat(Math.abs(getSurplus())) + " over budget!");
        }
    }
}