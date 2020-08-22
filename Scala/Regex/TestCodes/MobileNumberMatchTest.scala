import RegexMatching.MobileNumberMatch
import org.scalatest.FunSuite

class MobileNumberMatchTest extends FunSuite
{
  test("MobileNumberMatchingCorrect") {
    assert(MobileNumberMatch.patternMatch("91 8249123293") == "Mobile Number is Okay")
  }
  test("MobileNumberInCorrectPattern"){
    assert(MobileNumberMatch.patternMatch("918249123293") == "Invalid !!! First two digits should be country code followed by a space " +
      "and latter 10 digits mobile number")
  }
  test(testName = "MobileNumberIncorrectSpace"){
    assert(MobileNumberMatch.patternMatch("91 8249123") ==
      "Invalid !!! First two digits should be country code followed by a space " +
        "and latter 10 digits mobile number")
  }

}
