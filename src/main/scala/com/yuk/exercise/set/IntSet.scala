package com.yuk.exercise.set

/**
  * 7
  * Created by wmekareeya on 11/29/2016 AD.
  */
trait IntSet {
  def incl(x: Int): IntSet

  def contains(x: Int): Boolean

  def excl(x: Int): IntSet

  def isEmpty(): Boolean

  def union(x: IntSet): IntSet

  def intersect(x: IntSet): IntSet
}
