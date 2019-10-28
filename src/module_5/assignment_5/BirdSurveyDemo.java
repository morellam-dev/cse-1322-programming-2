package module_5.assignment_5;

/**
 * BirdSurveyDemo
 */
public class BirdSurveyDemo {
    public static void main(String[] args) {
        BirdSurvey demoOne = new BirdSurvey();
        // Add example species for demo purposes
        demoOne.add(new BirdSpecies("wood duck", 0));
        demoOne.add(new BirdSpecies("brown thrasher", 0));
        demoOne.add(new BirdSpecies("barn owl", 0));
        demoOne.add(new BirdSpecies("woodpecker", 0));
        demoOne.add(new BirdSpecies("goldfinch", 0));
        demoOne.inputBirds();
    }
}