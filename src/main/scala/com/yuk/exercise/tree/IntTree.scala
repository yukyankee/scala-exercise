package com.yuk.exercise.tree

/**
  * 9
  * Created by wmekareeya on 11/29/2016 AD.
  */
abstract class IntTree

case object EmptyTree extends IntTree

case class Node(elem: Int, left: IntTree = EmptyTree, right: IntTree = EmptyTree) extends IntTree

