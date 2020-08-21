/*
@author: Niraj kumar
Find all the triplets whose sum is zero
 */
package FunctionalPrograms
import scala.util.Sorting.quickSort
object TripletsSum {

  def triplets(arr:Array[Int]): Unit = {
    quickSort[Int](arr)
    var countTriplets = 0
    var i = 0
    while(i < arr.length - 2) {
      var startIndex = i + 1
      var endIndex = arr.length - 1
      while( startIndex < endIndex ) {
        if(arr(startIndex) + arr(endIndex) > -arr(i) ) {
          endIndex = endIndex - 1
        }
        else if(arr(startIndex) + arr(endIndex) < -arr(i)) {
          startIndex = startIndex + 1
        }
        else {
          println(arr(i),arr(startIndex),arr(endIndex))
          startIndex += 1
          endIndex -= 1
          countTriplets += 1
        }
      }
      i += 1
    }
    println("The total number of triplets are "+countTriplets)

    }
  def main(args: Array[String]): Unit = {
    println("Enter the elements of array separated by commas")
    var arr: Array[Int] = scala.io.StdIn.readLine().split(",").map(_.toInt)
    triplets(arr)
  }
}
