
Team members (along with version of Java that each is using):

- Jay Seabrum (using Java JDK 16)
- Weitung Liao (using Java JDK 16)
- Dananjay Srinivas (using Open SDK 16)

# *All files that should be graded are stored in Project2 (FLGS)/src. Output.txt is also in /src.
## *The UML file is located here: Project2 (FLGS)/OOAD Project2 UML.jpg

**You will actually find the specific comments regarding these concepts on the top of the file. This is a general index 
we made for your convenience.**


Examples of Inheritance - 



| Class   | Explanation                           | File         |
| ------- | ------------------------------------- | ------------ |
| Cashier | Cashier Inherits from class Employee. | Cashier.java |
|         |                                       |              |
|         |                                       |              |

Examples of Cohesion - 

| Class                      | Explanation                                                  | File                           |
| -------------------------- | ------------------------------------------------------------ | ------------------------------ |
| CashierTasks/EmployeeTasks | We did not want to have Cashier/Employee class implement all the actions, as it would have too much responsibilities. We created a separate class called CashierTasks, that handles all the actions made by the Cashier/Employee. At the moment Employee is an abstract class . | Cashier.java/CashierTasks.java |
|                            |                                                              |                                |
|                            |                                                              |                                |



Examples of Identity - 



| Class                      | Explanation                                                  | File                                                  |
| -------------------------- | ------------------------------------------------------------ | ----------------------------------------------------- |
| Customer/CashierTasks/Sold | When a Customer selects a game, that game object is passed to Cashier - who delegates it to CashierTasks, who passes the identity of the Game to “Sold”, which then modifies the attributes of the game. | Customer. buyGame(),  Cashier.tasks.sold(), Sold.java |
|                            |                                                              |                                                       |
|                            |                                                              |                                                       |

Examples of Encapsulation - *In general, we have employed getters-setters, so that is a case of encapsulation. This is under the philosophy - encapsulate what varies.*



| Class | Explanation                                                  | File       |
| ----- | ------------------------------------------------------------ | ---------- |
| Store | Everyday, a store performs 4 operations - “DailyRollCall, DailyMaintainence, DailyBusiness, DailyPunchOut”. These functions are private because they need not be accessed by other classes. | Store.java |
|       |                                                              |            |

Examples of Abstraction - 



| Class | Explanation | File |
| ----- | ----------- | ---- |
| Games | The superclass to the Games' subclasses.  It provides the framework by which all Games subclasses have to abide by and use. | Games.java |
| Action | This is a classic example of Abstraction, as an interface is guaranteed and the user can just call methods from class that implement Action.interface and not worry about what is under the hood. | Action.java<br />(Interface) |



Examples of Polymorphism - 



| Class | Explanation | File |
| ----- | ----------- | ---- |
| KidsGame/BoardGame/CardGame/FamilyGame | These are all subclasses to the main superclass Games.java.  Because all the same methods can be used across all the subclasses, polymorphism is maintained. | KidsGame.java, BoardGame.java, CardGame.java, FamilyGame.java |
|       |             |      |
|       |             |      |



#### Roadmap

This was a conservative bet on what can be delivered in the 8 days that we actually worked on this project (the rest was divided between design and Project 1 submission). 



Here are the salient points that we hope to address in the coming submissions - 

- Removing Timeline, changing it into a util that reports to Store object. 
- Removing util functions inside Store and placing it in a delegated class : StoreUtils.
- Reduce some coupling between Cashier/Main and CashierTasks.
- Store should have fewer method definitions and more method calls (*jury is out on this one*)
- Store should own Wares and CashRegister (*jury is out on this one* - *there are good reasons to keep them separate in our opinion.*)

