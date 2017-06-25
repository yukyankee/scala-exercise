package com.yuk.exercise.vector

/**
  * 14
  * Created by wmekareeya on 11/30/2016 AD.
  */
class VectorCalculator(numbers: Vector[Int]) {

  lazy val x = numbers.map(i => i * i)
  lazy val y = x.sum
  lazy val z = Math.sqrt(y.toDouble)
}
