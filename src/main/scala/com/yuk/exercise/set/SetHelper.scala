package com.yuk.exercise.set

/**
  * 7
  * Created by wmekareeya on 11/29/2016 AD.
  */
class SetHelper {

  /*
  def union(x: IntSet, y: IntSet): IntSet = {

    //println("x is " + x.toString)
    //println("y is " + y.toString)

    if (x.isInstanceOf[NonEmptySet]) {

      if (y.isInstanceOf[NonEmptySet]) {
        val xElem = x.asInstanceOf[NonEmptySet].elem
        val yElem = y.asInstanceOf[NonEmptySet].elem

        if (y.contains(xElem)) {
          //intersect
          //println("y contains xElem " + xElem)
          union(x.excl(xElem), y.excl(xElem)).incl(xElem)
        }
        else {
          union(x.excl(xElem), y).incl(xElem)
        }
      }
      else {
        x
      }

    } else {
      if (y.isInstanceOf[NonEmptySet]) {
        y
      }
      else {
        new EmptySet
      }
    }
  }
  */

  /*
  def intersect(x: IntSet, y: IntSet): IntSet = {

    if (x.isInstanceOf[NonEmptySet] && y.isInstanceOf[NonEmptySet]) {
      val xElem = x.asInstanceOf[NonEmptySet].elem
      val yElem = y.asInstanceOf[NonEmptySet].elem
      //println("x is now "+x.toString)
      //println("y is now "+y.toString)
      if (y.contains(xElem)) {
        //println("xElem is now "+xElem)
        intersect(x.excl(xElem), y.excl(yElem)).incl(xElem)
      }
      else {
        intersect(x.excl(xElem), y)
      }
    } else {
      new EmptySet
    }

  }*/

  def setEquals(thisSet: IntSet, thatSet: IntSet): Boolean = {

    if (!thisSet.getClass().equals(thatSet.getClass)) {
      return false
    }

    if (thisSet.isInstanceOf[NonEmptySet]) {
      val thisNonEmptySet = thisSet.asInstanceOf[NonEmptySet]

      if (thatSet.isInstanceOf[NonEmptySet]) {
        val thatNonEmptySet = thatSet.asInstanceOf[NonEmptySet]
        val elemComparison = thisNonEmptySet.elem == thatNonEmptySet.elem
        val leftComparison = setEquals(thisNonEmptySet.left, thatNonEmptySet.left)
        val rightComparison = setEquals(thisNonEmptySet.right, thatNonEmptySet.right)
        //println("compare result = " + elemComparison + " " +leftComparison + " " + rightComparison)
        return elemComparison && leftComparison && rightComparison
      }
      else {
        return false
      }
    }
    else {
      if (thatSet.isInstanceOf[EmptySet]) {
        return true
      } else {
        return false
      }
    }

  }

}
