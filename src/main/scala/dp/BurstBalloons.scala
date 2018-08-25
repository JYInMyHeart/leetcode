package dp

object BurstBalloons extends App{
  def maxCoins(nums: Array[Int]): Int = {
    var len = 1 :: nums.toList
    len :+= 1
    val n = nums.length
    val dp = Array.ofDim[Int](n + 2,n + 2)
    for(l <- 1 until n + 2){
      for(i <- 1 to  n - l + 1){
        var j = i + l - 1
        for(k <- i to j){
          dp(i)(j) = math.max(dp(i)(j),dp(i)(k - 1) + dp(k + 1)(j) + len(i - 1) * len(j + 1) * len(k))
        }
      }
    }
    dp(1)(n)
  }

  println(maxCoins(Array(3, 4 ,2)))
}
