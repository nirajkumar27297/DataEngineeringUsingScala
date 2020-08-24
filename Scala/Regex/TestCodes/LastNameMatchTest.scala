import RegexMatching.LastNameMatch
import org.scalatest.FunSuite

class LastNameMatchTest extends FunSuite {
  test("GivenStringInput_WhenFirstAlphabetCapitalAndLengthGreaterThan3_ReturnValid") {
    assert(LastNameMatch.patternMatch("Kumar") == "Valid")
  }
  test("GivenStringInput_WhenFirstAlphabetSmallAndLengthGreaterThan3_ReturnInvalid") {
    assert(LastNameMatch.patternMatch("kumar") == "Invalid")
  }
  test(testName = "GivenStringInput_WhenFirstAlphabetCapitalAndLengthLessThan3_ReturnInvalid") {
    assert(LastNameMatch.patternMatch("Ku") == "Invalid")
  }
}
