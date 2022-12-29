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

#### Class Diagram


