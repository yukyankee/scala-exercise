package com.yuk.exercise.double

/**
  * 3
  * Created by wmekareeya on 12/1/2016 AD.
  */
object DoubleHelper {
  implicit val defaultPrecision = DoublePrecision(0.0001) //default
  implicit val precision: Double = 0.0

  //case class inside this class is like struct in java
  case class DoublePrecision(value: Double)

  implicit class DoubleComparator(a: Double) {
    def ~=(b: Double)(implicit precision: DoublePrecision): Boolean = {
      if (math.abs(a - b) < precision.value) true
      else false
    }

    def ~<(b: Double)(implicit precision: DoublePrecision): Boolean = {
      if (math.abs(a - b) < precision.value) true
      else false
    }
  }

}