package com.yuk.exercise.set

import org.scalatest.{FunSuite, Matchers}

/**
  * Created by wmekareeya on 12/7/2016 AD.
  */
class SetTest extends FunSuite with Matchers {

  val setOperation = new SetHelper

  test("intersection when the first set is empty") {
    new EmptySet intersect new NonEmptySet(3, new EmptySet, new EmptySet) shouldBe an[EmptySet]
  }

  test("intersection when the second set is empty") {
    new NonEmptySet(4, new EmptySet, new EmptySet) intersect new EmptySet shouldBe an[EmptySet]
  }

  test("intersection when all sets are empty") {
    new EmptySet intersect new EmptySet shouldBe an[EmptySet]
  }

  test("intersection when one item intersects") {
    val firstSet = new NonEmptySet(4, new NonEmptySet(3, new EmptySet, new EmptySet), new EmptySet)
    val secondSet = new NonEmptySet(4, new EmptySet, new EmptySet)
    val result = firstSet intersect secondSet

    result shouldBe a[NonEmptySet]
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(4, new EmptySet, new EmptySet)))
  }

  test("intersection when two items intersect") {
    val firstSet = new NonEmptySet(10, new EmptySet, new NonEmptySet(12, new EmptySet, new EmptySet))
    val secondSet = new NonEmptySet(10, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(12, new EmptySet, new EmptySet))
    val result = firstSet intersect secondSet

    result shouldBe a[NonEmptySet]
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(12, new NonEmptySet(10, new EmptySet, new EmptySet), new EmptySet)))
  }

  test("intersection when two items intersect with different layout") {
    val firstSet = new NonEmptySet(10, new NonEmptySet(12, new EmptySet, new EmptySet), new EmptySet)
    val secondSet = new NonEmptySet(10, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(12, new EmptySet, new EmptySet))
    val result = firstSet intersect secondSet

    result shouldBe a[NonEmptySet]
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(12, new NonEmptySet(10, new EmptySet, new EmptySet), new EmptySet)))
  }

  test("intersection when all items intersect") {
    val firstSet = new NonEmptySet(29, new NonEmptySet(23, new EmptySet, new EmptySet), new NonEmptySet(31, new EmptySet, new EmptySet))
    val secondSet = new NonEmptySet(29, new NonEmptySet(23, new EmptySet, new EmptySet), new NonEmptySet(31, new EmptySet, new EmptySet))
    val result = firstSet intersect secondSet

    result shouldBe a[NonEmptySet]

    assertResult("( 23, ( e ), ( 31, ( 29, ( e ), ( e ) ), ( e ) ) )")(result.toString)

    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(23, new EmptySet, new NonEmptySet(31, new NonEmptySet(29, new EmptySet, new EmptySet), new EmptySet))))
  }

  test("intersection when no item intersects") {
    val firstSet = new NonEmptySet(2, new NonEmptySet(3, new EmptySet, new EmptySet), new NonEmptySet(5, new EmptySet, new EmptySet))
    val secondSet = new NonEmptySet(7, new NonEmptySet(11, new EmptySet, new EmptySet), new NonEmptySet(13, new EmptySet, new EmptySet))
    val result = firstSet intersect secondSet

    result shouldBe an[EmptySet]
  }

  //union
  test("union when the first set is empty") {
    val result = new EmptySet union new NonEmptySet(3, new EmptySet, new EmptySet)
    result shouldBe a[NonEmptySet]
    //println("result= "+result)
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(3, new EmptySet, new EmptySet)))
  }

  test("union when the second set is empty") {
    val result = new NonEmptySet(4, new EmptySet, new EmptySet) union new EmptySet
    result shouldBe a[NonEmptySet]
    //println("result= "+result)
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(4, new EmptySet, new EmptySet)))
  }

  test("union when all sets are empty") {
    new EmptySet union new EmptySet shouldBe an[EmptySet]
  }

  test("union when one item intersects") {
    val A = new NonEmptySet(4, new NonEmptySet(3, new EmptySet, new EmptySet), new EmptySet)
    val B = new NonEmptySet(4, new EmptySet, new EmptySet)
    val result = A union B

    result shouldBe a[NonEmptySet]
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(4, new NonEmptySet(3, new EmptySet, new EmptySet), new EmptySet)))
  }

  test("union when two items intersect") {
    val A = new NonEmptySet(10, new EmptySet, new NonEmptySet(12, new EmptySet, new EmptySet))
    val B = new NonEmptySet(10, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(12, new EmptySet, new EmptySet))
    val result = A union B

    result shouldBe a[NonEmptySet]
    assertResult("( 10, ( 8, ( e ), ( e ) ), ( 12, ( e ), ( e ) ) )")(result.toString)
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(10, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(12, new EmptySet, new EmptySet))))
  }

  test("union when two items intersect with different layout") {
    val A = new NonEmptySet(10, new NonEmptySet(12, new EmptySet, new EmptySet), new EmptySet)
    val B = new NonEmptySet(10, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(12, new EmptySet, new EmptySet))
    val result = A union B

    result shouldBe a[NonEmptySet]
    assertResult("( 10, ( 8, ( e ), ( e ) ), ( 12, ( e ), ( e ) ) )")(result.toString)
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(10, new NonEmptySet(8, new EmptySet, new EmptySet), new NonEmptySet(12, new EmptySet, new EmptySet))))
  }

  test("union when all items intersect") {
    val A = new NonEmptySet(29, new NonEmptySet(23, new EmptySet, new EmptySet), new NonEmptySet(31, new EmptySet, new EmptySet))
    val B = new NonEmptySet(29, new NonEmptySet(23, new EmptySet, new EmptySet), new NonEmptySet(31, new EmptySet, new EmptySet))
    val result = A union B

    result shouldBe a[NonEmptySet]
    assertResult("( 29, ( 23, ( e ), ( e ) ), ( 31, ( e ), ( e ) ) )")(result.toString)
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(29, new NonEmptySet(23, new EmptySet, new EmptySet), new NonEmptySet(31, new EmptySet, new EmptySet))))
  }

  test("union when no item intersects") {
    val A = new NonEmptySet(2, new NonEmptySet(3, new EmptySet, new EmptySet), new NonEmptySet(5, new EmptySet, new EmptySet))
    val B = new NonEmptySet(7, new NonEmptySet(11, new EmptySet, new EmptySet), new NonEmptySet(13, new EmptySet, new EmptySet))
    val result = A union B

    result shouldBe a[NonEmptySet]
    assertResult("( 7, ( 11, ( 2, ( e ), ( 5, ( 3, ( e ), ( e ) ), ( e ) ) ), ( e ) ), ( 13, ( e ), ( e ) ) )")(result.toString)
    val left = new NonEmptySet(11, new NonEmptySet(2, new EmptySet, new NonEmptySet(5, new NonEmptySet(3, new EmptySet, new EmptySet), new EmptySet)), new EmptySet)
    val right = new NonEmptySet(13, new EmptySet, new EmptySet)
    assertResult(true)(setOperation.setEquals(result, new NonEmptySet(7, left, right)))
  }

}
