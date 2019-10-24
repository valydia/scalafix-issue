/*
rule = Scalafix
*/
package fix

import java.net.InetSocketAddress

import cats.effect.{ContextShift, IO}
import fs2.Stream
import fs2.io.udp.{AsynchronousSocketGroup, open}

import scala.concurrent.ExecutionContext

object Scalafix {

  implicit val executionContext: ExecutionContext =
    ExecutionContext.Implicits.global

  implicit val contextShiftIO: ContextShift[IO] = IO.contextShift(executionContext)

  implicit val AG = AsynchronousSocketGroup()

  Stream.resource(open[IO]())
  Stream.resource(open[IO](address = new InetSocketAddress(0)))
  Stream.resource(open[IO](address = new InetSocketAddress(0), reuseAddress = true))
  Stream.resource(open[IO](new InetSocketAddress(0),true))
  // Failures
  Stream.resource(open[IO](reuseAddress = true))
  Stream.resource(open[IO](reuseAddress = true, multicastLoopback = true))
  Stream.resource(open[IO]( multicastLoopback = true))
}
