package com.yuk.exercise.none

/**
  * 11
  * Created by wmekareeya on 11/29/2016 AD.
  */
class NotNoneFinder {

  def find(x: Option[Int] = None, y: Option[Int] = None, z: Option[Int] = None): Option[Int] = {
    x orElse y orElse z
  }

  def find2(numbers: Seq[Option[Int]]): Option[Int] = numbers match {
    case Seq() => None
    case x :: xs => if (x.isDefined) x else find2(xs)
  }

  def find3(x: Option[Int]*) = {
    x.fold(None)((a, b) => a orElse b)
  }

}
