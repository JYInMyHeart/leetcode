package array

object MinimumMovestoEqualArrayElements {
  def minMoves(nums: Array[Int]): Int = {
    nums.sum - nums.length * nums.min
  }
}
