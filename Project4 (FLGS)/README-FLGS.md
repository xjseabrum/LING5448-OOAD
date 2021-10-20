
Team members (along with version of Java that each is using):

- Jay Seabrum (using Java JDK 16)
- Weitung Liao (using Java JDK 16)
- Dananjay Srinivas (using Open SDK 16)

## UML Diagram is here: Project4 (FLGS)/Proj4UML.png
## Output file is here: Project4 (FLGS)/Output.txt
## Code can be found in various folders here:  Project4 (FLGS)/src/com/FLGS/
## J-Unit Test output here:  Project4 (FLGS)/src/com/FLGS/Test Results.html
## J-Unit Test Code here: Project4 (FLGS)/src/com/FLGS/Test/

# Examples of Design Patterns 



### 1. Singleton Pattern
For the assignment, both Lazy and Eager instantiations of the announcer were required.  To accomplish this and to adhere to not change working code, the original Announcer class was made abstract, and two new classes, EagerAnnouncer and LazyAnnouncer were made and, thus, inherit from their abstract class.  Below is the entire code for EagerAnnouncer.java.  

```java
// Here is the Eager implementation of the Announcer Singleton
// In the code, after talking to Bruce, we only call the
// Eager version of the Announcer via a variable that can be
// set under Store.java

package com.FLGS.Store.Employees;

public class EagerAnnouncer extends Announcer{
    private static EagerAnnouncer unique =
            new EagerAnnouncer("Guy");

    private EagerAnnouncer(String announcerName) {
        super(announcerName);
    }

    public static EagerAnnouncer getInstance(){
        return unique;
    }
}

```

Now, to accomplish the other part of the assignment where it says that the type of Announcer can be changed at runtime, the following was added to Store.java:
_Note: Truncated code is represented with //[...]_
```java
public class Store implements Robbable {

    // attributes
    //[...]
    public static String announcerType = "Eager";
    //[...]
}
```

Then announcerType is called under EmployeeUtils.java:
```java
    public static Announcer spawnAnnouncer(){
        if (Store.announcerType == "Eager"){
            return EagerAnnouncer.getInstance();
        } else {
            return LazyAnnouncer.getInstance();
        }
    }
```


### 2. Command Pattern


```java
// Update later.
```


### 3. Factory Pattern
Similar to how Announcer was made an Abstract Class, so too was Customer.  This was done so that a customer class structure could be made for GenerateCustomer.java to function. 
The following is the code that we implemented to make the Factory:
```java
public class GenerateCustomer {
    List<String> types = Arrays.asList("Family", "Kid", "Card", "Board");
    protected String chosenType = "No Type Chosen";

    public Customer createCustomer(){

        int randInt = RandomUtils.getRandomInt(4);
        this.chosenType = types.get(randInt);

        return switch (chosenType) {
            case "Family" -> new FamilyCustomer();
            case "Kid" -> new KidCustomer();
            case "Card" -> new CardCustomer();
            case "Board" -> new BoardCustomer();
            default -> null;
        };

    }
}

```

Then, GenerateCustomer.createCustomer() is called under StoreUtils.java:
```java
public class StoreUtils {

    //[...]

    public static List<Customer> spawnCustomers(){

        int numCustomers = RandomUtils.poissonRandom(3);
        List<Customer> customers = new ArrayList<Customer>();

        for (int i=0; i<numCustomers; i++){
            customers.add(GenerateCustomer().createCustomer());
        }

        return customers;
    }
    
    //[...]
}

```

### 4. J-Unit Tests

```java
// Update later.
```

### Final Thoughts



