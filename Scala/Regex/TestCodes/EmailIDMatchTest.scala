import RegexMatching.EmailIDMatch
import org.scalatest.FunSuite

class EmailIDMatch extends FunSuite
{
  test("EmailIDMatchingCorrectFirst") {
    assert(EmailIDMatch.patternMatch("abc@yahoo.com") == "Email Id is Okay")
  }
  test("EmailIDMatchingCorrectSecond") {
    assert(EmailIDMatch.patternMatch("abc-100@yahoo.com") == "Email Id is Okay")
  }
  test("EmailIDCorrectThird"){
    assert(EmailIDMatch.patternMatch("abc.100@yahoo.com") == "Email Id is Okay")
  }
  test(testName = "EmailIDCorrectFourth"){
    assert(EmailIDMatch.patternMatch("abc111@abc.com") == "Email Id is Okay")
  }
  test("EmailIDMatchingCorrectFifth") {
    assert(EmailIDMatch.patternMatch("abc-100@abc.net") == "Email Id is Okay")
  }
  test("EmailIDMatchingCorrectSixth") {
    assert(EmailIDMatch.patternMatch("abc.100@abc.com.au") == "Email Id is Okay")
  }
  test("EmailIDCorrectSeventh"){
    assert(EmailIDMatch.patternMatch("abc@1.com") == "Email Id is Okay")
  }
  test(testName = "EmailIDCorrectEight"){
    assert(EmailIDMatch.patternMatch("abc@gmail.com.com") == "Email Id is Okay")
  }

  test(testName = "EmailIDCorrectNinth"){
    assert(EmailIDMatch.patternMatch("abc+100@gmail.com") == "Email Id is Okay")
  }
  test(testName = "EmailIDIncorrectFirst"){
    assert(EmailIDMatch.patternMatch("abc") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectSecond"){
    assert(EmailIDMatch.patternMatch("abc@.com.my") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectThird"){
    assert(EmailIDMatch.patternMatch("abc123@gmail.a") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectFourth"){
    assert(EmailIDMatch.patternMatch("abc123@.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectFifth"){
    assert(EmailIDMatch.patternMatch("abc123@.com.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectSixth"){
    assert(EmailIDMatch.patternMatch(".abc123@abc.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectSeventh"){
    assert(EmailIDMatch.patternMatch("abc()*@gmail.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectEight"){
    assert(EmailIDMatch.patternMatch("abc@%*.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectNinth"){
    assert(EmailIDMatch.patternMatch("abc..2002@gmail.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectTenth"){
    assert(EmailIDMatch.patternMatch("abc.@gmail.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectEleventh"){
    assert(EmailIDMatch.patternMatch("abc@abc@gmail.com") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectTwelfth"){
    assert(EmailIDMatch.patternMatch("abc@gmail.com.1a") == "Invalid !!! Email ID should be in form abc@example.com")
  }
  test(testName = "EmailIDIncorrectThirtheenth"){
    assert(EmailIDMatch.patternMatch("abc@abc@gmail.com.aa.uu") == "Invalid !!! Email ID should be in form abc@example.com")
  }

}

