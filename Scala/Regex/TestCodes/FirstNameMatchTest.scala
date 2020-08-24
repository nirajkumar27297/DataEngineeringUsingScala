import org.scalatest.FunSuite
import RegexMatching.FirstNameMatch
class FirstNameMatchTest extends FunSuite {
  test("GivenStringInput_WhenFirstAlphabetCapitalAndLengthGreaterThan3_ReturnValid") {
    assert(FirstNameMatch.patternMatch("Niraj") == "Valid")
  }
  test("GivenStringInput_WhenFirstAlphabetSmallAndLengthGreaterThan3_ReturnInvalid"){
    assert(FirstNameMatch.patternMatch("niraj") == "Invalid")
  }
  test(testName = "GivenStringInput_WhenFirstAlphabetCapitalAndLengthLessThan3_ReturnInvalid") {
    assert(FirstNameMatch.patternMatch("Ni") == "Invalid")
  }
}
