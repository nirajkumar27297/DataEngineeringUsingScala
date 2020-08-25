import org.scalatest.{FunSuite, Matchers}
import RegexMatching.EmailIDMatch
import org.scalatest.prop.TableDrivenPropertyChecks._
class EmailIDMatchTestScala extends FunSuite with Matchers {
  test("testEmail_ConsistingOfValidInvalidEmail_ReturnValidForValidEmail_InvalidForInvalidEmail") {
    //    val x = Array("abc@yahoo.com","abc-100@yahoo.com")
    //    val y = Array("Valid","Invalid")
    //
    //    forAll { (x: String, y: String) =>
    //      assert(EmailIDMatch.patternMatch(x) == y)
    //    }
    val params = Table(("result", "EmailID"),
      ("Valid","abc@yahoo.com"),
      ("Valid","abc-100@yahoo.com"),
      ("Valid","abc-100@yahoo.com"),
      ("Valid","abc.100@yahoo.com"),
      ("Valid","abc111@abc.com"),
      ("Valid","abc-100@abc.net"),
      ("Valid","abc.100@abc.com.au"),
      ("Valid","abc@1.com"),
      ("Valid","abc@gmail.com.com"),
      ("Valid","abc+100@gmail.com"),
      ("Invalid","abc"),
      ("Invalid","abc@.com.my"),
      ("Invalid","abc123@gmail.a"),
      ("Invalid","abc123@.com"),
      ("Invalid","abc123@.com.com"),
      ("Invalid","abc123@.abc.com"),
      ("Invalid","abc()*@gmail.com"),
      ("Invalid","abc@%*.com"),
      ("Invalid","abc..2002@gmail.com"),
      ("Invalid","abc.@gmail.com"),
      ("Invalid","abc@abc@gmail.com"),
      ("Invalid","abc@gmail.com.1a"),
      ("Invalid","abc@abc@gmail.com.aa.uu")
    )

    forAll(params) {(result, EmailID) =>
      assertResult(result)(EmailIDMatch.patternMatch(EmailID))}
  }

}