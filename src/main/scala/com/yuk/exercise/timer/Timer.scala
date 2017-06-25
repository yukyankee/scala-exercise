package com.yuk.exercise.timer

import java.time.{Clock, Duration, Instant}

/**
  * 5
  * Created by wmekareeya on 12/7/2016 AD.
  */
object Timer {

  def timeInternal[A](block: => A) = {
    val t0 = System.nanoTime()
    val result = block //this will run the code in block
    val elapsed = (System.nanoTime() - t0)

    println(s"Elapsed time: $elapsed ns")
    (result, elapsed)
  }

  def timeit[F](block: => F) = timeInternal(block)._1

  /*
  def timeit[F](block: => F): F = {
    val t1 = System.nanoTime()
    val result = block//call the method
    val t2 = System.nanoTime()
    println("Elapsed time: " + (t2 - t1) + " ns OR " + (t2 - t1)/1000000.0 + " ms")
    result
  }
  */

  /*
  case class T1(clock: Clock)
  case class T2(clock: Clock)

  def timeit[F](block: => F)(implicit t1: T1, t2: T2): F = {
    val start = Instant.now(t1.clock)
    val result = block //call the method
    val end = Instant.now(t2.clock)
    println("Elapsed time: " + Duration.between(start, end).toMillis + " ms")
    result
  }*/

}
