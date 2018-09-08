package dp

object IsSubsequence extends App {
  def isSubsequence(s: String, t: String): Boolean = {
    var i = 0
    var j = 0
    while(i < s.length && j < t.length){
      if(s.charAt(i) == t.charAt(j)){
        i += 1
        j += 1
      }else{
        j += 1
      }
    }
    if(i == s.length) true else false
  }

  isSubsequence("abc","ahbgdc")
}
