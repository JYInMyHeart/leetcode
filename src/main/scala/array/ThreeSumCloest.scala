package array

object ThreeSumCloest {
  def threeSumClosest(nums: Array[Int], target: Int): Int = {
    val num = nums.sorted
    var min = num(0) + num(1) + num(num.length - 1)
    for (i <- 0 until num.length - 1) {
      var lo = i + 1
      var hi = num.length - 1

      while (lo < hi) {
        val sum = num(i) + num(lo) + num(hi)
        if(sum > target)
          hi -= 1
        else
          lo += 1
        if(math.abs(sum - target) < math.abs(min - target))
          min = sum
      }
    }
    min
  }
}
