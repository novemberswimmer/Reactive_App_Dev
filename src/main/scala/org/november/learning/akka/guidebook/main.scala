package org.november.learning.akka.guidebook

import java.util.Locale

import akka.actor.{ActorRef, ActorSystem}

object main extends App {

  val system: ActorSystem = ActorSystem("GuideSystem")

  val guidebook: ActorRef = system.actorOf(Guidebook.props, "Guide-Book")

  val tourist: ActorRef = system.actorOf(Tourist.props(guidebook), "Tourist")

  tourist ! Tourist.Start(Locale.getISOCountries)
}
