package com.yuk.exercise.queue

import scala.collection.mutable

/**
  * 1.1
  * Created by wmekareeya on 11/23/2016 AD.
  */
trait StringQueue {

  var queue = new mutable.Queue[String]()

  def put(value: String): Unit = {
    queue.enqueue(value)
  }

  def get(): Option[String] = {
    if (queue.isEmpty) None
    else Some(queue.dequeue())
  }
}
