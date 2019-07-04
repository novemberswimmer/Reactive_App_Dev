package org.november.learning.akka.guidebook

import java.util.Locale

import akka.actor.ActorSystem
import akka.util.Timeout

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object TouristMain extends App {

  //Names the actory system uniquely. The unique name if for convenience in troubleshooting which app is having issue.
  val system = ActorSystem("TouristSystem")

  /*
  Specify the remote URL path for the guidebook actor
  URL syntax:
  akka.tcp://<name_of_remote_actor_system>@<hostname_remote_actor_is_running>:<port>/user/<name_given_to_actor>
   */
  val path="akka.tcp://BookSystem@127.0.0.1:2553/user/guidebook"

  implicit  val timeout: Timeout = 5.seconds
  implicit val ec:ExecutionContextExecutor = system.dispatcher

  /*
  Converts the path to an ActorSelection and resolves it, this returns a Future[ActorRef]
  If guidebook is resolved successfully continue
   */
  system.actorSelection(path).resolveOne().onComplete{
    case Success(guidebook)=>
      val tourist = system.actorOf(Tourist.props(guidebook))

      tourist ! Tourist.Start(Locale.getISOCountries)
    //If guidebook fails to resolve, fail with an error
    case Failure(e) => println(e)
  }
}
