package array

object JumpGameII {
  def jump(nums: Array[Int]): Int = {
    var maxReach = nums(0)
    var edge = 0
    var minSteps = 0
    for (i <- 1 until nums.length) {
      if (i > edge) {
        minSteps += 1
        edge = maxReach
        if (edge > nums.length - 1) {
          return minSteps
        }
      }
      maxReach = math.max(maxReach, nums(i) + i)
    }
    minSteps
  }

  def main(args: Array[String]): Unit = {
    println(jump(Array(0, 0, 0, 0, 0)))
  }
}
