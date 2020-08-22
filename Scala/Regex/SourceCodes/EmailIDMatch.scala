package RegexMatching

import scala.util.matching.Regex

object EmailIDMatch {
  def patternMatch(emailID:String): String = {
    val pattern = new Regex("^[0-9a-zA-z]+([.+_-][0-9a-zA-z]+)*@[0-9a-zA-z]+.[a-zA-Z]{2,4}([.][a-zA-z]{2,4})*$")
    val result = pattern.findFirstMatchIn(emailID) match {
      case Some(_) => "Email Id is Okay"
      case None => "Invalid !!! Email ID should be in form abc@example.com"

    }
    result
  }
  def main(args: Array[String]): Unit = {
    var choice = 'y'
    while(choice.toLower == 'y') {
      println("Enter Email ID")
      val emailID = scala.io.StdIn.readLine()
      println(patternMatch(emailID))
      println("Do you enter one more time,If yes press  y or else anything")
      choice = scala.io.StdIn.readChar()
    }
  }

}
