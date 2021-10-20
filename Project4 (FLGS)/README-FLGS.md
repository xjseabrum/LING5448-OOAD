
Team members (along with version of Java that each is using):

- Jay Seabrum (using Java JDK 16)
- Weitung Liao (using Java JDK 16)
- Dananjay Srinivas (using Open SDK 16)

## UML Diagram is here: Project4 (FLGS)/Proj4UML.png
## Output file is here: Project4 (FLGS)/Output.txt
## Code can be found in various folders here:  Project4 (FLGS)/src/com/FLGS/
## J-Unit Test output here:  Project4 (FLGS)/src/com/FLGS/Test Results.html ; pdf version of this is also available in the same directory.
## J-Unit Test Code here: Project4 (FLGS)/src/com/FLGS/Test/

# Requirements Met:
### 1. Store being robbed
From the Output file, on Day 14, the store is robbed:
```text
--------------------------------------------------------------------------------
Guy says: Guy has arrived on Day 14.
Guy says: Looks like the store got robbed last night! The Insurance Company has sent their agent.
Guy says: We lost: 18 game(s), $2668.28 from the cash register, and 70 cookie(s).
Guy says: The store will remain closed while the insurance settles the claim.
Guy says: The Insurance Company states that they will restore $1000, all of the cookies, and some of the stolen games.
Guy says: Guy has left for the day.
--------------------------------------------------------------------------------
```

### 2. Common naming method
This has been in our code since Part 1 of the FLGS project. All customers and the demonstrator get a randomly generated name.  The code is reproduced below and is from RandomUtils.java:

```java
 public static String getRandomName() {
        Random rand = new Random();

        int nameLength = rand.nextInt(6) + 3;

        // References
        // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java

        char[] charsCons = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z'};
        char[] charsVowel = {'a', 'e', 'i', 'o', 'u'};

        StringBuilder name = new StringBuilder();

        while (name.length() < nameLength) {
            int r = rand.nextInt(charsCons.length);
            int s = rand.nextInt(charsVowel.length);
            char cons = charsCons[r];
            char vow = charsVowel[s];

            if (name.length() % 2 == 0) {
                name.append(cons);
            } else {
                name.append(vow);
            }
        }

        // Get the letters of the name, excluding the first letter
        // which has to be converted to uppercase
        String withoutFirst = name.substring(1);

        // Output the name where the first character is uppercase and
        // the rest is preserved.
        String nameOut = Character.toUpperCase(name.charAt(0)) + withoutFirst;
        return nameOut;
    }

```
And from Output.txt, on Day 1 (and every day in the sumulation), we can see the Demonstrator with a name and the Customers with names:
_Note: truncated parts of the output are represented with //[...]_
```text
//[...]
Guy says: Cashier Ernie reports: 3 customer(s) visited the store today.
Guy says: Demonstrator Qayiaebo arrived.
Guy says: Qayiaebo the Demonstrator demonstrated Risk to Card Gamer Haralu.
Guy says: Cashier Ernie reports: Card Gamer Haralu is inspecting the shelves.
Guy says: Cashier Ernie reports: Card Gamer Haralu is trying to buy cookies.
Guy says: Cashier Ernie reports: Card Gamer Haralu bought 2 cookie(s).
Guy says: Cashier Ernie reports: Card Gamer Haralu selected Pokemon.
Guy says: Haralu bought Pokemon for $10.00.
Guy says: Cashier Ernie reports: Card Gamer Haralu selected Candyland.
Guy says: Haralu bought Candyland for $24.40.
Guy says: Cashier Ernie reports: Card Gamer Haralu selected Life.
Guy says: Haralu bought Life for $20.00.
Guy says: Cashier Ernie reports: Card Gamer Haralu bought 3 game(s) in all.
Guy says: Qayiaebo the Demonstrator demonstrated Catan to Card Gamer Haralu.
Guy says: Qayiaebo the Demonstrator demonstrated Clue to Board Gamer Fopamok.
Guy says: Cashier Ernie reports: Board Gamer Fopamok is inspecting the shelves.
//[...]

```

### 3. Customer Factory 
_See the section below where we talk about the Factory Pattern._

### 4. Singleton Announcer
_See the section below where we talk about the Singleton Pattern._

### 5. Demonstrator
For the most part, see the section below where we talk about the Command Pattern.
However, from the Output, we can at least show that the demonstrator does commands (ex: Day 2):

```text
Guy says: Qayiaebo the Demonstrator demonstrated Risk to Board Gamer Fuyil.
Guy says: Qayiaebo the Demonstrator explained Pokemon to Board Gamer Fuyil.
Guy says: Qayiaebo the Demonstrator recommended Clue to Kid Gamer Suuah.
```

And that the demonstrator flees (and a new one spawns) when the cookie monster visits (ex: Day 3):

_Note: The double asterisks are added here in the README for emphasis_
```text
Guy says: Cashier Ernie reports: 4 customer(s) visited the store today.
Guy says: Demonstrator **Qayiaebo** arrived.
Guy says: **Qayiaebo** shrieks: Ahhhhhhh~~~~! *flees the premises, arms aflailing*
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie Monster has arrived to terrorize!
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie Monster has eaten all the cookies!
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie Monster wants to damage 4 game(s)!
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie monster damaged an in-stock copy of Pokemon.
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie monster damaged an in-stock copy of Connect Four.
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie monster damaged an in-stock copy of Magic.
Guy says: 		COOKIE MONSTER ALERT!!! 
	Cashier Ernie reports: Cookie monster damaged an in-stock copy of Mousetrap.
Guy says: **Uuaayim** the Demonstrator recommended Life to Board Gamer Aouanoh.

```

### 6. J-Unit Tests
The following is the entire code for SoldTest.java under src/com/FLGS/Test/.  Other test code can be found in the directory. 

```java
package com.FLGS.Test;

import com.FLGS.Actions.HighestFirstStack;
import com.FLGS.Actions.Sold;
import com.FLGS.Games.Clue;
import com.FLGS.Games.Games;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.Employees.Announcer;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Employees.CashierTask;
import com.FLGS.Store.Employees.EagerAnnouncer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldTest {

    @Test
    void doAction() {
        HighestFirstStack stack = new HighestFirstStack();
        Cashier cashier= new Cashier( "testCashier", 3, stack);
        cashier.setSubscriber(EagerAnnouncer.getInstance());
        Sold obj = new Sold(cashier);
        CashRegister register=new CashRegister();
        Clue game=new Clue();
        game.inventory=3;
        double originalCash=register.cash;

        obj.doAction(game,"testCustomer",register);

        //assert game inventory decremented
        assertEquals(2,game.inventory);
        //assert cash add to the cash register
        assertEquals(originalCash+game.price,register.cash);
    }
}
```

And below is the confirmation output for the aforementioned code:
![image](https://user-images.githubusercontent.com/77007903/138156968-d27ebb43-c509-4d84-8bcb-7ae2a6a062dc.png)

Finally, the following shows that all 15 of our tests did pass (open the html file for a full breakdown):
![image](https://user-images.githubusercontent.com/77007903/138157059-fcdcc083-0928-4ba4-a1b2-b8280a18fe7e.png)


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
