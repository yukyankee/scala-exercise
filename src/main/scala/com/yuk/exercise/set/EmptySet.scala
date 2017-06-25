package com.yuk.exercise.set

/**
  * 7
  * Created by wmekareeya on 11/29/2016 AD.
  */
class EmptySet extends IntSet {
  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)

  def excl(x: Int): IntSet = new EmptySet

  def isEmpty(): Boolean = true

  def union(x: IntSet): IntSet = x

  def intersect(x: IntSet): IntSet = new EmptySet

  def canEqual(a: Any) = a.isInstanceOf[EmptySet]

  override def equals(that: Any): Boolean =
    that match {
      case that: EmptySet => this.canEqual(that)
      case _ => false
    }

  override def toString: String = "( e )"
}
