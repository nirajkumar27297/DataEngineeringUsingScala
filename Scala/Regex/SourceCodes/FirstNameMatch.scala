package RegexMatching
import scala.util.matching.Regex
object FirstNameMatch {

  def patternMatch(name:String): String = {
    val pattern = new Regex("^[A-Z]{1}[a-z,A-Z]{2,}$")
    val result = pattern.findFirstMatchIn(name) match {
      case Some(_) => "Valid"
      case None => "Invalid"

    }
    result
  }
  def main(args: Array[String]): Unit = {
    var choice = 'y'
    while(choice.toLower == 'y') {
      println("Enter First Name\nFirst Letter should be capital and length should be atleast three")
      val name = scala.io.StdIn.readLine()
      println(patternMatch(name)+"\nDo you enter one more time,If yes press  y or else anything")
      choice = scala.io.StdIn.readChar()
      }
    }
}
