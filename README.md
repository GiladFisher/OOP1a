# Object Oriented Programing Course - Second Task
In this task, we implement a simple Observer design pattern over the UndoableStringBuilder class. 
The class above inherits Java's StringBuilder's functions and properties, with the addition of the 'undo' function.

## Table of Contents
- Introduction
- Installation
- Tests
- Class Diagram

### Introduction

The Observable object, GroupAdmin, is an implementation of the Sender interface that was provided by the course staff and contains an UndoableStringBuilder object. 
GroupAdmin manages a list of registered "Member" objects, which also hold an UndoableStringBuilder variable. Upon each change done to GroupAdmin's UndoableStringBuilder, the change is notified to the current Members and they have their own UndoableStringBuilder compatibly changed.


### Installation

to run this project you will only need Java 19 or later and Junit5 and Junit4.
for the "Tests" file you will also need "maven" Framework.


### Tests

- MainTest: This class only tests the methods of the UndoableStringBuilder 
- GroupAdminTest: This tests the features of GroupAdmin like register, unregister, etc.
- ConcreteMemberTest: 


### Class Diagram

![Observer](https://user-images.githubusercontent.com/117165853/209974285-29c62042-3093-4d20-8af6-9e8d61b20529.jpg)


