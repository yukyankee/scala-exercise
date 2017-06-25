package com.yuk.exercise.median

import org.scalatest.FunSuite

import MySeqHelper._

/**
  * Created by wmekareeya on 11/30/2016 AD.
  */
class MySeqHelperTest extends FunSuite {


  test("median of 3 integers") {
    implicit val ord = Ordering.Int
    assertResult(Some(3))(Seq(7, 2, 3).median())
  }

  test("median of 2 integers") {
    implicit val ord = Ordering.Int
    assertResult(Some(3.5))(Seq(4, 3).median())
  }

  test("median of 6 integers") {
    implicit val ord = Ordering.Int
    assertResult(Some(8.5))(Seq(7, 12, 5, 10, 4, 20).median())
  }

  test("median of 1 integers") {
    implicit val ord = Ordering.Int
    assertResult(Some(2))(Seq(2).median())
  }

  test("median of empty integer sequence") {
    implicit val ord = Ordering.Int
    assertResult(None)(Seq().median())
  }

  test("median of 3 doubles") {
    implicit val ord = Ordering.Double
    assertResult(Some(3.42))(Seq(7.1, 2.5, 3.42).median())
  }

  test("median of 2 doubles") {
    implicit val ord = Ordering.Double
    assertResult(Some(3.5))(Seq(4, 3).median())
  }

  test("median of 6 doubles") {
    implicit val ord = Ordering.Double
    assertResult(Some(8.5))(Seq(7, 12, 5, 10, 4, 20).median())
  }

  test("median of 1 double") {
    implicit val ord = Ordering.Double
    assertResult(Some(2))(Seq(2).median())
  }

  test("median of empty double sequence") {
    implicit val ord = Ordering.Double
    assertResult(None)(Seq().median())
  }

}
