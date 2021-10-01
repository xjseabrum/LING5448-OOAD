
Team members (along with version of Java that each is using):

- Jay Seabrum (using Java JDK 16)
- Weitung Liao (using Java JDK 16)
- Dananjay Srinivas (using Open SDK 16)


#### ToDo

Implement 0-2 games that a customer can buy (currently they either buy 0 or 1)
Implement Shelves obj
Implement game/cookie multiplier via decorator
Implement new Stacking method
Implement new Cashier Bart
Implement new Employee class: announcer - Guy
Implement Cookie Monster event (1%)
Implement cookie delivery event: maker - Gonger
Customers can buy 
Cookie obj as decorator (?)
CookieJar object. 
  CookieJar multiple.  CookieJar Count. CookieType.
Customer arrive with a poisson dist.
Order cookies if hit 0. (Read p3 assign.)
StoreUtils, RandomUtils.



# Previous considerations
This was a conservative bet on what can be delivered in the 8 days that we actually worked on this project (the rest was divided between design and Project 1 submission). 



Here are the salient points that we hope to address in the coming submissions - 

- Removing Timeline, changing it into a util that reports to Store object. 
- Removing util functions inside Store and placing it in a delegated class : StoreUtils.
- Reduce some coupling between Cashier/Main and CashierTasks.
- Store should have fewer method definitions and more method calls (*jury is out on this one*)
- Store should own Wares and CashRegister (*jury is out on this one* - *there are good reasons to keep them separate in our opinion.*)

