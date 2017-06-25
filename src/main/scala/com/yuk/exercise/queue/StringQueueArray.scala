package com.yuk.exercise.queue

/**
  * 1.2
  * Created by wmekareeya on 12/8/2016 AD.
  */
class StringQueueArray extends StringQueue {

  var array = new Array[String](0)

  override def put(value: String): Unit = {
    array = Array.concat(array, Array(value))
  }

  override def get(): Option[String] = {
    if (array.isEmpty) {
      None
    }
    else {
      val head = array(0)
      array = array.tail
      Some(head)
    }
  }


}
