import RegexMatching.LastNameMatch
import org.scalatest.FunSuite

class LastNameMatchTest extends FunSuite {
  test("NameMatchingCorrect") {
    assert(LastNameMatch.patternMatch("Kumar") == "Last Name is Okay")
  }
  test("NameMatchingInCorrectPattern"){
    assert(LastNameMatch.patternMatch("kumar") == "Invalid !!! First Letter should be capital and length should be atleast three")
  }
  test(testName = "NameMatchingIncorrectLength"){
    assert(LastNameMatch.patternMatch("ku") == "Invalid !!! First Letter should be capital and length should be atleast three")
  }

}
