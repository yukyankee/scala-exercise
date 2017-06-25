package com.yuk.exercise.vector

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/30/2016 AD.
  */
class VectorCalculatorTest extends FunSuite {

  test("squares of vector containing 2 items") {
    val calculator = new VectorCalculator(Vector(4, 9))
    assertResult(Vector(16, 81))(calculator.x)
  }

  test("squares of vector containing 1 item") {
    val calculator = new VectorCalculator(Vector(5))
    assertResult(Vector(25))(calculator.x)
  }

  test("squares of vector containing nothing") {
    val calculator = new VectorCalculator(Vector())
    assertResult(Vector())(calculator.x)
  }

  test("sum of the squares when the vector contains 2 items") {
    val calculator = new VectorCalculator(Vector(7, 11))
    assertResult(170)(calculator.y)
  }

  test("sum of the squares when the vector contains 1 item") {
    val calculator = new VectorCalculator(Vector(14))
    assertResult(196)(calculator.y)
  }

  test("sum of the squares when the vector contains nothing") {
    val calculator = new VectorCalculator(Vector())
    assertResult(0)(calculator.y)
  }

  test("square root of the sum when the vector contains 2 items") {
    val calculator = new VectorCalculator(Vector(6, 10))
    assertResult(11.661903789690601)(calculator.z)
  }

  test("square root of the sum when the vector contains 1 items") {
    val calculator = new VectorCalculator(Vector(8))
    assertResult(8)(calculator.z)
  }

  test("square root of the sum when the vector contains nothing") {
    val calculator = new VectorCalculator(Vector())
    assertResult(0)(calculator.z)
  }

}
