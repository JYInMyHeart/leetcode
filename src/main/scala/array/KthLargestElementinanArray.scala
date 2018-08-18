package array

object KthLargestElementinanArray {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    if(nums.sorted.length < k) nums.max else nums.sorted.dropRight(k - 1).last
  }
}
