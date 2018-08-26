package dp

object LongestPalindromicSubsequence extends App {
  def longestPalindromeSubseq(s: String): Int = {
    val n = s.length
    val dp  = Array.ofDim[Int](n,n )
    var i = n - 1
    dp(0)(0) = 1
    while(i >= 0 ){
      dp(i)(i) = 1
      for(j <- i + 1 until n){
        if(s.charAt(i) == s.charAt(j)){
          dp(i)(j) = dp(i + 1)(j - 1) + 2
        }else{
          dp(i)(j) = math.max(dp(i + 1)(j),dp(i)(j - 1))
        }
      }
      i -= 1
    }
    dp(0)(n - 1)
  }

  println(longestPalindromeSubseq("bbbab"))

}
