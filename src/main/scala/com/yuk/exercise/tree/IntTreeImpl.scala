package com.yuk.exercise.tree

/**
  * 9
  * Created by wmekareeya on 12/2/2016 AD.
  */
class IntTreeImpl {

  def contains(t: IntTree, v: Int): Boolean = t match {
    case n: Node if v < n.elem => contains(n.left, v)
    case n: Node if v > n.elem => contains(n.right, v)
    case EmptyTree => false
    case _ => true
  }

  def insert(t: IntTree, v: Int): IntTree = t match {
    case EmptyTree => Node(v, EmptyTree, EmptyTree)
    case n: Node if v < n.elem => Node(n.elem, insert(n.left, v), n.right)
    case n: Node if v > n.elem => Node(n.elem, n.left, insert(n.right, v))
    case _ => t
  }

  //Yuk's
  /*
  //assuming the branch is unsorted
  def contains(t: IntTree, v: Int): Boolean = t match {

    case _ if(t.isInstanceOf[Node] && v == t.asInstanceOf[Node].elem) => true
    case _ if(t.isInstanceOf[Node]) => contains(t.asInstanceOf[Node].left, v) || contains(t.asInstanceOf[Node].right, v)
    case _ => false
  }
  */

  /*
  def insert(t: IntTree, v: Int): IntTree = t match {

    case _ if(!t.isInstanceOf[Node]) => new Node(v, EmptyTree, EmptyTree)

      //if left is empty then put on left
    case _ if(isEmpty(t.asInstanceOf[Node].left) && !isEmpty(t.asInstanceOf[Node].right)) =>
      new Node(t.asInstanceOf[Node].elem, insert(EmptyTree, v), t.asInstanceOf[Node].right)

    //if right is empty then put on right
    case _ if(!isEmpty(t.asInstanceOf[Node].left) && isEmpty(t.asInstanceOf[Node].right)) =>
      new Node(t.asInstanceOf[Node].elem, t.asInstanceOf[Node].left, insert(EmptyTree, v))

    //if both are empty then put on left
    case _ if(isEmpty(t.asInstanceOf[Node].left) && isEmpty(t.asInstanceOf[Node].right)) =>
      new Node(t.asInstanceOf[Node].elem, insert(EmptyTree, v), EmptyTree)

    //if both are full then go to left branch
    case _ if(!isEmpty(t.asInstanceOf[Node].left) && !isEmpty(t.asInstanceOf[Node].right)) =>
      new Node(t.asInstanceOf[Node].elem, insert(t.asInstanceOf[Node].left, v), t.asInstanceOf[Node].right)
  }*/

  /*
  def isEmpty(t: IntTree): Boolean = t match {
    case EmptyTree => true
    case _ => false
  }*/
}
