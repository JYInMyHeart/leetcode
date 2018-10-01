package String

import scala.collection.mutable

object LongestSubstringWithoutRepeatingCharacters {
  def lengthOfLongestSubstring(s: String): Int = {
    var i = 0
    var j = 0
    var max = 0
    val n = s.length
    val set = new mutable.HashSet[Char]()
    while(i < n && j < n){
      if(!set.contains(s.charAt(j))){
        set.+=(s.charAt(j))
        max = math.max(max,j - i + 1)
        j += 1
      }else{
        set -= s.charAt(i)
        i += 1
      }
    }
    max
  }
  def lengthOfLongestSubstring1(s: String): Int = {
    val map = new mutable.HashMap[Char,Int]()
    var j = 0
    var max = 0
    for(i <- s.indices){
      if(map.contains(s.charAt(i))){
        j = math.max(map(s.charAt(i)),j)
      }
      max = math.max(max,i - j + 1)
      map += s.charAt(i) -> (i + 1)
    }
    max
  }
}
