# CSE 1322L - Module 5A and 5B

## Coding Assignment

For the problem statements below, you must write the Pseudocode for each part of the solution. The Pseudocode must be complete and following the standards listed on the FYE website.

After completing the pseudocode, please use it to create the source code in your lab's specific language (either C# or Java). Make sure to turn in both the pseudocode and source code to Gradescope and in their appropriate drop boxes. The pseudocode will be turned into assignment 4A and the source code to 4B.

### Problem Statement

Write a program to perform a bird survey to count the number of birds of each species in an area.  Create a class BirdSurvey that is a linked list.  The linked list can be one way linked list, circular linked list or a doubly linked list; whichever you choose.

BirdSurvey should have the following operations in addition to those normally found in your linked list class:

* `add(bird)` – adds the bird species `bird` to the end of the list, if it is not already there.  sets its count to 1; otherwise, adds 1 to the count for bird.
* `getCount(bird)` – returns the count associated with the species `bird`.  If bird is not on the list, returns zero.  
* `getReport()` – displays the name and count for each bird species on the list.

You will write a program that uses BirdSurvey to record the data from a recent bird survey.  Use a loop to read bird names until done is entered.  Illustrate the use of each of the methods mentioned above, with the last being a Report of all the species of birds entered and the count for each species.  

### Start writing the code from your pseudocode

Code the solution from your pseudocode. Compile and debug all parts of your program to ensure it is correct.  

### What to Turn In

Follow submission guidelines on this page: [http://ccse.kennesaw.edu/fye/Submission%20Guidelines.php](http://ccse.kennesaw.edu/fye/Submission%20Guidelines.php)
