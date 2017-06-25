package com.yuk.exercise.timer

import java.time.{Clock, Duration, Instant, ZoneId}

import com.yuk.exercise.vector.VectorCalculator
import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 12/7/2016 AD.
  */
class TimerTest extends FunSuite {


  /*
  test("measure vector calculation time") {
    implicit val t1: Timer.T1 = Timer.T1(Clock.systemDefaultZone())
    implicit val t2: Timer.T2 = Timer.T2(Clock.systemDefaultZone())

    val z = Timer.timeit {
      val calculator = new VectorCalculator(Vector(4, 9, 23, 53, 71))
      calculator.z
    }
    assertResult(92.06519429187124)(z)
  }

  test("measure vector calculation time when using mocked time") {
    implicit val t1: Timer.T1 = Timer.T1(Clock.fixed(Instant.now(),ZoneId.systemDefault()))
    implicit val t2: Timer.T2 = Timer.T2(Clock.offset(t1.clock,Duration.ofMillis(10L)))

    val z = Timer.timeit {
      val calculator = new VectorCalculator(Vector(4, 9, 23, 53, 71))
      calculator.z
    }
    assertResult(92.06519429187124)(z)
    case class a(b:Int, c:Int)
  }
  */

  test("measure time") {

    val sleepTime = 750
    val start = System.nanoTime()

    val functionTime = Timer.timeInternal {
      Thread.sleep(sleepTime)
    }._2
    val upperBound = System.nanoTime() - start

    assert(functionTime >= sleepTime)
    assert(functionTime <= upperBound)
  }

  test("run the timeit function") {
    val sleepTime = 750

    Timer.timeit {
      Thread.sleep(sleepTime)
    }
  }

  /*
  test("measure vector calculation time when using mocked time") {

    val z = Timer.timeit {
      val calculator = new VectorCalculator(Vector(4, 9, 23, 53, 71))
      calculator.z
    }
    assertResult(92.06519429187124)(z)
  }*/

}
