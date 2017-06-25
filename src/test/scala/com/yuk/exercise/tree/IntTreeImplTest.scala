package com.yuk.exercise.tree

import org.scalatest.{FunSuite, Matchers}

/**
  * 9
  * Created by wmekareeya on 12/2/2016 AD.
  */
class IntTreeImplTest extends FunSuite with Matchers {

  val intTreeImpl = new IntTreeImpl

  test("when there is just the root with the same element") {
    intTreeImpl.contains(Node(3), 3) shouldBe true
  }

  test("when there is just the root with different element") {
    intTreeImpl.contains(Node(8), 3) shouldBe false
  }

  test("when there is no root") {
    intTreeImpl.contains(EmptyTree, 3) shouldBe false
  }

  test("when the element is on the left branch") {
    intTreeImpl.contains(Node(3, Node(2), Node(7)), 2) shouldBe true
  }

  test("when the element is on the right branch") {
    intTreeImpl.contains(Node(6, Node(3), Node(15)), 15) shouldBe true
  }

  test("when the element is on the deeper right branch") {
    val right = Node(7, EmptyTree, Node(15))
    intTreeImpl.contains(Node(6, Node(3), right), 15) shouldBe true
  }

  test("when the element is NOT on any branch") {
    intTreeImpl.contains(Node(15, Node(5), Node(20)), 25) shouldBe false
  }

  test("insert to an empty tree") {
    intTreeImpl.insert(EmptyTree, 30) shouldBe Node(30, EmptyTree, EmptyTree)
  }

  test("insert duplicate element") {
    intTreeImpl.insert(Node(30, EmptyTree, EmptyTree), 30) shouldBe Node(30, EmptyTree, EmptyTree)
  }

  test("insert to a tree with empty left branch") {
    intTreeImpl.insert(Node(10, EmptyTree, Node(13)), 6) shouldBe Node(10, Node(6), Node(13))
  }

  test("insert to a tree with empty right branch") {
    intTreeImpl.insert(Node(7, Node(5), EmptyTree), 30) shouldBe Node(7, Node(5), Node(30))
  }

  test("insert to a tree with empty left and right branch") {
    intTreeImpl.insert(Node(7, EmptyTree, EmptyTree), 21) shouldBe Node(7, EmptyTree, Node(21))
  }

  test("insert to a tree on the second level of branch") {
    intTreeImpl.insert(Node(10, Node(4), Node(21)), 28) shouldBe Node(10, Node(4), Node(21, EmptyTree, Node(28)))
  }

}
