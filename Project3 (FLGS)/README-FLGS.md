
Team members (along with version of Java that each is using):

- Jay Seabrum (using Java JDK 16)
- Weitung Liao (using Java JDK 16)
- Dananjay Srinivas (using com.FLGS.Actions.Open SDK 16)

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



