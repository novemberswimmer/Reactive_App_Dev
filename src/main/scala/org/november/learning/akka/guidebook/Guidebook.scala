package org.november.learning.akka.guidebook

import java.util.{Currency, Locale}

import akka.actor.{Actor, ActorLogging, Props}
import org.november.learning.akka.guidebook.Guidebook.Inquiry
import org.november.learning.akka.guidebook.Tourist.Guidance

object Guidebook{
  case class Inquiry(code: String)

  def props: Props = Props(new Guidebook)
}

class Guidebook extends Actor {

  def describe(locale: Locale): String  =
    s"""In ${locale.getDisplayCountry}, ${locale.getDisplayLanguage} is spoken and
       |the currency is the {${Currency.getInstance(locale).getDisplayName}} """.stripMargin

  override def receive: Receive = {
    case Inquiry(code) =>
      println(s"Actor ${self.path.name} responding to inquiry about $code")
      Locale.getAvailableLocales.filter(_.getCountry == code)
        .foreach(locale => sender ! Guidance(code, describe(locale)))

  }
}
