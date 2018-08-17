package array

object NumberofMatchingSubsequences extends App {
  def numMatchingSubseq(S: String, words: Array[String]): Int = {
    var res = 0
    for(c <- words){
      var count = 0
      for(cc <- c){
        for(s <- S){
          if(cc == s){
            count += 1
          }
        }
      }
      if(count == c.length){
        res += 1
      }
    }
    res
  }
  val a = Array("a", "bb", "acd", "ace")
  val s = "abcde"
  println(numMatchingSubseq(s, a))
}
