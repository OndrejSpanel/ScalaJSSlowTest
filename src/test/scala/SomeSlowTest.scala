import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class SomeSlowTest extends AnyFlatSpec with Matchers {
  "This" should "pass as well" in {
    assert(true)
  }
}
