# Exchange House

There are two versions in this project

## This is a demonstration of a Mediator Design pattern.
The case scenario is an exchange with about 3 brokers who know nothing about themselves.
The brokers only sign up to the Exchange - the mediator who then coordinates interaction between parties (brokers) that don't reference each other.
 
The Mediator can handles as many brokers that sign in and pass stocks sales and purchase among them.
 
Other patterns used here include
- Observer Design Pattern


## This is a more compound design to the one above.
This version of the exchange house has a lot more functionalities enabled by newer implementations of design patterns.
They include,
- Stocks now have a state in the Stock inventory. Their prices could be going up, down or just flat.
- Brokers no longer call the exchanges buy or sell method, instead they place an order. The execution type and implementation is represented within the command object Order.
- The calculation have been moved from the implementation of the exchange class to the state objects. The will allow for more states or order types to be added without changing existing implementations.
- Brokers don't create the command object anymore but request it from the exchange and as such they never get the actual implementation of the order they are request. It is fine that they work against interfaces so that a million changes can be transparently made to the system without affecting any existing party.

While there are drastically being more classes in this version, it is a more loosely couple and interactive version than the first.

Other patterns used here include
- Command 
- Factory
- Observer 
- Singleton
- Strategy
- State