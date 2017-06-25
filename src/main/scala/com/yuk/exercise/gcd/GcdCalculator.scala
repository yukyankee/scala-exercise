package com.yuk.exercise.gcd

import scala.annotation.tailrec

/**
  * 4
  * Created by wmekareeya on 11/24/2016 AD.
  */
object GcdCalculator {

  @tailrec
  def gcd(a: Int, b: Int): Int = Boolean match {
    case _ if (b == 0) => a
    case _ if (a >= b && b > 0) => gcd(b, a % b)
    case _ => gcd(b, a)
  }

}
