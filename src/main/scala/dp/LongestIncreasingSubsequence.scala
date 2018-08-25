package dp

object LongestIncreasingSubsequence extends App {
  def lengthOfLIS(nums: Array[Int]): Int = {
    if(nums.isEmpty) return 0
    val n = nums.length
    val dp = Array.fill[Int](n + 1)(1)
    for(i <- 1 until n){
      for(j <- 0 until i){
        if(nums(i) > nums(j)){
          dp(i) = math.max(dp(i),dp(j) + 1)
        }
      }
    }
    dp.max
  }

  println(lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18)))
}
