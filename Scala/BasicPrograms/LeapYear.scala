package BasicCorePrograms
/*
@author: Niraj
Leap year or not
 */
object LeapYear {

  def main(args: Array[String]): Unit = {
    try {
      println("Enter the year")
      val year = scala.io.StdIn.readInt()
      var numberOfDigits = 0
      var newYear = year
      while (newYear != 0) {
        newYear = newYear / 10
        numberOfDigits += 1
      }
      if (numberOfDigits != 4) {
        throw new Exception("Enter a 4 digit number")
      }
      if ((year % 4 == 0 && (year % 100 != 0)) || year % 400 == 0) {
        println("It's a leap year")
      }
      else {
        println("It's not a leap year")
      }
    }
    catch {
      case ex:Exception => println(ex)
    }
  }

}
