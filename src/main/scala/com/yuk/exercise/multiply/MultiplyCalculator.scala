package com.yuk.exercise.multiply

/**
  * 12
  * Created by wmekareeya on 11/30/2016 AD.
  */
class MultiplyCalculator {

  def multiply(list: List[Int], map: Map[Int, Double]): List[Int] = {

    //list.filter(map.contains(_)).map(x => (x * map.getOrElse(x, 1.0)).toInt)

    list.flatMap(a => map.get(a).map(x => (x * a).toInt))

  }

}
