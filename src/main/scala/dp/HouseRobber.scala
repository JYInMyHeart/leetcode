package dp

object HouseRobber extends App {
  def rob(nums: Array[Int]): Int = {
    if(nums.isEmpty) return 0
    val n = nums.length
    if(n == 1) return nums(0)
    val dp = Array.ofDim[Int](n)
    dp(0) = nums(0)
    dp(1) = nums(1)
    for (i <- 2 until n) {
      for (j <- 2 to i){
        val t = math.max(dp(i - j) + nums(i), dp(i - 1))
        dp(i) = math.max(dp(i),t)
      }
    }
    math.max(dp(0),dp(n - 1))
  }

//  println(rob(Array(2, 1, 1, 2)))
  println(rob(Array(2, 7, 9, 3,1)))
}
