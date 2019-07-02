package org.november.learning.akka.guidebook

import akka.actor.{Actor, ActorRef, Props}
import org.november.learning.akka.guidebook.Guidebook.Inquiry
import org.november.learning.akka.guidebook.Tourist.{Guidance, Start}

object Tourist {
  case class Guidance(code: String, description: String)
  case class Start(code: Seq[String])

  def props(guidebook: ActorRef) : Props = Props(new Tourist(guidebook))
}
class Tourist(guidebook: ActorRef) extends Actor {

  override def receive: Receive = {
    case Start(codes) =>
      codes.foreach(guidebook ! Inquiry(_))
    case Guidance(code, description) =>
      println(s"$code: $description")
  }
}
