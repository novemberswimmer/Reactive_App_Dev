package org.november.learning.akka.guidebook

import java.util.Locale

import akka.actor.{ActorRef, ActorSystem}
import akka.routing.FromConfig
import org.november.learning.akka.guidebook.Tourist.Start

object TouristMain_2_7 extends App{

  val system: ActorSystem = ActorSystem("TouristSystem")

  /*
  Create a AKKA Router ActorRef from configuration
  Uses a different name to distinguish this router from the router pool used by the Guidebook driver
  With the original TouristMain the driver resolved the remote actor path by using a Future[ActorRef], and the system
  waited for confirmation that the remote actor system have been verified before creating the Tourist Actor.  With a
  group router, all work is handled by the group router.
   */


  val guidebook: ActorRef = system.actorOf(FromConfig.props(), "balancer")

  val tourist: ActorRef = system.actorOf(Tourist.props(guidebook), "Tourist")

  tourist ! Start(Locale.getISOCountries)
}
