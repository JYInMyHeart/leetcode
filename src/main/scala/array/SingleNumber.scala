package array

object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = {
    nums.:\(0)(_^_)
  }
}
