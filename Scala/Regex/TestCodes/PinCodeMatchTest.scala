import RegexMatching.PincodeMatch
import org.scalatest.FunSuite

class PinCodeMatchTest extends FunSuite
{
  test("GivenStringInput_WhenPincodeLengthIsSixAndDoesnotContainSpcaeAfterThirdNumber_ReturnValid") {
    assert(PincodeMatch.patternMatch("832111") == "Valid")
  }
  test("GivenStringInput_WhenPincodeLengthIsSixAndContainOneSpaceAfterThirdNumber_ReturnValid") {
    assert(PincodeMatch.patternMatch("832 111") == "Valid")
  }
  test("GivenStringInput_WhenPincodeLengthIsLengthThanSix_ReturnInvalid"){
    assert(PincodeMatch.patternMatch("83215") == "Invalid")
  }
  test(testName = "GivenStringInput_WhenPincodeLengthIsSixAndContainMoreThanOneSpcaeAfterThirdNumber_ReturnInvalid"){
    assert(PincodeMatch.patternMatch("832  111") == "Invalid")
  }
}

