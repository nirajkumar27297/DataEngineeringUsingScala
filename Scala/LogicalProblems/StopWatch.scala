/*
@author: Niraj Kumar
Write a Stopwatch Program for measuring the time that elapses between
the start and end clicks
 */
package LogicalPrograms
import scala.io.StdIn._
object StopWatch {
  def main(args: Array[String]): Unit = {
    println("Press any key to start")
    val start = readChar()
    val startTime = System.nanoTime()
    println("Press any key to stop")
    val end = readChar()
    val endTime = System.nanoTime()
    val timeElapsed = (endTime - startTime) / 1e9d
    println("The elapsed time is %1.2fs".format(timeElapsed))

  }

}
