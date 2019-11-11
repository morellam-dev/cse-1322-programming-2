# Module 4A and 4B

## Coding Assignment

For the problem statements below, you must write the Pseudocode for each part of the solution. The Pseudocode must be complete and following the standards listed on the FYE website.

After completing the pseudocode, please use it to create the source code in your lab's specific language (either C# or Java). Make sure to turn in both the pseudocode and source code to Gradescope and in their appropriate drop boxes. The pseudocode will be turned into assignment 4A and the source code to 4B.

### Problem 1: Order matters

For this question, you're going to write two recursive functions, both of which take in **only** a single string as a parameter; you will not receive credit if you pass in an integer as well. Note: you will need to understand substrings to get the correct solution. The first function should simply print out the string, but do so letter by letter -- and recursively.  The second function should print out the string in reverse; the code is almost identical, but the concept is different. Hint, note the title of the problem.

Example Output:

```text
Hello world!
!dlrow olleH
```

### Problem 2: Summing up sums

For this question, you'll understand the importance of using the results of smaller sets of work. You're going to create a recursive function that takes in an array of random integers and returns a "sum of sums". This is best explained through an example. If you have 5 elements in an array, the function should return the sum of elements 0–4, 1–4, 2–4, 3–4, and 4.  So, if we had an array of:

```text
{ 5, 18, 4, 7, 11 }
```

The sum of sums would be (45 + 40 + 22 + 18 + 11) = 136. Hint: is the sum of sums not just the sum of the current array + the sum of sums of an array? Think about that and if you get stuck, reach out to your GTA/professor!

Example Output using `{5, 18, 4, 7, 11}`:

```text
136
```

Example Output using `{50, 19, 1, -49, 3, 99, 3, 21, 63}`:

```text
1260
```

### What to Turn In

Follow submission guidelines on this page: [http://ccse.kennesaw.edu/fye/Submission%20Guidelines.php](http://ccse.kennesaw.edu/fye/Submission%20Guidelines.php)
