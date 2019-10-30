package module_5.assignment_5;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * BirdSurveyList
 */
public class BirdSurvey extends MyLinkedList<BirdSpecies> {
    private static final long serialVersionUID = 4838685580168749376L;
    private static final Scanner console = new Scanner(System.in);

    /**
     * Search the list for a BirdSpecies object which matches the given species.
     * 
     * @return A matching BirdSpecies object, or {@code null} if no such bird
     *         exists.
     */
    public BirdSpecies getBirdSpecies(String species) {
        species = species.toLowerCase().trim();
        for (BirdSpecies b : this) {
            if (b.getSpecies().equals(species)) {
                return b;
            }
        }
        return null;
    }

    public void addBird(String bird) {
        bird = bird.toLowerCase().trim();
        BirdSpecies b = this.getBirdSpecies(bird);
        if (b == null) {
            b = new BirdSpecies(bird, 1);
            this.add(b);
        } else {
            b.addCount(); // count += 1
        }
    }

    public void addBirds(String... birds) {
        for (String b : birds) {
            addBird(b);
        }
    }

    /**
     * @param The name of the species to look for
     * @return Return the number of birds counted for the given species
     */
    public int getCount(String species) {
        BirdSpecies b = getBirdSpecies(species);
        if (b == null) {
            return 0;
        }
        return b.getCount();
    }

    /** @return the number of unique species which have been recorded */
    public int getSpeciesCount() {
        return this.size();
    }

    /** @return the total number of birds which have been recorded in the survey */
    public int getTotalBirdCount() {
        int sum = 0;
        for (BirdSpecies b : this) {
            sum += b.getCount();
        }
        return sum;
    }

    /**
     * @return a formatted message, displaying a list of the birds spotted so far
     */
    public String getReport() {
        int speciesCount = this.getSpeciesCount();
        int totalBirds = this.getTotalBirdCount();
        StringJoiner report = new StringJoiner("\n");
        report.add(String.format("=== %d SPECIES RECORDED SO FAR (%d TOTAL BIRDS) ===", speciesCount, totalBirds));
        for (BirdSpecies b : this) {
            String species = b.getSpecies();
            int count = b.getCount();
            report.add(String.format(" * %-20s – %2d sightings", species, count));
        }
        return report.toString();
    }

    // CONSOLE METHODS

    /** Prompts the user for input, then returns a string */
    protected static String readString(String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }

    protected static String readStringNonEmpty(String prompt) {
        String input = "";
        do {
            input = readString(prompt);
        } while (input.length() == 0);
        return input;
    }

    /**
     * Add the specified bird to the survey. If that bird's species is not found in
     * the list, then ask the user whether they'd still like to add it
     * 
     * @param bird
     */
    public void inputBird(String bird) {
        BirdSpecies b = getBirdSpecies(bird);
        if (b == null) {
            System.out.printf("Species \"%s\" has not yet been sighted.\n", bird);
            boolean doContinue = readString("Add anyway? (y/N) ").matches("[Yy]");
            if (!doContinue) {
                System.out.printf("\n\"%s\" was not added. List unchanged.\n", bird);
                return;
            }
        }
        addBird(bird);
        System.out.printf("\nYou sighted a %s! (%d sightings total)\n\n", bird, getCount(bird));
    }

    /**
     * The main interactive loop for the BirdSurvey application. Repeatedly prompts
     * the user to enter birds, displaying the bird list each time.
     */
    public void inputBirds() {
        while (true) {
            System.out.println("\n" + this.getReport() + "\n");
            String input = readString("Enter species (q to exit): ");
            if (input.matches("[qQ]")) {
                break;
            }
            this.inputBird(input);
            pause();
        }
    }

    public static void pause() {
        readString("(Press enter to continue...)");
    }
}