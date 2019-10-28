package module_5.assignment_5;

import java.util.Scanner;

/**
 * BirdSurveyList
 */
public class BirdSurvey extends MyLinkedList<BirdSpecies> {
    private static final long serialVersionUID = 4838685580168749376L;
    private static final Scanner console = new Scanner(System.in);

    /** 
     * Search the list for a BirdSpecies object which matches the given species. 
     * @return A matching BirdSpecies object, or {@code null} if no such bird exists.
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

    public void addBirds(String ...birds) {
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
    /** @return The total number of birds which have been recorded in the survey */
    public int getTotalBirdCount() {
        int sum = 0;
        for (BirdSpecies b : this) {
            sum += b.getCount();
        }
        return sum;
    }
    /** @return a formatted message, displaying a list of the birds spotted so far  */
    public String getReport() {
        String output = "";
        System.out.printf("=== %d SPECIES SIGHTED SO FAR (%d TOTAL BIRDS) ===\n", this.getSpeciesCount(), this.getTotalBirdCount());
        for (BirdSpecies b : this) {
            output += String.format(" * %s – %d sightings\n", b.getSpecies(), b.getCount());
        }
        return output;
    }

    // CONSOLE METHODS

    /** Prompts the user for input, then returns a string */
    protected static String readString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = console.nextLine();
            if (input.length() > 0) {
                return input;
            }
        }
    }

    /**
     * Add the specified bird to the survey. If that bird's species is not found in
     * the list, then ask the user whether they'd still like to add it
     * 
     * @param bird
     */
    public void inputBird(String bird) {
        if (getCount(bird) == 0) {
            System.out.printf("Species \"%s\" has not yet been sighted.\n", bird);
            boolean doContinue = !(readString("Add anyway? (y/N)").matches("[nN]"));
            if (!doContinue) {
                System.out.printf("\"%s\" was not added\n", bird);
                return;
            }
        }
        addBird(bird);
        System.out.printf("You sighted a %s! (%d sightings total)\n", bird, getCount(bird));
    }

    public void inputBirds() {
        while (true) {
            System.out.println(this.getReport());
            System.out.println();
            String input = readString("Enter species (q to exit): ");
            if (input.matches("[qQ]")) {
                break;
            }
            this.inputBird(input);
            System.out.println();
        }
    }
}