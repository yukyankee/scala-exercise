package com.yuk.exercise.retry

import scala.util.{Failure, Success, Try}

/**
  * 13
  * Created by wmekareeya on 11/30/2016 AD.
  */
class Retry {

  val SLEEP_DURATION = 1000l;

  /**
    * Retry for n times. When n is reached, throws the error if any.
    *
    * @param fn
    * @param n     implicit number of retry
    * @param sleep implicit flag if pausing is to be done
    * @tparam T
    * @return
    */
  def retry[T](fn: => T)(implicit n: Int, sleep: Boolean): Try[(T, Int)] = {
    try {
      Success(fn, n)
    } catch {
      case e: Throwable =>
        if (n > 0) {
          println("Retry " + n + " left")
          if (sleep) {
            Thread.sleep(SLEEP_DURATION)
          }
          retry(fn)(n - 1, sleep)
        }
        else
          Failure(e)
    }
  }
}
