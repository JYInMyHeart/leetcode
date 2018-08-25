package dp

object MinimumASCIIDeleteSumforTwoStrings extends App {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    val m = s1.length
    val n = s2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for (i <- 0 until m + 1) {
      for (j <- 0 until n + 1) {
        if (i == 0 || j == 0) {
          dp(i)(j) = if(i == 0) s2.take(j).sum else s1.take(i).sum
        } else if (s1(i - 1) == s2(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1)
        } else {
          dp(i)(j) = math.min(dp(i - 1)(j) + s1(i - 1), dp(i)(j - 1) + s2(j - 1))
          dp(i)(j) = math.min(dp(i - 1)(j - 1) + s1(i - 1) + s2(j - 1), dp(i)(j))
        }
      }
    }
    dp(m)(n)
  }


  println(minimumDeleteSum("delete", "leet"))
  //  println(minimumDeleteSum("sea", "eat"))

}
