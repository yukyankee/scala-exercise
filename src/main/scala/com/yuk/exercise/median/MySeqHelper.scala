package com.yuk.exercise.median

/**
  * 15
  * Created by wmekareeya on 11/30/2016 AD.
  */
object MySeqHelper {

  //default ordering
  implicit val ord = Ordering.Int

  implicit class MySeq[T](numbers: Seq[T]) {

    def median()(implicit ord: Ordering[T]): Option[Double] = numbers.isEmpty match {

      case true => None
      case false => {
        if (numbers.size == 1)
          Some(numbers(0)).asInstanceOf[Option[Double]]

        val sortedNumbers = numbers.sorted.map(_.toString.toDouble)
        val middle = sortedNumbers.size / 2

        //test if it's even
        numbers.size % 2 match {
          case 0 => Option((sortedNumbers(middle - 1) + sortedNumbers(middle)) / 2.0)
          case _ => Option(sortedNumbers(middle))
        }

      }
    }

    /*
    def median()(implicit ord: Ordering[T]): Option[Double] = {

      if (numbers.isEmpty) {
        return None
      }
      else if (numbers.size == 1) {
        return Some(numbers(0)).asInstanceOf[Option[Double]]
      }

      val sortedNumbers = numbers.sorted.map(_.toString.toDouble)

      val middle = sortedNumbers.size / 2

      //if it's even
      if (numbers.size % 2 == 0) {
        val left = sortedNumbers(middle - 1)
        val right = sortedNumbers(middle)

        return Some((left + right) / 2).asInstanceOf[Option[Double]]
      }
      else {
        return Some(sortedNumbers(middle)).asInstanceOf[Option[Double]]
      }
    }
    */
  }

}
