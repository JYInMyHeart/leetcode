package array

object MaximumSubarray extends App {
  def maxSubArray(nums: Array[Int]): Int = {
    var cur = nums(0)
    var res = nums(0)
    var j = 1
    val n = nums.length
    while (j < n) {
      cur = math.max(cur + nums(j), nums(j))
      res = math.max(cur, res)
      j += 1
    }
    res
  }

  println(maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}
