# Object Oriented Programing Course - Second Task

In this task, we implement a simple Observer design pattern over the UndoableStringBuilder class. 
The class above inherits Java's StringBuilder's functions and properties, with the addition of the 'undo' function.

## Table of Contents

- Explanation
- Installation
- Tests
- Class Diagram

### Explanation

#### UndoableStringBuilder

This class extends Java's StringBuilder class with the addition of the 'undo' function.
This means for every action made to the class' StringBuilder, we store an 'UndoData' node whose attributes are a function and variables needed to undo that action.

For example:
Given the StringBuilder that holds the String "This is a ", if we append "String" to it, we would get "This is a String".
In order to undo the appension, we store an 'UndoData' node containing DEL, and the index integers of "String" in the StringBuilder's String.

#### The Observer Design Pattern

In our project, the Observable object GroupAdmin is an implementation of the Sender interface, and the Observing object ConcreteMember is an Implementation of the Member interface. Both contain an UndoableStringBuilder object.

The GroupAdmin manages a list of registered Member objects, and it has the ability to register and unregister members.
Upon each change done to GroupAdmin's UndoableStringBuilder, the change is notified to the current Members in the list and they have their own UndoableStringBuilder updated accordingly.


### Class Diagram

The diagram below represents the hierarchy of the classes used in the project.

![Untitled](https://user-images.githubusercontent.com/117165853/209974640-5f23f133-13dc-4123-9385-9fd380fa8884.jpg)


### Installation

to run this project you will only need Java 19 or later and Junit5 and Junit4.
for the "Tests" file you will also need "maven" Framework.


### Tests

- MainTest: This class only tests the methods of the UndoableStringBuilder 
- GroupAdminTest: This tests the features of GroupAdmin like register, unregister, etc.
- ConcreteMemberTest: 
