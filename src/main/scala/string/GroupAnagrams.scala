package string

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object GroupAnagrams {
  def groupAnagrams(strs: Array[String]): List[List[String]] = {
    strs.groupBy(_.sorted).values.map(_.toList).toList
  }

  import java.util

  def groupAnagrams1(strs: Array[String]): Iterable[ArrayBuffer[String]] = {
    val res = new util.ArrayList[AnyRef]
    val map = new mutable.HashMap[String,ArrayBuffer[String]]
    for (s <- strs) {
      map += (helper(s) -> ArrayBuffer[String]())
    }
    for (s <- strs) {
      map(helper(s)) += s
    }
    map.values
  }

  def helper(str: String): String = {
    val buffer = new StringBuffer
    val chars = str.toCharArray
    util.Arrays.sort(chars)
    for (c <- chars) {
      buffer.append(c)
    }
    buffer.toString
  }
}
