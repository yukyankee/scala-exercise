package com.yuk.exercise.queue

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/24/2016 AD.
  */
class ReversedStringQueueTest extends FunSuite {

  //stackable traits run from right to left
  class MyReversedStringQueue extends StringQueue with ReversedStringQueue

  test("queue holds reversed strings") {
    val queue = new MyReversedStringQueue
    queue.put("abc")
    assertResult("cba")(queue.get().getOrElse(None))
  }

  test("queue should return the head of the queue when there are multiple items") {
    val queue = new MyReversedStringQueue
    queue.put("alice")
    queue.put("bob")
    queue.put("eve")
    assertResult("ecila")(queue.get().getOrElse(None))
  }

  test("queue should return new head of the queue when the first item is already removed") {
    val queue = new MyReversedStringQueue
    queue.put("bob")
    queue.put("alice")
    assertResult("bob")(queue.get().getOrElse(None))
    queue.put("eve")
    assertResult("ecila")(queue.get().getOrElse(None))
  }

  test("queue should return none if it is empty") {
    val queue = new MyReversedStringQueue
    assertResult(None)(queue.get())
  }

}
