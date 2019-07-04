package org.november.learning.akka.guidebook

import akka.actor.{ActorRef, ActorSystem, Props}
//library to read the pool configuration from application.conf
import akka.routing.FromConfig

/**
  * When running this main class make sure you include -Dakka.remote.tcp.netty.tcp.port=2553
  */
object GuidebookMain extends App{
  //Names the actor system uniquely
  val system = ActorSystem("BookSystem")


  //Remove in lieu of using Router to create multiple instance of Guidebook Actor
  //val guidebook = system.actorOf(Guidebook.props,"guidebook")

  //Wraps the pool configuration around the original Props for the Guidebook Actor
  val routerProps: Props = FromConfig.props(Guidebook.props)

  //The name of the actor must match the name in the configuration file
  val guidebook: ActorRef = system.actorOf(routerProps, "guidebook")
}
