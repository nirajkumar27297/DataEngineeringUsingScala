package RegexMatching

import scala.util.matching.Regex

object LastNameMatch {
  def patternMatch(name:String): String = {
    val pattern = new Regex("^[A-Z]{1}[a-z,A-Z]{2,}$")
    val result = pattern.findFirstMatchIn(name) match {
      case Some(_) => "Last Name is Okay"
      case None => "Invalid !!! First Letter should be capital and length should be atleast three"

    }
    result
  }
  def main(args: Array[String]): Unit = {
    var choice = 'y'
    while(choice.toLower == 'y') {
      println("Enter Last Name")
      println("First Letter should be capital and length should be atleast three")
      val name = scala.io.StdIn.readLine()
      println(patternMatch(name))
      println("Do you enter one more time,If yes press  y or else anything")
      choice = scala.io.StdIn.readChar()
    }
  }
}
