package com.yuk.exercise.none

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/29/2016 AD.
  */
class NotNoneFinderTest extends FunSuite {

  val notNoneFinder = new NotNoneFinder

  test("first argument is none") {
    assertResult(1)(notNoneFinder.find(y = Some(1), z = Some(2)).getOrElse(None))
  }

  test("first and second arguments are none") {
    assertResult(5)(notNoneFinder.find(z = Some(5)).getOrElse(None))
  }

  test("first and third arguments are none") {
    assertResult(6)(notNoneFinder.find(y = Some(6)).getOrElse(None))
  }

  test("nothing is none") {
    assertResult(7)(notNoneFinder.find(x = Some(7), y = Some(8), z = Some(9)).getOrElse(None))
  }

  test("none") {
    assertResult(None)(notNoneFinder.find().getOrElse(None))
  }

  test("find2 - 2 items exist") {
    assertResult(5)(notNoneFinder.find2(Seq(Some(5), Some(2))).getOrElse(None))
  }

  test("find2 - 1 items exist") {
    assertResult(1)(notNoneFinder.find2(Seq(Some(1))).getOrElse(None))
  }

  test("find2 - nothing") {
    assertResult(None)(notNoneFinder.find2(Seq.empty).getOrElse(None))
  }

  test("find3 - 2 items exist") {
    assertResult(5)(notNoneFinder.find3(Some(5), Some(2)).getOrElse(None))
  }

  test("find3 - 1 items exist") {
    assertResult(1)(notNoneFinder.find3(Some(1)).getOrElse(None))
  }

  test("find3 - nothing") {
    assertResult(None)(notNoneFinder.find3().getOrElse(None))
  }

}
