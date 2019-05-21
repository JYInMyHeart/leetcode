package dp

object CoinChangeII extends App{
  def coinChange(nums:Array[Int],target:Int):Int = {
    val n = nums.length
    val dp = Array.fill[Int](target + 1)(0)
    dp(0) = 1
    for (i <- nums.indices) {
    for (j <- 1 to target) {
        if (j >= nums(i)) {
          dp(j) += dp(j - nums(i))
        }
      }
    }
    dp(target)
  }

  println(coinChange(Array(1, 2, 5), 5))
  println(coinChange(Array(1,2,3,4), 6))
  println(coinChange(Array(10), 10))
  println(coinChange(Array(2), 3))



}
