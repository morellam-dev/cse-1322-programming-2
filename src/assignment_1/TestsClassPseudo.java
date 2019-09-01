// CLASS BEGIN
class Tests                                                         {

    // CREATE private fields for name and test scores
    private String firstName, lastName;
    private int[] scores;

    // CONSTRUCTOR: create a Tests object with a pre-defined scores array
    public Tests(String firstName, String lastName, int[] scores)   {
        this.firstName = firstName                                  ;
        this.lastName = lastName                                    ;
        this.scores = scores.clone()                                ;}
    // END CONSTRUCTOR

    // METHOD: access student's first name
    public String getFirstName()                                    {
        return this.firstName                                       ;}  
    // END METHOD

    // METHOD: access student's last name
    public String getLastName()                                     {
        return this.lastName                                        ;}
    // END METHOD

    // METHOD: Join the student's first and last name with a space
    public String getFullName()                                     {
        return this.firstName + " " + this.lastName                 ;}
    // END METHOD

    // METHOD: Return the scores[] array as a simple string
    public String getScoreList()                                    {
        String list = ""                                            ;
        // Append each score to a string
        for (int score : this.scores)                               {
            list += score + " "                                     ;}
        return list.trim()                                          ;}
    // END METHOD

    // METHOD: Average the student's test scores
    public double getAverage()                                      {
        int avg = 0                                                 ;
        // Add them all together
        for (int i = 0; i < scores.length; i++) {
            avg += scores[i]                                        ;}
        // Then divide them
        return avg / scores.length                                  ;}
    // END METHOD

    // METHOD: return the letter grade corresponding to the student's average
    public String getLetterGrade()                                  {
        double avg = getAverage()                                   ;
        if (avg < 60)                                               {
            return "F"                                              ;}
        if (60 <= avg && avg < 70)                                  {
            return "D"                                              ;}                                            
        if (70 <= avg && avg < 80)                                  {
            return "C"                                              ;}
        if (80 <= avg && avg < 90)                                  {
            return "B"                                              ;}
        if (90 <= avg)                                              {
            return "A"                                              ;}
        return ""                                                   ;}
    // END METHOD

    // METHOD: Return a string with 
    @Override
    public String toString() {
        return "NAME: " + getFullName() + ", " 
                + "SCORES: " + getScoreList() + ", " 
                + "AVG: " + getAverage() + ", " 
                + "GRADE: " + getLetterGrade(); 
    }
    public static void main(String[] args) {
        Tests example = new Tests("Firs", "Lasname", new int[]{0, 5, 1, 2, 3});
        System.out.println(example.toString());
    }
}