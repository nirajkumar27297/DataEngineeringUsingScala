package RegexMatching

import scala.util.matching.Regex

object PincodeMatch {
  def patternMatch(pincode:String): String = {
    val pattern = new Regex("^[1-9][0-9]{2}\\s{0,1}[0-9]{3}$")
    val result =  pattern.findFirstMatchIn(pincode) match {
      case Some(_) => "Valid"
      case None => "Invalid"
    }
    result
  }
  def main(args: Array[String]): Unit = {
    var choice = 'y'
    while(choice.toLower == 'y') {
      println("Enter 6 digit Pin Code\nFirst three digits should be number followed by an " +
        "optional space and then three digit number")
      val pincode = scala.io.StdIn.readLine()
      println(patternMatch(pincode)+"\nDo you enter one more time,If yes press  y or else anything")
      choice = scala.io.StdIn.readChar()
    }
  }
}
