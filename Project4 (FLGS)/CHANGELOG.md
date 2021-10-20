
|Change|Class/File|Description|
|---|---|---|
|Made Customer.java and Announcer.java Abstract Classes|Customer.java, Announcer.java|A class structure is needed for both. One allows a customer factory to function while the other allows different types of Singleton instantiations.|
|Added new Utils called BiasUtils|BiasUtils|This helps assign the correct probability biases to customers based on their type.|
|Created EagerAnnouncer and LazyAnnouncer|EagerAnnouncer, LazyAnnouncer|These are Singletons derived from their abstract class Announcer.java|
|Created KidCustomer, BoardCustomer, FamilyCustomer, CardCustomer|KidCustomer, BoardCustomer, FamilyCustomer, CardCustomer|This structure was made so that customer factory could be realized.|
|Created Robbable Interface|Robbable.java|Allows Store.java to be robbed based on a 1/30 chance.|    
|Created Command Pattern Structure|Command.java, Introduce.java, Explain.java, Demonstrate.java, Recommend.java|Command Pattern structure.|
|Added the Demonstrator|Demonstrator.java|The Demonstrator takes in the commands and does what it needs to in relation to what was requested.|
||||
