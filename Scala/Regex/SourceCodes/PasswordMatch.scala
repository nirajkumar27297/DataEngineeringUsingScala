package RegexMatching

import scala.util.matching.Regex


object PasswordMatch {
  def patternMatch(password:String): String = {
    val pattern = new Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*.!@$%^&]).{8,32}$")
    val result = pattern.findFirstMatchIn(password) match {
      case Some(_) => "Password is Okay"
      case None => "Password should contain atleast One uppercase,One lowercase,One number and " +
        "one special character " + "and length should be between 8 and 32"
    }
    result
  }

  def main(args: Array[String]): Unit = {
    var choice = 'y'
    while(choice.toLower == 'y'){
      println("Enter Password")
      println("Password should contain atleast One uppercase,One lowercase,One number and " +
        "one special character " + "and length should be between 8 and 32")
      val password = scala.io.StdIn.readLine()
      println(patternMatch(password))
      println("Do you enter one more time,If yes press  y or else anything")
      choice = scala.io.StdIn.readChar()

    }
  }

}
