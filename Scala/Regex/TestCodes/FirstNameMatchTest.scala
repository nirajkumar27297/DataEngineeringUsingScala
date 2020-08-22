import org.scalatest.FunSuite
import RegexMatching.FirstNameMatch
class FirstNameMatchTest extends FunSuite {
  test("NameMatchingCorrect") {
    assert(FirstNameMatch.patternMatch("Niraj") == "First Name is Okay")
  }
  test("NameMatchingInCorrectPattern"){
    assert(FirstNameMatch.patternMatch("niraj") == "Invalid !!! First Letter should be capital and length should be atleast three")
  }
  test(testName = "NameMatchingIncorrectLength"){
    assert(FirstNameMatch.patternMatch("Ni") == "Invalid !!! First Letter should be capital and length should be atleast three")
  }
}
