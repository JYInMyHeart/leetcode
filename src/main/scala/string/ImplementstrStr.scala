package string

object ImplementstrStr {
  def strStr(haystack: String, needle: String): Int = {
    for(i <- 0 until Int.MaxValue){
      var j = 0
      var break = true
      while(break && j < Int.MaxValue){
        if(j == needle.length) return i
        if(i + j == haystack.length) return -1
        if(haystack.charAt(i + j) != needle.charAt(j))
          break = false
        j += 1
      }
    }
    0
  }
  new String().indexOf()
}
