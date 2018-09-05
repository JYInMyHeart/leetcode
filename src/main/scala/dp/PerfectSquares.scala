package dp

object PerfectSquares extends App {
  def numSquares(n: Int): Int = {
//    math.sqrt(n).toInt
    val x = math.sqrt(n).toInt
    val dp = Array.fill[Int](n + 1)(Int.MaxValue)
    dp(0) = 0
    for(j <- 1 to n){
      var i = 1
      while(i * i <= j){
        dp(j) = math.min(dp(j),dp(j - i * i) + 1)
        i += 1
      }
    }
    dp(n)
  }

  println(numSquares(12))
  println(numSquares(13))
}
