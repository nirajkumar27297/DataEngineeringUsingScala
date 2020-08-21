/*
A library for reading in 2D arrays of integers, doubles, or booleans from
standard input and printing them out to standard output.
 */
package FunctionalPrograms
import scala.io.StdIn._
object TwoDArrayInput {

  def main(args: Array[String]): Unit = {
    println("Enter the number of rows")
    val nrows = readInt()
    println("Enter the number of columns")
    val ncols = readInt()
    var newArrayChar = Array.ofDim[Char](nrows,ncols)
    var newArrayInt = Array.ofDim[Int](nrows,ncols)
    var newArrayDouble = Array.ofDim[Double](nrows,ncols)
    var newArrayBoolean = Array.ofDim[Boolean](nrows,ncols)

    println("For Integer Array")
    for(i <- 0.until(nrows)){
      println("Enter values separated by commas for row %d".format(i+1))
      val values = readLine()
      newArrayInt(i) = values.split(",").map(_.toInt)
    }
    println("For Double Array")
    for(i <- 0.until(nrows)){
      println("Enter values separated by commas for row %d".format(i+1))
      val values = readLine()
      newArrayDouble(i) = values.split(",").map(_.toDouble)
    }
    println("For Boolean Array")
    for(i <- 0.until(nrows)){
      println("Enter values separated by commas for row %d".format(i+1))
      val values = readLine()
      newArrayBoolean(i) = values.split(",").map(_.toBoolean)
    }
    println("Integer Array")
    for(i <- 0.until(nrows)){
      for(j <- 0.until(ncols)){
        print(newArrayInt(i)(j)+" ")
      }
      println()
    }
    println("Double Array")
    for(i <- 0.until(nrows)){
      for(j <- 0.until(ncols)){
        print(newArrayDouble(i)(j)+" ")
      }
      println()
    }
    println("Boolean Array")
    for(i <- 0.until(nrows)){
      for(j <- 0.until(ncols)){
        print(newArrayBoolean(i)(j)+" ")
      }
      println()
    }
  }

}
