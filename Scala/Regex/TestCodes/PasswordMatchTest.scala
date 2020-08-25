import RegexMatching.PasswordMatch
import org.scalatest.FunSuite

class PasswordMatchTest extends FunSuite
{
  test("GivenStringInput_WhenPasswordContainsOneCapitalAlphabetOneSmallAlphabetOneSpecialCharacterAndLengthGreaterThanEight_ReturnValid") {
    assert(PasswordMatch.patternMatch("Niraj123@") == "Valid")
  }
  test("GivenStringInput_WhenPasswordContainsOneSmallAlphabetOneSpecialCharacterAndLengthGreaterThanEight_ReturnInvalid"){
    assert(PasswordMatch.patternMatch("niraj123@") == "Invalid")
  }
  test(testName = "GivenStringInput_WhenPasswordContainsOneSmallAlphabetAndLengthGreaterThanEight_ReturnInvalid"){
    assert(PasswordMatch.patternMatch("niraj1234") == "Invalid")
  }
}

