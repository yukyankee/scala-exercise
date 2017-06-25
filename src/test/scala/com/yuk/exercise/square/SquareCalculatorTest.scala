package com.yuk.exercise.square

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by wmekareeya on 11/29/2016 AD.
  */
class SquareCalculatorTest extends FunSuite with Matchers {

  val calculator = new SquareCalculator

  test("recur square when list is not empty") {
    calculator.recurSquareList(List(1, 2, 3)) shouldBe List(1, 4, 9)
  }

  test("recur square when list contains 2 items") {
    calculator.recurSquareList(List(10, 12)) shouldBe List(100, 144)
  }

  test("recur square when list contains 1 item") {
    calculator.recurSquareList(List(7)) shouldBe List(49)
  }

  test("recur square when list is empty") {
    calculator.recurSquareList(List()) shouldBe List.empty
  }

  test("square when list is not empty") {
    assertResult(List(1, 4, 9))(calculator.squareList(List(1, 2, 3)))
  }

  test("square when list contains 2 items") {
    assertResult(List(100, 144))(calculator.squareList(List(10, 12)))
  }

  test("square when list contains 1 item") {
    assertResult(List(49))(calculator.squareList(List(7)))
  }

  test("square when list is empty") {
    assertResult(List())(calculator.squareList(List()))
  }

}
