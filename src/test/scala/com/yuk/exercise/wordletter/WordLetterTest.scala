package com.yuk.exercise.wordletter

import org.scalatest.FunSuite

/**
  * Created by wmekareeya on 11/24/2016 AD.
  */
class WordLetterTest extends FunSuite {

  val wordLetter = new WordLetter()

  test("longestWord happy path") {
    assertResult("extensibility,")(wordLetter.longestWord("Have the best of both worlds. Construct elegant " +
      "class hierarchies for maximum code reuse and extensibility, implement their behavior using higher-order functions. Or anything in-between."))
  }

  test("longestWord when there is one word") {
    assertResult("scala")(wordLetter.longestWord("scala"))
  }

  test("longestWord when it is empty") {
    assertResult("")(wordLetter.longestWord(""))
  }

  test("mostCommonWord happy path") {
    assertResult("scala")(wordLetter.mostCommonWord("Scala is an acronym for Scalable Language. This means that Scala grows with you."))
  }

  test("mostCommonWord when there is one word") {
    assertResult("hello")(wordLetter.mostCommonWord("hello"))
  }

  test("mostCommonWord when it is empty") {
    assertResult("")(wordLetter.mostCommonWord(""))
  }

  test("mostCommonLetter happy path") {
    assertResult("a")(wordLetter.mostCommonLetter("Scala is an acronym for Scalable Language. This means that Scala grows with you."))
  }

  test("mostCommonLetter when there is one letter") {
    assertResult("l")(wordLetter.mostCommonLetter("l"))
  }

  test("mostCommonLetter when it is empty") {
    assertResult("")(wordLetter.mostCommonLetter(""))
  }

  test("dictionary happy path") {
    val expected = Map('e' -> Set("scalable", "language.", "means"),
      's' -> Set("this", "is", "scalable", "scala", "means", "grows"),
      'n' -> Set("an", "acronym", "language.", "means"),
      '.' -> Set("language.", "you."),
      'y' -> Set("acronym", "you."),
      't' -> Set("this", "that", "with"),
      'u' -> Set("language.", "you."),
      'f' -> Set("for"),
      'a' -> Set("acronym", "scalable", "that", "scala", "means", "language.", "an"),
      'm' -> Set("acronym", "means"),
      'i' -> Set("is", "this", "with"),
      'b' -> Set("scalable"),
      'g' -> Set("language.", "grows"),
      'l' -> Set("scala", "scalable", "language."),
      'c' -> Set("scala", "acronym", "scalable"),
      'h' -> Set("this", "that", "with"),
      'r' -> Set("acronym", "for", "grows"),
      'w' -> Set("grows", "with"),
      'o' -> Set("acronym", "for", "grows", "you."))

    //println(wordLetter.getDictionary("Scala is an acronym for Scalable Language. This means that Scala grows with you."))
    assertResult(expected)(wordLetter.getDictionary("Scala is an acronym for Scalable Language. This means that Scala grows with you."))
  }

  test("getAllChar happy path") {
    val expected = Seq('s', 'c', 'a', 'l', 'a', 's', 'c', 'a', 'l', 'a', 'b', 'l', 'e', 'l', 'a', 'n', 'g', 'u', 'a', 'g', 'e')

    //assert(expected === (wordLetter.getAllChar(Seq("scala", "scalable", "language"))))

    assertResult(expected)(wordLetter.getAllChar(Seq("scala", "scalable", "language")))
  }

}
