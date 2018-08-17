package array

object NumberofMatchingSubsequences extends App {
  def numMatchingSubseq(S: String, words: Array[String]): Int = {
    def compareStr(l:String,r:String) = {
      var i = 0
      var j = 0
      val ll = l.toCharArray
      var rr = r.toCharArray
      while(i < rr.length && j < ll.length){
        if(ll(j) == rr(i)){
          i += 1
          j += 1
        }else{
          j += 1
        }
      }
      if(i == rr.length) true else false
    }
    var count = 0
    for(s <- words){
      if(compareStr(S,s)){
        count += 1
      }
    }
    count
  }

  val a = Array("a", "bb", "acd", "ace")
  val s = "abcde"
//  println(compareStr(s, "ace"))
  println(numMatchingSubseq(s, a))
}
