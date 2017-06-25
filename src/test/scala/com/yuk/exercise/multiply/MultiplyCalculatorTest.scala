package com.yuk.exercise.multiply

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/30/2016 AD.
  */
class MultiplyCalculatorTest extends FunSuite {

  val calculator = new MultiplyCalculator

  test("multiply when 1 value does match") {

    val expected = List(18)
    assertResult(expected)(calculator.multiply(List(1, 2, 3, 4), Map((3 -> 6), (5 -> 2))))
  }

  test("multiply when some values do match") {

    val expected = List(3, 15)
    assertResult(expected)(calculator.multiply(List(1, 2, 3, 4), Map((1 -> 3), (3 -> 5))))
  }

  test("multiply when no values do match") {

    val expected = List()
    assertResult(expected)(calculator.multiply(List(1, 2, 3, 4), Map((5 -> 2), (7 -> 8))))
  }

  test("multiply when input list is empty") {

    val expected = List()
    assertResult(expected)(calculator.multiply(List(), Map((5 -> 2), (7 -> 8))))
  }

  test("multiply when input map is empty") {

    val expected = List()
    assertResult(expected)(calculator.multiply(List(2, 4), Map()))
  }

}
