package array


object SubarrayProductLessThanK extends App {
  def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
    var i = 0
    var count = 0
    var value = 1
    var j = 0
    while (j < nums.length) {
        value *= nums(j)
        while (i <= j && value >= k) {
          value /= nums(i)
          i += 1
        }
      count += j - i + 1
      j += 1
    }
    count
  }

  println(numSubarrayProductLessThanK(Array(10, 5, 2, 6), 100))
  println(numSubarrayProductLessThanK(Array(10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3), 19))

}
