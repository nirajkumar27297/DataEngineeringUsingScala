/*
Write a program Distance.java that takes two integer command-line arguments x
and y and prints the Euclidean distance from the point (x, y) to the origin (0, 0).
 */

package FunctionalPrograms
import scala.io.StdIn._
object DistanceBetween2Points {

  def main(args: Array[String]): Unit = {
    println("Enter the x coordinate")
    val xValue = readFloat()
    println("Enter the y coordinate")
    val yValue = readFloat()
    val distance2Points = math.sqrt(xValue*xValue + yValue*yValue)
    println("The distance between two points %1.3f".format(distance2Points))
  }

}
