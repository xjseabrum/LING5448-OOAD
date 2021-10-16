
|Change|Class/File|Description|
|---|---|---|
|Added new Cashier "Bart"|Cashier/Employee|New cashier Bart is instance of Cashier.|
|Added new Employee subclass Announcer |Announcer/Employee|New Announcer is a subscriber in the pub-sub model. All employees are default publishers (can still be overriden tho.)|
|Moved spawnCashier from Store to EmployeeUtils|EmployeeUtils |Refactoring for neatness. Partial strategy pattern?|
|Deprecated TimeLine|TimeLine|Don't plan to use TimeLine, so it has been moved to Deprecated package.|
|Added new Employee subclass Baker|Baker/Employee|New Baker will deliver cookies based on presence of cookies in the cookie jar. Will publish actions to subscriber (Announcer)|    
|(TO IMPLEMENT) Customers now spawn based on the Poisson distribution|StoreUtils|Customers will now spawn based on Poisson distribution.|
|Modified Customer to allow Cookie Monster, preferential buying |Customer|The Cookie Monster is a status on the customer. If true, it will terrorize. If false it will try to purcahse cookies, then games.|
||||