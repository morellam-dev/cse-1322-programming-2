# CSE1322 -- Lab 2B -- Abstract Classes and Interfaces

_This lab may contain intentional minor errors; they should be reasonably easy to find and exist so that you must think as you go through the lab.  Like many things in life, "trust but verify."  Ideas will always be correct; only minor code and syntax may be incorrect._

## Lab 2B: Abstract Classes and Interfaces

### Objectives

To write a program using classes to demonstrate how abstract classes and interfaces are implemented using code.

### Problem Statement

Write a class named Octagon that extends the abstract class GeometricObject and implements the interfaces Comparable and Cloneable. Assume that all eight sides of the octagon are of equal size. The area can be computed using the following formula: 

 `area = (2+4/sqrt(2))*side*side`

Write a test program that creates an `Octagon` object with the side value 8 and displays it's area and perimeter (to 2 decimal places). Create a new object using the `clone` method and create a method that compares the two objects (`Octagon` object and `clone` object) and returns true if all data elements are the same in both objects, false if any data object is different.

### What to Turn In

Follow submission guidelines on this page: http://ccse.kennesaw.edu/fye/Submission%20Guidelines.php

---
##### Document converted to Markdown by Max Morella
Original file: https://ccse.kennesaw.edu/fye/1322_labs_assignments.php
