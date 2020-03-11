package sk.bsmk

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CalculatorSpec extends AnyFlatSpec with Matchers {

  "Simple plus" should "return correct value" in {
    val calculator = new Calculator
    val output = calculator.plus(2, 4)
    output should ===(6)
  }

  it should "fail" in {
    val calculator = new Calculator
    val output = calculator.plus(2, 4)
    output should ===(3)
  }

}
