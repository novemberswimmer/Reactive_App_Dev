# Guidebook App

### 2.7 Adding group router
* Added a new version of TouristMain (TouristMain_2_7) that uses group router
* Unlike Router actor created on 2.6 the router created and manage the routees, in this 
example of group router the routees are created separately
* Routees in this example are remote Actors (guidebook actor) running on different port
* To create the routees run 3 instances of GuibookMain all with different akka.remote.netty.tcp.port
```java
-Dakka.remote.netty.tcp.port=2553
-Dakka.remote.netty.tcp.port=2554
-Dakka.remote.netty.tcp.port=2555
```

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
