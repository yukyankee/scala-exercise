package com.yuk.exercise.set

/**
  * 7
  * Created by wmekareeya on 11/29/2016 AD.
  */
class NonEmptySet(val elem: Int, val left: IntSet, val right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = {
    if (x < elem)
      left contains x
    else if (x > elem)
      right contains x
    else
      true
  }

  def incl(x: Int): IntSet = {
    if (x < elem)
      new NonEmptySet(elem, left incl x, right)
    else if (x > elem)
      new NonEmptySet(elem, left, right incl x)
    else
      this
  }

  //Yuk's excl
  /*
  def excl(x: Int): IntSet = {
    if (x < elem)
      new NonEmptySet(elem, left excl x, right)
    else if (x > elem)
      new NonEmptySet(elem, left, right excl x)
    else if(x == elem) {


      if(left.isInstanceOf[NonEmptySet]){
        val newElem = left.asInstanceOf[NonEmptySet].elem
        new NonEmptySet(newElem, left excl newElem, right)
      } else if(right.isInstanceOf[NonEmptySet]){
        val newElem = right.asInstanceOf[NonEmptySet].elem
        new NonEmptySet(newElem, left, right excl newElem)
      } else {
        new EmptySet
      }
    }
    else
      new EmptySet
  }
  */

  def excl(x: Int): IntSet = {
    if (x == elem) {
      if (left.isEmpty)
        right
      else if (right.isEmpty)
        left
      else if (!right.isEmpty && !left.isEmpty)
        right union left
      else new
          EmptySet
    }
    else if (x < elem)
      new NonEmptySet(elem, left excl x, right)
    else if (x > elem)
      new NonEmptySet(elem, left, right excl x)
    else
      new EmptySet
  }

  def union(x: IntSet): IntSet = {
    (left) union (right) union (x.incl(elem))
  }

  def intersect(x: IntSet): IntSet = {

    if (x.isEmpty) {
      new EmptySet
    }
    else if (x.contains(elem)) {
      //elem must be in the answer
      new NonEmptySet(elem, new EmptySet, new EmptySet).union(x.intersect(left.union(right)))
    }
    else {
      //deleting this elem
      x.intersect(right.union(left))
    }
  }

  def isEmpty(): Boolean = false

  override def toString: String = "( " + elem + ", " + left.toString + ", " + right.toString + "" + " )"


}
