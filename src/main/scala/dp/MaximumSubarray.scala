package dp

object MaximumSubarray extends App {
  def maxSubArray(nums: Array[Int]): Int = {
    val n = nums.length
    if(n == 0) return 0
    val dp = Array.ofDim[Int](n)
    dp(0) = nums(0)
    for(i <- 1 until n){
      dp(i) = math.max(dp(i - 1) + nums(i),nums(i))
    }
    dp.foreach(print)
    println()
    dp.max
  }

  println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}
