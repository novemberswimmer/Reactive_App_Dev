# Guidebook App


### 2.6 Creating pool of actors
* Update GuidebookMain to make use of AKKA Router and create multiple instances of Guidebook Actor
* Demonstrate how to scaling with multiple actor
* In this version Router is created through configuration instead of programmatically 
* *Check the logs of Guidbook Main notice the actor name is like $a,$b,etc*

### 2.4
* Guidebook was broken down to two runnable application each
having its own Actor System
* The Tourist Actor is making a remote actor reference to Guidbook Actor

### 2.3
* Initial version of Guidebook application with a single Actor System in one JVM
