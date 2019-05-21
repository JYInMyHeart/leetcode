package array

object LongestPalindromicSubstring {
  def longestPalindrome(s: String): String = {
    var left = 0
    var maxlen = 0
    def getPalinedromicIndex(s:String, start:Int, end:Int):Unit = {
      var st = start
      var en = end
      while(st >= 0 && en < s.length && s.charAt(st) == s.charAt(en)){
        st -= 1
        en += 1
      }
      if(maxlen < en - st - 1){
        left = st + 1
        maxlen = en - st - 1
      }
    }
    if(s.length <= 1) return s
    for(i <- 1 until s.length){
      getPalinedromicIndex(s,i - 1,i)
      getPalinedromicIndex(s,i - 1,i - 1)
    }
    s.substring(left,left + maxlen)
  }

  def main(args: Array[String]): Unit = {
//    println(longestPalindrome("zyabyz").length)
//    println(longestPalindrome("aa").length)
    println(longestPalindrome("aab").length)
//    println(longestPalindrome("aab").length)
//    println(longestPalindrome("baabcd").length)
//    println(longestPalindrome("baablkj12345432133d").length)
  }
}
