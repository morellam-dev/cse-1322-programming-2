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

    // Calculates the amount of leftover in budget
    // If trip is over-budget, this value is negative.
    METHOD getSurplus()
        RETURN getBudget() - getTotalCost()
    END METHOD

    // Calculates total trip cost
    METHOD ABSTRACT getTotalCost()

    METHOD ABSTRACT toString()

END CLASS
```

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

```java
CLASS PiecemealVacation EXTENDS Vacation
BEGIN
    CREATE HashMap<String, Double> items // store items as a key value pair

    CONSTRUCTOR PiecemealVacation(param: destination, budget, items)
            super(destination, budget)
            this.items = items
    END CONSTRUCTOR
`
    METHOD getTotalCost()
        CREATE total = 0;
        FOREACH price IN items.values()
            total += price
        END FOREACH
        RETURN total;
    END METHOD

    METHOD toString()
        CREATE output
        output += "Destination: " + getDestination()
        output += "Budget: $" + getBudget()
        output += "Items:"
        FOREACH entry<key, value> IN items // a list of Map.Entry<String, Double> objects
            output += " • " + key + ": $" + value; 
        END FOREACH
        output += "Total Price: $" + getTotalPrice()
        output += "Surplus: " + getSurplus()

        RETURN output
    END METHOD
END CLASS
```

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
        CREATE HashMap<String, Double> items
        WHILE true
            PRINT "Item name: "
            CREATE item = READ STRING
            IF (item == "") BREAK // if the user enters nothing, stop looping

            PRINT "Price: "
            CREATE price = READ DOUBLE
            items.put(item, price); // Add {key: value} to the Map
        END WHILE

        RETURN NEW PiecemealVacation(destination, budget, price, brand, rating)
    END METHOD

    STATIC METHOD MAIN
        // CREATE demo Vacation objects using sample data
        // PRINT the toString()
    END METHOD

END CLASS
```