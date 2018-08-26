package dp

object NumberofLongestIncreasingSubsequence extends App {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    val n = nums.length
    val dp = Array.fill[Int](n)(1)
    val count = Array.fill[Int](n)(1)
    for (i <- 1 until n) {
      for (j <- 0 until i) {
        if (nums(i) > nums(j)) {
          if (dp(i) <= dp(j)) {
            dp(i) = dp(j) + 1
            count(i) = count(j)
          } else if(dp(j) + 1 == dp(i)){
            count(i) += count(j)
          }

        }
      }
    }
    var res = 0
      for(i <- dp.indices){
        if(dp(i) == dp.max)
          res += count(i)
      }
    res

  }

  println(findNumberOfLIS(Array(1, 3, 5, 4, 7)))
  println(findNumberOfLIS(Array(2, 2, 2, 2, 2)))
}
