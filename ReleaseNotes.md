# Guidebook App


### 2.6 Creating pool of actors
-[x] Update GuidebookMain to make use of AKKA Router and create multiple instances of Guidebook Actor
-[x] Demonstrate how to scaling with multiple actor
-[x] In this version Router is created through configuration instead of programmatically 
-[x] *Check the logs of Guidbook Main notice the actor name is like $a,$b,etc*

### 2.4
-[x] Guidebook was broken down to two runnable application each
having its own Actor System
-[x] The Tourist Actor is making a remote actor reference to Guidbook Actor

### 2.3
-[x] Initial version of Guidebook application with a single Actor System in one JVM
