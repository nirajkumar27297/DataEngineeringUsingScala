/*
@author: Niraj Kumar
 This program takes a command-line argument N and prints a table of the
powers of 2 that are less than or equal to 2^N
 */

package BasicCorePrograms
import scala.util.control.Breaks._
object PowerTable {
  def main(args: Array[String]): Unit = {
    try {
      println("Enter the number")
      val n = scala.io.StdIn.readInt()
      if (n <= 0 && n >= 31) {
        throw new Exception("Enter number in range 1 to 30")
      }
      var i = 0
      breakable {
        while (true) {
          var product = 2 * i
          println("2 * %d = %d".format(i, product))
          if (product >= scala.math.pow(2, n) || i == n) {
            break
          }
          i += 1
        }
      }
    }
    catch {
      case ex: Exception => println(ex)
    }
  }
}
