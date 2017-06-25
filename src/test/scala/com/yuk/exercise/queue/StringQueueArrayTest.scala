package com.yuk.exercise.queue

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/23/2016 AD.
  */
class StringQueueArrayTest extends FunSuite {

  test("queue holds one item") {
    val array = new StringQueueArray
    array.put("abc")
    assertResult("abc")(array.get().getOrElse(None))
  }

  test("queue should return the head of the queue when there are multiple items") {
    val array = new StringQueueArray
    array.put("abc")
    array.put("def")
    array.put("xyz")
    assertResult("abc")(array.get().getOrElse(None))
  }

  test("queue should return new head of the queue when the first item is already removed") {
    val array = new StringQueueArray
    array.put("abc")
    array.put("def")
    assertResult("abc")(array.get().getOrElse(None))
    array.put("xyz")
    assertResult("def")(array.get().getOrElse(None))
  }

  test("queue should return none if it is empty") {
    val array = new StringQueueArray
    assertResult(None)(array.get().getOrElse(None))
  }
}
