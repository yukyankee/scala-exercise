package com.yuk.exercise.retry

import java.io.FileNotFoundException

import org.scalatest.FunSuite
import org.mockito.Mockito._

/**
  * Created by wmekareeya on 11/30/2016 AD.
  */
class RetryTest extends FunSuite {

  val retryRunner = new Retry

  test("should run once because it succeeds at the first time") {

    //supplying the arguments explicitly
    val result = retryRunner.retry {
      println("a")
    }(3, false)

    assert(result.isSuccess)
    assert(result.get._2 === 3)
  }


  test("should retry 5 times and sleep between retries") {

    implicit val n = 5
    implicit val sleep = true
    val result = retryRunner.retry {
      scala.xml.XML.loadFile("/Users/test/not-exist.xml")
    }
    assert(result.isFailure)
    assert(result.failed.get.isInstanceOf[FileNotFoundException])

  }
}


