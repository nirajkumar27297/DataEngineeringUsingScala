import RegexMatching.MobileNumberMatch
import org.scalatest.FunSuite

class MobileNumberMatchTest extends FunSuite
{
  test("GivenStringInput_WhenMobileNumberContainsCountryCodeFollowedBySpaceAndTenDigitsNumber_ReturnValid") {
    assert(MobileNumberMatch.patternMatch("91 8249123293") == "Valid")
  }
  test("GivenStringInput_WhenMobileNumberContainsCountryCodeFollowedByNonSpaceAndTenDigitsNumber_ReturnInvalid"){
    assert(MobileNumberMatch.patternMatch("918249123293") == "Invalid")
  }
  test(testName = "GivenStringInput_WhenMobileNumberContainsCountryCodeFollowedBySpaceAndButNotTenDigitsNumber_ReturnInvalid"){
    assert(MobileNumberMatch.patternMatch("91 8249123") == "Invalid")
  }

}
