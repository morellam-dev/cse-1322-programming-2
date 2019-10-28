package module_5.assignment_5;

import java.util.Objects;

/**
 * BirdSpecies, containing a species and a count
 */
public class BirdSpecies {
    private final String species;
    private int count;

    public BirdSpecies(String species, int count) {
        this.species = species;
        this.count = count;
    }

    public String getSpecies() {
        return this.species;
    }


    public int getCount() {
        return this.count;
    }

    public void setCount(int newCount) {
        count = newCount;
    }

    public void addCount() {
        count += 1;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BirdSpecies)) {
            return false;
        }
        BirdSpecies BirdSpecies = (BirdSpecies) o;
        return Objects.equals(species, BirdSpecies.species) && count == BirdSpecies.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, count);
    }

    @Override
    public String toString() {
        return "{" +
            " species='" + getSpecies() + "'" +
            ", count='" + getCount() + "'" +
            "}";
    }
    
    
}