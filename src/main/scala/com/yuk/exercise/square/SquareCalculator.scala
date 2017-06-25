package com.yuk.exercise.square

/**
  * 10
  * Created by wmekareeya on 11/29/2016 AD.
  */
class SquareCalculator {

  def recurSquareList(xs: List[Int]): List[Int] = xs match {
    // base case = when it's empty return empty
    case List() => List()
    // y is the first integer, ys is the rest
    case y :: ys => y * y :: recurSquareList(ys)
  }

  def squareList(xs: List[Int]): List[Int] = {
    xs.map(i => i * i)
  }

}
