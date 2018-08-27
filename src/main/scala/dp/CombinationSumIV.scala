package dp

object CombinationSumIV extends App {
  def combinationSum4(nums: Array[Int], target: Int): Int = {
    val n = nums.length
    val dp = Array.fill[Int](target + 1)(0)
    dp(0) = 1
    for (j <- 1 to target) {
      for (i <- nums.indices) {
        if (j >= nums(i)) {
          dp(j) += dp(j - nums(i))
        }
      }
    }
    dp(target)
  }

  println(combinationSum4(Array(1, 2, 3), 4))
}
