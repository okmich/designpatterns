# Reactive IO Unit
## Implementation of the Reactor pattern
The scenario is a simple console input and output unit that receives inputs from the command line, dispatches the entry to an implementation of CommandProcessor who then sends back an output if necessary.

While the example here seems trivial, the power behind it is the ability to extends it to handle command processing as a full capable single-threaded reactive service servers without changing the structure of the framework.

This architecture can be made to become concurrent by making the CommandProcessor implementation to execute each command in a separate thread of control either by firing a new java.lang.Thread(java.lang.Runnable) for each call or using any of java concurrency executor services (a more efficient approach).

Other patterns used here include:
- Template pattern
- Command Pattern 
  