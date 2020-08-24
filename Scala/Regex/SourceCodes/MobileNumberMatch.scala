package RegexMatching

import scala.util.matching.Regex

object MobileNumberMatch {
  def patternMatch(mobileNumber:String): String = {
    val pattern = new Regex("^[1-9]{2}\\s[1-9]{1}[0-9]{9}$")
    val result = pattern.findFirstMatchIn(mobileNumber) match {
      case Some(_) => "Valid"
      case None => "Invalid"
    }
    result
  }
  def main(args: Array[String]): Unit = {
    var choice = 'y'
    while(choice.toLower == 'y') {
      println("Enter Mobile Number\nFirst two digits should be country code followed by a space and latter 10 digits mobile number")
      val mobileNumber = scala.io.StdIn.readLine()
      println(patternMatch(mobileNumber)+"\nDo you enter one more time,If yes press  y or else anything")
      choice = scala.io.StdIn.readChar()
    }
  }
}

