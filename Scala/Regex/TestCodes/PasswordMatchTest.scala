import RegexMatching.PasswordMatch
import org.scalatest.FunSuite

class PasswordMatchTest extends FunSuite
{
  test("PasswordMatchingCorrect") {
    assert(PasswordMatch.patternMatch("Niraj123@") == "Password is Okay")
  }
  test("PasswordInCorrectPattern"){
    assert(PasswordMatch.patternMatch("niraj123@") == "Password should contain atleast One uppercase,One lowercase,One number and " +
      "one special character " + "and length should be between 8 and 32")
  }
  test(testName = "PasswordIncorrectSpace"){
    assert(PasswordMatch.patternMatch("niraj1234") ==
      "Password should contain atleast One uppercase,One lowercase,One number and " +
        "one special character " + "and length should be between 8 and 32")
  }
}

