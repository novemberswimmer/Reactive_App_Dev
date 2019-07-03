package org.november.learning.akka.guidebook

import akka.actor.ActorSystem

/**
  * When running this main class make sure you include -Dakka.remote.tcp.netty.tcp.port=2553
  */
object GuidebookMain extends App{
  //Names the actor system uniquely
  val system = ActorSystem("BookSystem")

  //Names the actor uniquely
  //Produces an ActorRef the same as in the single JVM example
  val guidebook = system.actorOf(Guidebook.props,"guidebook")
}
