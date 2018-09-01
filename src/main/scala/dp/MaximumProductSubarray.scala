package dp

object MaximumProductSubarray extends App {
  def maxProduct(nums: Array[Int]): Int = {
    if (nums == null || (nums.length == 0)) return 0
    val f = Array.ofDim[Int](nums.length)
    val g = Array.ofDim[Int](nums.length)
    f(0) = nums(0)
    g(0) = nums(0)
    var res = nums(0)
    var i = 1
    while (i < nums.length) {
      f(i) = Math.max(Math.max(f(i - 1) * nums(i), g(i - 1) * nums(i)), nums(i))
      g(i) = Math.min(Math.min(f(i - 1) * nums(i), g(i - 1) * nums(i)), nums(i))
      res = Math.max(res, f(i))
      i += 1
    }
    res
  }

  println(maxProduct(Array(2, 3, -2, 4)))
}
