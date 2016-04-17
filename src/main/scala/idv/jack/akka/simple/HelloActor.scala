package idv.jack.akka.simple
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("Hello World!")
    case _ => println("Not hello string")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  
  helloActor ! "hello"
  helloActor ! "aaaaa"
  
  system.shutdown()
}