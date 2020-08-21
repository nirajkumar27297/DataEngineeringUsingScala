/*
find the roots of the equation a*x*x + b*x + c
 */
package FunctionalPrograms
import scala.io.StdIn._
object QuadraticEquation {
  def main(args: Array[String]): Unit = {

    println("Enter the value of a,b,c separated by comma")
    val input: Array[Float] = readLine().split(",") map (_.toFloat)
    val a = input(0)
    val b = input(1)
    val c = input(2)
    //calculating discriminant
    val discriminant = b * b - 4 * a * c
    println(discriminant)
    if (discriminant > 0) {
      val firstRoot = (-b + math.sqrt(discriminant))/ (2 * a)
      val secondRoot = (-b - math.sqrt(discriminant)) / (2 * a)
      print("The roots of the equation are real %1.2f,%1.2f".format(firstRoot, secondRoot))
    }
    else if (discriminant == 0) {
      val firstRoot = (-b / (2 * a))
      print("The roots of the equations are real and equal and are %1.2f,%1.2f".format(firstRoot, firstRoot))
    }
    else {
      print("The roots are imaginery")

    }
  }

}
