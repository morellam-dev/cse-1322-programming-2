package module_2.assignment_2;

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
    @Override
    public double getTotalCost() {
        return this.price;
    }

    /** Display a number of stars using Emoji or Unicode characters
     * @param stars The number of stars to show filled
     * @param total The total number of stars to show
     * @param star The character to represent filled stars (ex: <code>"★"</code>)
     * @param noStar The character to represent unfilled stars (ex: <code>"☆"</code>)
     */
    public String starsToString(int stars, int total, String star, String noStar) {
        String out = "";
        for (int i = 1; i <= rating; i++) {
            out += star;
        }
        for (int i = rating + 1; i <= total; i++) {
            out += noStar;
        }
        return out;
    }
    /**
     * Display a number of stars using Emoji or Unicode characters
     * 
     * @param stars  The number of stars to show filled
     * @param total  The total number of stars to show
     */
    public String starsToString(int stars, int total) {
        return starsToString(stars, total, "★", "☆");
    }

    /** @return the star rating as a   */
    public String getRatingStars() {
        return starsToString(rating, 5);
    }

    public void display() {
        System.out.println("DESTINATION: " + getDestination());
        System.out.println("BRAND: " + brand);
        System.out.println("RATING: " + getRatingStars());
        System.out.println("BUDGET: " + moneyFormat(getBudget()));
        System.out.println("PRICE: " + moneyFormat(getTotalCost()));
        if (0 <= getSurplus()) {
            System.out.println("You have " + moneyFormat(getSurplus()) + " leftover.");
        }
        if (getSurplus() < 0) {
            System.out.println("You are " + moneyFormat(Math.abs(getSurplus())) + " over budget!");
        }
    }
}