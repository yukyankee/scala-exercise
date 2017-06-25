package com.yuk.exercise.gcd

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/24/2016 AD.
  */
class GcdCalculatorTest extends FunSuite {

  test("gcd of 72 and 48 is 24") {
    assertResult(24)(GcdCalculator.gcd(72, 48))
  }

  test("gcd of 1 and 0 is 1") {
    assertResult(1)(GcdCalculator.gcd(1, 0))
  }

  test("gcd of 0 and 5 is 5") {
    assertResult(5)(GcdCalculator.gcd(0, 5))
  }

  test("gcd of 100 and 100 is 100") {
    assertResult(100)(GcdCalculator.gcd(100, 100))
  }

  test("gcd of 37 and 600 is 1") {
    assertResult(1)(GcdCalculator.gcd(37, 600))
  }

  test("gcd of 624129 and 2061517 is 18913") {
    assertResult(18913)(GcdCalculator.gcd(624129, 2061517))
  }
}
