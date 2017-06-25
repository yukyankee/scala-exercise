package com.yuk.exercise.queue

/**
  * 2
  * Created by wmekareeya on 11/23/2016 AD.
  */
trait ReversedStringQueue extends StringQueue {

  override def put(value: String): Unit = {
    super.put(value.reverse)
  }

}

/*

trait StringWithLength extends StringQueue {
  override def put(value: String) : Unit = {
    super.put(s"$value-${value.length}")
  }
}


object test{
  object test extends StringQueue with StringArray with StringWithLength
  object test2 extends StringQueue  with StringWithLength with StringArray

  test.put("hello")    // add with lenght, then reverse  => 5-olleh
  test2.put("hello")   // reverse then add length  => olleh-5

  println(test.get)     //
  println(test2.get)
}
*/