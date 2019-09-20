### Max Morella
# Assignment 2A - Pseudocode

## `Vacation` class

```java
CLASS Vacation
BEGIN
    CREATE destination
    CREATE budget

    CONSTRUCTOR Vacation(param: destination, budget)
        this.destination = destination
        this.budget = budget
    END CONSTRUCTOR

    // GETTER for destination
    METHOD getDestination() 
        RETURN destination
    END METHOD

    // GETTER for budget
    METHOD getBudget() 
        RETURN budget
    END METHOD

    // Calculates the amount of leftover money in budget
    // If trip is over-budget, this value is negative.
    METHOD getSurplus()
        RETURN getBudget() - getTotalCost()
    END METHOD

    // Calculates total trip cost
    METHOD ABSTRACT getTotalCost()

    // Returns a list of attributes
    METHOD ABSTRACT toString()

END CLASS
```

## `InclusiveVacation` class
```java
CLASS InclusiveVacation EXTENDS Vacation
BEGIN
    CREATE price
    CREATE brand
    CREATE rating // 0-5 stars
    
    CONSTRUCTOR InclusiveVacation(param: destination, budget, price, brand, rating) {
            CALL super(destination, budget)
            this.price = price
            this.brand = brand
            this.rating = rating
    END CONSTRUCTOR

    // For an inclusive vacation, the total cost is simply the price
    METHOD getTotalCost()
        RETURN this.price
    END METHOD

    METHOD toString() {
        CREATE output
        output += "Destination: " + getDestination()
        output += "Brand: " + brand
        output += "Rating: " + rating + " stars"
        output += "Budget: " + getBudget()
        output += "Price: " + getTotalCost()
        output += "Surplus: " + getSurplus()
        RETURN output
    END METHOD
END CLASS
```

## `PiecemealVacation` class
```java
CLASS PiecemealVacation EXTENDS Vacation
BEGIN
    CREATE HashMap items // store items and costs as a map of key-value entries like {"Hotel": 3000.00}

    // Construct an items object
    CONSTRUCTOR PiecemealVacation(param: destination, budget, items)
        super(destination, budget)
        this.items = items
    END CONSTRUCTOR
    
    // For piecemeal vacations, the total cost is the sum of all values
    METHOD getTotalCost()
        CREATE total = 0;
        FOREACH price IN items.values
            total += price
        END FOREACH
        RETURN total;
    END METHOD

    METHOD toString()
        CREATE output
        output += "Destination: " + getDestination()
        output += "Budget: $" + getBudget()
        output += "Items:"
        FOREACH entry IN items // Create a bulleted list of items and their prices
            output += " • " + entry.key + ": $" + entry.value; 
        END FOREACH
        output += "Total Price: $" + getTotalPrice()
        output += "Surplus: " + getSurplus()

        RETURN output
    END METHOD
END CLASS
```

## `VacationsApp` class
```java
CLASS VacationsApp
BEGIN

    // Creates new InclusiveVacation
    STATIC METHOD inputInclusiveVacation()
        PRINT "Destination: "
        CREATE destination = READ STRING
        PRINT "Budget: $"
        CREATE budget = READ DOUBLE
        PRINT "Price: $" 
        CREATE price = READ DOUBLE
        PRINT "Enter brand: "
        CREATE brand = READ STRING
        PRINT "Enter rating: "
        CREATE rating = READ INT

        RETURN NEW InclusiveVacation(destination, budget, price, brand, rating)
    END METHOD

    // Creates new PiecemealVacation
    STATIC METHOD inputPiecemealVacation()
        PRINT "Destination: "
        CREATE destination = READ STRING
        PRINT "Budget: $"
        CREATE budget = READ DOUBLE
        CREATE a HashMap called items
        WHILE true
            PRINT "Item name: "
            CREATE item = READ STRING
            IF (item == "") BREAK // if the user enters nothing, stop looping

            PRINT "Price: "
            CREATE price = READ DOUBLE
            PUT {item: price} INTO items
        END WHILE

        RETURN NEW PiecemealVacation(destination, budget, items)
    END METHOD

    STATIC METHOD MAIN
        // CREATE demo Vacation objects using sample data
        // PRINT the toString()

        PRINT "Sample Inclusive Vacation:"
        CREATE exampleInclusive = NEW InclusiveVacation("Honolulu", 3000.00, 2999.99, "Delta Travel", 4)
        PRINT exampleInclusive.toString()

        PRINT "Sample Piecemeal Vacation:"
        CREATE exampleItems with example data {
            "Hotel": 500.0,
            "Airfare": 3000.0,
            "Meals": 150.0
        }
        CREATE examplePiecemeal = NEW PiecemealVacation("Italy", 3000.00, exampleItems)
        PRINT examplePiecemeal.toString()

        PRINT "User-Generated Inclusive Vacation: "
        CREATE userInclusive = this.inputInclusiveVacation()
        PRINT userInclusive.toString()

        PRINT "User-Generated Piecemeal Vacation: "
        CREATE userPiecemeal = this.inputPiecemealVacation()
        PRINT userPiecemeal.toString()
        
    END METHOD
END CLASS
```