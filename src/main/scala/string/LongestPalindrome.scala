package string

import scala.collection.mutable

object LongestPalindrome {
  def longestPalindrome(s: String): Int = {
    val map = mutable.HashMap[Char,Int]()
    s.foreach{
      case x if map.contains(x) =>
        map += x -> (map(x) + 1)
      case x =>
        map += x -> 1
    }
    val even = map.filter(_._2 % 2 == 0).values.sum
    val odd = map.filter(_._2 % 2 != 0).map(_._2 / 2 * 2).sum
    if(map.exists(_._2 % 2 != 0))
    even + odd + 1
    else
      even + odd
  }
}
