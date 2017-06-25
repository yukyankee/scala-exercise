package com.yuk.exercise.set

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by wmekareeya on 11/29/2016 AD.
  */
class SetHelperTest extends FunSuite with Matchers {

  val helper = new SetHelper

  test("how contain works") {

    val intSet = new NonEmptySet(4, new NonEmptySet(3, new EmptySet, new EmptySet), new NonEmptySet(5, new EmptySet, new EmptySet))

    assertResult(false)(intSet.contains(2))
    assertResult(true)(intSet.contains(3))
    assertResult(true)(intSet.contains(4))
    assertResult(true)(intSet.contains(5))
    assertResult(false)(intSet.contains(6))
  }

  test("setEquals when first set is bigger") {
    val firstSet = new NonEmptySet(4, new NonEmptySet(3, new EmptySet, new EmptySet), new EmptySet)
    val secondSet = new NonEmptySet(4, new EmptySet, new EmptySet)
    assertResult(false)(helper.setEquals(firstSet, secondSet))
  }

  test("setEquals second set is bigger") {
    val firstSet = new NonEmptySet(4, new EmptySet, new EmptySet)
    val secondSet = new NonEmptySet(7, new NonEmptySet(8, new EmptySet, new EmptySet), new EmptySet)
    assertResult(false)(helper.setEquals(firstSet, secondSet))
  }

  test("setEquals different items") {
    val firstSet = new NonEmptySet(7, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(9, new EmptySet, new EmptySet))
    val secondSet = new NonEmptySet(9, new NonEmptySet(10, new EmptySet, new EmptySet), new NonEmptySet(11, new EmptySet, new EmptySet))
    assertResult(false)(helper.setEquals(firstSet, secondSet))
  }

  test("setEquals same items") {
    val firstSet = new NonEmptySet(7, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(9, new EmptySet, new EmptySet))
    val secondSet = new NonEmptySet(7, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(9, new EmptySet, new EmptySet))
    assertResult(true)(helper.setEquals(firstSet, secondSet))
  }

  test("setEquals first set is empty") {
    val secondSet = new NonEmptySet(7, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(9, new EmptySet, new EmptySet))
    assertResult(false)(helper.setEquals(new EmptySet, secondSet))
  }

  test("setEquals second set is empty") {
    val firstSet = new NonEmptySet(7, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(9, new EmptySet, new EmptySet))
    assertResult(false)(helper.setEquals(firstSet, new EmptySet))
  }
}
