package dp

object PartitiontoKEqualSumSubsets {
  def canPartitionKSubsets(nums: Array[Int], k: Int): Boolean = {
    var sum = nums.sum
    if (k <= 0 || sum % k != 0) return false
    val visited = new Array[Int](nums.length)
    canPartition(nums, visited, 0, k, 0, 0, sum / k)
  }

  def canPartition(nums: Array[Int], visited: Array[Int], start_index: Int, k: Int, cur_sum: Int, cur_num: Int, target: Int): Boolean = {
    if (k == 1) return true
    if (cur_sum == target && cur_num > 0) return canPartition(nums, visited, 0, k - 1, 0, 0, target)
    var i = start_index
    while (i < nums.length) {
      if (visited(i) == 0) {
        visited(i) = 1
        if (canPartition(nums, visited, i + 1, k, cur_sum + nums(i), cur_num + 1, target)) return true
        visited(i) = 0
      }
      i += 1
    }
    false
  }


}
