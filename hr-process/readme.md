# HR Process
## Demonstration of a Chain of Responsibility Design pattern.

This use case is a hypothetical work pipeline of how an individual (TxnObject) works into an office. The first meeting would be a receptionist and from there, the files and individual will process the txn by updating the individuals txn log.
 
The code assumes that the individual passes all stages but it is possible that the individual fails a stage at which point the TemplateDesk.doSpecificFunction(TxnObject) will return false and the chain will be broken.
 
At the end of the chain or the transaction, we can see all that happened to the individual by printing the txnLog to screen
 
To avoid repetition of code across the Desk implementation, a Template Design pattern was implemented to abstract the general behaviour across the recruitment process and only provided a hook method for specific implementation to all desk.
 
Other patterns used here include
- Template Design Pattern