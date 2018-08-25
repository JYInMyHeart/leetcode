package dp

object DeleteandEarn extends App{
  def deleteAndEarn(nums: Array[Int]): Int = {
    val dp = Array.ofDim[Int](10001)
    val sum = Array.ofDim[Int](10001)
    for(i <- nums){
      sum(i) += i
    }

    dp(1) = sum(1)
    for(i <- 2 until dp.length){
      dp(i) = math.max(sum(i) + dp(i -  2),dp(i - 1))
    }
    dp(10000)
  }

  println(deleteAndEarn(Array(3, 4, 2)))
}
