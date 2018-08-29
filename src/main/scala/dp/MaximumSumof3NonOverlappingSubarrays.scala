package dp

object MaximumSumof3NonOverlappingSubarrays {
  def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
    val n = nums.length
    var maxsum = 0
    val sum = Array.ofDim[Int](n + 1)
    val posLeft = Array.ofDim[Int](n)
    val posRight = Array.ofDim[Int](n)
    val ans = Array.ofDim[Int](3)
    var i = 0
    while (i < n) sum(i + 1) = sum(i) + nums(i) {
      i += 1
      i - 1
    }
    // DP for starting index of the left max sum interval
    i = k
    var tot = sum(k) - sum(0)
    while (i < n) {
      if (sum(i + 1) - sum(i + 1 - k) > tot) {
        posLeft(i) = i + 1 - k
        tot = sum(i + 1) - sum(i + 1 - k)
      }
      else posLeft(i) = posLeft(i - 1)
      i += 1
    }
    // DP for starting index of the right max sum interval
    // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
    posRight(n - k) = n - k
    i = n - k - 1
    tot = sum(n) - sum(n - k)
    while (i >= 0) {
      if (sum(i + k) - sum(i) >= tot) {
        posRight(i) = i
        tot = sum(i + k) - sum(i)
      }
      else posRight(i) = posRight(i + 1)
      i -= 1
    }
    // test all possible middle interval
    i = k
    while (i <= n - 2 * k) {
      val l = posLeft(i - 1)
      val r = posRight(i + k)
      val tot = (sum(i + k) - sum(i)) + (sum(l + k) - sum(l)) + (sum(r + k) - sum(r))
      if (tot > maxsum) {
        maxsum = tot
        ans(0) = l
        ans(1) = i
        ans(2) = r
      }
      i += 1
    }
    ans
  }

  maxSumOfThreeSubarrays(Array(1, 2, 1, 2, 6, 7, 5, 1), 2)
}
