package dp

object UniquePaths {
  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.fill[Int](m ,n )(1)
    for(i <- 1 until m){
      for(j <- 1 until n){
        dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
      }
    }
    dp(m - 1)(n - 1)
  }
}
