package array

object CanJump {
  def canJump(nums: Array[Int]): Boolean = {
    var max = 0
    var i = 0
    while (i < nums.length) {
      if (i > max) return false
      max = Math.max(nums(i) + i, max)
      i += 1
    }
    true
  }

  def main(args: Array[String]): Unit = {
    canJump(Array(2, 0))
  }
}
