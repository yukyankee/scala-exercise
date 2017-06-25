package com.yuk.exercise.wordletter

import scala.collection.mutable

/**
  * 6 & 7
  * Created by wmekareeya on 11/24/2016 AD.
  */
class WordLetter {

  //6a
  def longestWord(paragraph: String): String = {

    paragraph.split(" ").maxBy(w => w.length)

    //paragraph.split(" ").reduce((x, y) => if (x.length > y.length) x else y)
  }

  //6b
  def mostCommonWord(paragraph: String): String = {

    //foldLeft cannot be parallelized
    /*
        paragraph.toLowerCase.split(" ")
          .foldLeft(Map.empty[String, Int]) {
            (map, word) => map + (word -> (map.getOrElse(word, 0) + 1))
          }.maxBy(_._2)._1
    */

    paragraph.toLowerCase.split(" ")
      .groupBy(w => w)
      .maxBy(p => p._2.length)._1
  }

  //6c
  def mostCommonLetter(paragraph: String): String = {

    paragraph.toLowerCase.split("").filterNot(_.equals(" "))
      .groupBy(l => l)
      .maxBy(p => p._2.length)._1


    /*
    val letters = paragraph.split("").filterNot(_.equals(" ")).map(_.toLowerCase())

    letters.foldLeft(Map.empty[String, Int]) {
      (map, letter) => map + (letter -> (map.getOrElse(letter, 0) + 1))
    }.maxBy(_._2)._1
    */
  }

  /**
    * 6d
    * Create a map from letter to a set of words it appear in
    *
    * @param paragraph
    * @return map
    */
  def getDictionary(paragraph: String): Map[Char, Set[String]] = {

    //"map" changes data structure from one to another

    val strList = paragraph.toLowerCase.split(" ")
    val charList = strList.flatten.distinct
    charList.map(c => (c -> strList.filter(_.contains(c)).toSet)).toMap

    //path's way, still wrong
    //paragraph.toLowerCase.toSeq.filterNot(x => x.equals(" ")).distinct.map(c => c -> paragraph.toLowerCase.split(" ").filter(_.contains(c)).toSet).toMap

    //my way back then
    /*
    val words = paragraph.split(" ").map(_.toLowerCase())
    var lettersMap = mutable.Map.empty[Char, Set[String]]

    for (word <- words) {

      val letters = word.toList

      //map + (l -> Set(word)) is map + (new key -> new value)
      val newEntries = letters.foldLeft(Map.empty[Char, Set[String]])((map, l) => map + (l -> Set(word)))


      for (entry <- newEntries) {
        if (lettersMap.contains(entry._1)) {

          val newSet = lettersMap.getOrElse(entry._1, Set.empty[String]) ++ entry._2
          lettersMap = lettersMap + (entry._1 -> newSet)

        } else {

          lettersMap = lettersMap + (entry._1 -> entry._2)
        }

      }
    }
    println(lettersMap)

    */
  }

  /**
    * 7
    * converts a list of strings to a list of all the characters in all the strings
    *
    * @param strList
    * @return
    */
  def getAllChar(strList: Seq[String]): Seq[Char] = {
    strList.flatten
  }
}


