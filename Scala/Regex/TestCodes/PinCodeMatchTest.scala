import RegexMatching.PincodeMatch
import org.scalatest.FunSuite

class PinCodeMatchTest extends FunSuite
{
  test("PincodeMatchingCorrect") {
    assert(PincodeMatch.patternMatch("832111") == "Pin Code is Okay")
  }
  test("PincodeMatchingCorrectSpace") {
    assert(PincodeMatch.patternMatch("832 111") == "Pin Code is Okay")
  }
  test("PincodeInCorrectPattern"){
    assert(PincodeMatch.patternMatch("83215") == "First three digits should be number followed by an " +
      "optional space and then three digit number")
  }
  test(testName = "PincodeIncorrectSpace"){
    assert(PincodeMatch.patternMatch("832  111") ==
      "First three digits should be number followed by an " +
        "optional space and then three digit number")
  }
}

