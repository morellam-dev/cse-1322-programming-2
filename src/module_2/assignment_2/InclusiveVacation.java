package module_2.assignment_2;

import java.util.StringJoiner;

/**
 * All-Inclusive Vacation
 */
public class InclusiveVacation extends Vacation {
    private final double price;
    private final String brand;
    private final int rating;
    
    /**
     * Construct an InclusiveVacation
     * 
     * @param destination The vacation's destination
     * @param budget      The budget (in dollars) alloted for the vacation
     * @param price       The price (in dollars) of the full vacation
     * @param brand       The name of the company supplying the vacation
     * @param rating      The rating (1-5 stars) of the vacation
     */
    public InclusiveVacation(
        String destination, double budget,
        double price, String brand, int rating) {
            super(destination, budget);
            this.price = price;
            this.brand = brand;
            this.rating = rating;
    }
    
    public double getTotalCost() {
        return this.price;
    }

    /** Display a number of stars using Emoji or Unicode characters
     * @param stars The number of stars to show filled
     * @param total The total number of stars to show
     * @param star The character to represent filled stars (ex: <code>"★"</code>)
     * @param noStar The character to represent unfilled stars (ex: <code>"☆"</code>)
     */
    public static String starString(int stars, int total, String star, String noStar) {
        StringJoiner joiner = new StringJoiner("");
        for (int i = 1; i <= stars; i++) {
            joiner.add(star);
        }
        for (int i = stars + 1; i <= total; i++) {
            joiner.add(noStar);
        }
        return joiner.toString();
    }
    /**
     * Display a number of stars using Emoji or Unicode characters
     * 
     * @param stars  The number of stars to show filled
     * @param total  The total number of stars to show
     */
    public static String starString(int stars, int total) {
        return starString(stars, total, "★", "☆");
    }
    /** @return the star rating as a   */
    public String getRatingStars() {
        return starString(rating, 5);
    }

    public void display() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add("DESTINATION: " + this.getDestination());
        joiner.add("BRAND: " + this.brand);
        joiner.add("RATING: " + this.getRatingStars());
        joiner.add("BUDGET: " + moneyFormat(getBudget()));
        joiner.add("PRICE: " + moneyFormat(getTotalCost()));
        joiner.add(getSurplusString());
        return joiner.toString();
    }
}