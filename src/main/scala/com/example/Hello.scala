package com.example

import kamon.Kamon
import kamon.trace.Tracer
import org.slf4j.LoggerFactory

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits._

object Hello extends App {

  val log = LoggerFactory.getLogger("bla")

  Kamon.start()

  println("Hello, world!")

  Tracer.withNewContext("ws", Some("blabla"), autoFinish = true) {
    log.error("hello1 bla bla")
    Future {
      log.error("hello2 bla bla")
    }
  }

  Runtime.getRuntime.addShutdownHook(new Thread {
    override def run(): Unit = {
      Kamon.shutdown()
    }
  })

  val lock = new AnyRef
  lock.synchronized { lock.wait() }
}
