/*@author: Niraj
Prints the Nth harmonic number: 1/1 + 1/2 + ... + 1/N
*/
package BasicCorePrograms

object NthHarmonicNumber {

  def harmonicNumber(n:Float):Float = {
    if(n <= 1){
      return 1
    }
    1/n +  harmonicNumber(n-1)
  }
  def main(args: Array[String]): Unit = {
    try {
      println("Enter the number ")
      val number = scala.io.StdIn.readFloat()
      if(number <= 0){
        throw new Exception("Please enter a positive number")
      }
      val result = harmonicNumber(number)
      println("The harmonic number is %1.2f".format(result))

    }
    catch {
      case ex:Exception => println(ex)
    }
  }

}
