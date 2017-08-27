# Design Patterns with Lambdas in Java 8 [![Build Status](https://travis-ci.org/manoelcampos/Design-Patterns-with-Lambdas-in-Java8.png?branch=master)](https://travis-ci.org/manoelcampos/Design-Patterns-with-Lambdas-in-Java8) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/4bedb98956b94c5d9c5754ee3214287f)](https://www.codacy.com/app/manoelcampos/Design-Patterns-with-Lambdas-in-Java8?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=manoelcampos/Design-Patterns-with-Lambdas-in-Java8&amp;utm_campaign=Badge_Grade) [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This project aims to provide implementations of different Design Patterns using Lambda expressions and functional programming in Java 8.
A Maven project with the current implemented patterns is available in the [src](src) directory.
Each pattern implementation is provided into a specific package containing an usage example.

This page provides a simplified and general purpose implementation of such patterns with an usage example,
considering that you understand how each pattern works. It is not the intent of this project to explain
the patterns. To learn about Design Patterns, you can see some references below:

- <https://en.wikipedia.org/wiki/Software_design_pattern>
- <https://sourcemaking.com/design_patterns>


The examples provided in this page just have essential comments and ommits
parts of the code that aren't essential to the implemented understanding, such as constructors,
getters and setters. To see a complete, comprehensively documented and ready-to-compile code, 
follow the link to the source code provided for each current implemented pattern.

This project was inpired and adapted from [Design Patterns In Kotlin](https://github.com/dbacinski/Design-Patterns-In-Kotlin) by [Dariusz Baciński](https://twitter.com/dbacinski).
It is work in progress and [contributions](CONTRIBUTING.md) are welcome! :smile:

# Table of Contents

* [Behavioral Patterns](#Behavioral-Patterns)
	* [Observer / Listener](#observer--listener)
	* [Strategy](src/main/java/designpatterns/strategy)
	* Command
	* State
	* Chain of Responsibility
	* Visitor
* Creational Patterns
	* Builder / Assembler
	* Factory Method
	* Singleton
	* Abstract Factory
* Structural Patterns
	* Adapter
	* Decorator
	* Facade
	* Protection Proxy


# Behavioral Patterns

## Observer / Listener
[Full source code](/src/main/java/designpatterns/listener)

```java
/**
 * The interface to be used by Observable objects to notify Observers
 * when specific events happen. 
*/
@FunctionalInterface
public interface Listener<T extends Object, U extends Object> {
    void notifyObserver(T sender, U data);
}

/**
 * Your Observable class, that you usually define with a meaningful 
 * name such as "Car", "Student" or anything else.
*/
public class MyObservable {    
    /*
    Defines two different Listeners, one for an event called "Foo" and other "Bar"
    that receives the sender Observable object and a Long value that in this case,
    represents the time the event was fired (but it could be any data and type you want).
    */
    private Listener<MyObservable, Long> onEventFooIsFired;
    private Listener<MyObservable, Long> onEventBarIsFired;
    
    public MyObservable(){
	    /*
	    Initialize the event listeners with empty lambdas to avoid NullPointerException's.		
	    */
        this.onEventFooIsFired = (observable, time) -> {};
        this.onEventBarIsFired = (observable, time) -> {};
    }
    
	/**
	 * A foo method that fires a foo event.
	*/
	public void foo(){
	    //Include your code here!
        onEventFooIsFired.notifyObserver(this, System.currentTimeMillis());
    }
    
	/**
	 * A bar method that fires a bar event.
	*/
    public void bar(){
	    //Include your code here!
        onEventBarIsFired.notifyObserver(this, System.currentTimeMillis());
    }    
}
```

### Listener Usage

```java
/**
 * Implemention of a Observer class that will be notified when 
 * some events in Observable objects happen. 
*/
public class Observer {
    public static void main(String[] args) {
        MyObservable observable1 = new MyObservable();
        
	    observable1.setOnEventFooIsFired((o, t) -> System.out.println(o + " foo method fired at time " + t));
	    observable1.setOnEventBarIsFired((o, t) -> System.out.println(o + " bar method fired at time " + t));
                
		//Call the methods that will make the Listener to notify the Observer 
        observable1.foo();
        observable1.bar();
    }
}
```
