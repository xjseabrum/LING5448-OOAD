
Team members (along with version of Java that each is using):

- Jay Seabrum (using Java JDK 16)
- Weitung Liao (using Java JDK 16)
- Dananjay Srinivas (using com.FLGS.Actions.Open SDK 16

## UML Diagram is here: Project3 (FLGS)/Proj3UML.png
## Output file is here: Project 3 (FLGS)/Output.txt
## Code can be found in various folders here:  Project 3 (FLGS)/src/com/FLGS/

# Examples of Design Patterns 



### 1. Publisher-Subscriber (Observer) Pattern

Employees are publishers, they publish their message to the Announcer (subscriber) - who then logs the message to an output file. 

We have implemented this pattern using 2 interfaces : 

1. Com.FLGS.Interfaces.Publisher
2. Com.FLGS.Interfaces.Subscriber



##### Publisher Interface : 

```java
public interface Publisher{
  
  void publish(String message); // message that needs to be published to the announcer
  
  String getSubscriber(); // returns the subscriber's name (not implemented)
  
  void setSubscriber(Announcer announcer); // the publisher has a reference to the subscriber they need to publish to. By default - it is null. 
  
}
```



##### Subscriber Interface : 



```java
public interface Subscriber{
  
  void addPublisher(Employee employee); // adds a publisher reference to the subscriber

  void removePublisher(Employee employee); // removes one given publisher from the subscriber

  void removeAllPublishers(); // removes all the publishers in the subscribers

  void publish(String message); // this publish message will write to the output file
  
}
```



*Please note: currently, we are not actively calling methods* `addPublisher()`, `removePublisher()` and `removeAllPublisher()` *becuase there is no requirement for the subscriber to have a reference to the publisher. The same is the case with* `getSubscriber()` - *there is no requirement to find the subscriber of a given publisher (always Guy)*

### 2. Decorator Pattern
Decorators (CustomMinis, SpecialTokenPack, SpecialCards, SpareParts) inherit from their abstract class (SpecialAdd) which inherits from the base abstrat class Games.  These decorators are assigned to their appropriate game or game type via delegating to a helper class (described below under Strategy).  Below is the code for CustomMinis which shows that it takes in a Games object and outputs different things depending on the getter:

```java
public class CustomMinis extends SpecialAdd {
    private int minRoll = 1;
    private int maxRoll = 4;
    public String desc = "";
    private int numBuy;
    private double addCost;
    public double totCost;

    public CustomMinis(Games g){
        super(g);
        this.price = 49.98;
    }

    public String getDesc(){
        desc = "They also bought " + this.getNumBuy() + " custom mini(s) for $" +
                String.format("%.2f", this.getAddCost()) +
                " for a grand total of $" + String.format("%.2f", this.getPrice())
                + ".";
        return desc;
    }

    public int getNumBuy(){
        this.numBuy = super.getRandRoll(minRoll, maxRoll);
        return numBuy;
    }

    public double getAddCost(){
        this.addCost = this.numBuy * this.price;
        return addCost;
    }

    public double getPrice(){
        this.totCost = (g.getPrice() + this.addCost);
        return totCost;
    }
}

```



### 3. Strategy

A set of Cashier behaviors is turned into sets of objects. So, the behaviors of cashierTask is interchangeable. For example, the stack method can be changed with HighestFirst or WidestFirst.

```java
public class CashierTask {
    Arrive arrive;
    Close close;
    Count count;
    Open open;
    Order order;
    Stack stack;
    Vacuum vacuum;
    Sold sold;
    Cashier cashier;

    public CashierTask(Stack stack, Cashier cashier) {
        this.cashier = cashier;
        this.arrive = new Arrive(this.cashier);
        this.close = new Close(this.cashier);
        this.count = new Count(this.cashier);
        this.open = new Open(this.cashier);
        this.stack = stack;
        this.vacuum = new Vacuum(this.cashier);
        this.order = new Order(this.cashier);
        this.sold = new Sold(this.cashier);

    }
    public void arrive(int arriveDay, Wares ware){
        arrive.announce(arriveDay);
        arrive.doAction(ware);
    }
    public void count(CashRegister register){
        count.announce(register);
        count.doAction(register);
    }
    public void close(){
        close.announce();
        close.doAction();
    }
    public void open(){
        open.announce();
        open.doAction();
    }
    public void order(Wares ware,CashRegister register){
        order.announce();
        order.doAction(ware,register);
    }
    public void stack(Wares ware,String employeeName){
        stack.announce(this.cashier);
        stack.doAction(ware);
        stack.announceStackOrder(ware,employeeName,this.cashier);
    }
    public void vacuum(Wares ware,int damageRate){
        vacuum.announce();
        vacuum.doAction(damageRate,ware);
    }
    public void sold(Games gameSold, String customerName, CashRegister cashRegister){
        sold.doAction(gameSold,customerName,cashRegister);
    }
```


```java
public class HighestFirstStack extends Stack{

    public void doAction(Wares ware) {
        // reference https://stackoverflow.com/questions/33487063/java-8-sort-list-of-objects-by-attribute-without-custom-comparator
        List<Games> stack = ware.getGames();
        if(stack != null && !stack.isEmpty()) {
            stack.sort(Comparator.comparing(a -> a.getBoxHeight()));
            }
        }
    }
```


```java
public class WidestFirstStack extends Stack{

    public void doAction(Wares ware) {

        //reference https://stackoverflow.com/questions/33487063/java-8-sort-list-of-objects-by-attribute-without-custom-comparator
        List<Games> stack = ware.getGames();
        if( stack!=null && !stack.isEmpty()) {
            stack.sort(Comparator.comparing(a -> a.getBoxWidth()));
            Collections.reverse(stack);

        }

    }
}
```


The following helper class (Deco) helps to assign the correct decorator given the game that is inputted.  This is just one of the ways Strategy is used in the project (the other main examples can be found in: RandomUtils, StoreUtils, EmployeeUtils, PublishUtils).  Coincidentally, Deco is also a Simple Factory.
```java

public class Deco {
    public String special = "";

    public Deco() {
    }

    public String decorate(Games g, CashRegister r) {

        if (Objects.equals(g.gameName, "Monopoly")) {
            Games g2 = g;
            g2 = new SpecialTokenPack(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else if (Objects.equals(g.gameType, "Card Game")) {
            Games g2 = g;
            g2 = new SpecialCards(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else if (Objects.equals(g.gameName, "Mousetrap")) {
            Games g2 = g;
            g2 = new SpareParts(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else if (Objects.equals(g.gameName, "Gloomhaven")) {
            Games g2 = g;
            g2 = new CustomMinis(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else {
            this.special = "";
            r.addCash(0);
            return special;
        }
    }
}
```

Now, where is Deco called so that Strategy may be used?  It is called here, under the buyGames() method in Customer.java:
_(Note: code is truncated here just to show the main point.  Truncated code is represented with //[...])_
```java
private void buyGames(List<Games> inInventory, Cashier cashier){
        Deco deco = new Deco();
        for (int i = 0; i<inInventory.size(); i++){
            //[...]
                    // Here, delegation to deco occurs.
                    // allowing it to assign the correct decorator
                    // to the game that the customer buys.
                    cashier.publish(deco.decorate(inInventory.get(i), Main.register));
            //[...]
    }
```

# Previous considerations
This was a conservative bet on what can be delivered in the 8 days that we actually worked on this project (the rest was divided between design and Project 1 submission). 

Here are the salient points that we hope to address in the coming submissions - 

- Removing Timeline, changing it into a util that reports to com.FLGS.Store.Store object. 
- Removing util functions inside com.FLGS.Store.Store and placing it in a delegated class : StoreUtils.
- Reduce some coupling between com.FLGS.Store.Employees.Cashier/Main and CashierTasks.
- com.FLGS.Store.Store should have fewer method definitions and more method calls (*jury is out on this one*)
- com.FLGS.Store.Store should own com.FLGS.Store.Wares and com.FLGS.Store.CashRegister (*jury is out on this one* - *there are good reasons to keep them separate in our opinion.*)



# Current Considerations 

### Addressing Previous Considerations : 

- *Removing Timeline, changing it into a util that reports to com.FLGS.Store.Store object* : Timeline is deprecated and has been moved to the Deprecated package.  
- *Removing util functions inside com.FLGS.Store.Store and placing it in a delegated class* : StoreUtils has been implemented, and is used to spawn Customers and CookieMonster.
- *Reduce some coupling between com.FLGS.Store.Employees.Cashier/Main and CashierTasks.* : Subclasses of CashierTasks now don’t require a reference to Main or Wares. However, Cashier is composed of CashierTasks, so it is natural to keep a reference to the Cashier a particular instance of CashierTask belongs to. Now CashierTask methods can accept arbitrary objects of a given class versus requiring a direct reference to the main. 
- *com.FLGS.Store.Store should have fewer method definitions and more method calls* : Specific helper classes like StoreUtils, PublishUtils have been created to increase cohesiveness of Store. Since Store is an encompassing class, there is still cruft that can be removed. 
- *com.FLGS.Store.Store should own com.FLGS.Store.Wares and com.FLGS.Store.CashRegister* : We have opted to keep the current structure. The arguements for Store to own Wares/CashRegister is that every Store has a Wares/CashRegister (Probably). However, the argument for keeping them separate is each class is a collection of similar items; Store-Employees/Visitors, Wares-Things that can be sold, CashRegister - Things to hold money, etc. We expect that in the coming weeks there will be a franchisee of stores and cash/wares may need to move from one object to another - this is our preparation. 

### Considerations for this sprint : 

- The biggest consideration was refactoring/restructuring code to make it more readable. Where there was no code organization, you will now find packages containing similar classes. 
- Implementing the design patterns that were a requirement - 
  - Game Objects can now be decorated with extras, using the Decorator pattern. 
  - All employees implement a publisher interface, with the exception of the Announcer who implements a subscriber interface. 
  - Stack has been tweaked to be a stand alone Strategy Pattern, however - we had a similar design from the previous sprint. 
- Implementing the CookieJar (to represent the collection of cookies) and CookieMonster classes 
- CookieMonster and Customers are both “StoreVisitors”, grouping them in the same package and implementing an interface called “StoreVisitor” with a sole method called VisitStore. 
- A lot of logging changes, all of the sys-outs needed to be changed. Now employees publish what they witness/do to Guy the announcer. 
- Some basic CRs - change the random process of customer arrival, increase/decrease customer buying chance, etc. 

### Coming sprint changes : 

- We are planning to make the Announcer a singleton. 
- We may deprecate the shelf class, as only a list representation is required to operate.
- Refactor to make it more neater (possibly by removing some repeated code/redundancies). 



