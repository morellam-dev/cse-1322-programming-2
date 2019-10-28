# CSE1322 - Java Lab 6A - Exceptions

## Lab 6A: Exceptions

### Objectives
To write a program that incorporates throwing an exception and exception handling.  The program should recover from the exception.

### Problem Statement
Write a program that converts a time from 24-hour notation to 12-hour notation.  The following is a sample interaction between the user and the program: 
```
Enter time in 24-hour notation: 13:07
That is the same as: 1:07 PM
Again? (y/n):  y

Enter time in 24-hour notation: 10:15
That is the same as 10:15 AM
Again? (y/n): y

Enter time in 24-hour notation: 10:65
There is no such time as: 10:65
Try Again 

Enter time in 24-hour notation: 16:05
That is the same as: 4:05 PM
Again? (y/n): n
Thank you – end of program.
```

Define an exception class called something like `TimeFormatException`.  If the user enters the illegal time, like `"10:65"`, or even gibberish, like "`&%*68"`, your program should throw and handle a TimeFormatException.  

### What to Turn In

Follow submission guidelines on this page: http://ccse.kennesaw.edu/fye/Submission%20Guidelines.php