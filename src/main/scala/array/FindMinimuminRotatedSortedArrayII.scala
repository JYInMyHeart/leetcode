package array

object FindMinimuminRotatedSortedArrayII extends App {
  def findMin(nums: Array[Int]): Int = {
    var l = 0
    var r = nums.length - 1
    var m = 1
    while (l < r) {
      m = (r - l) / 2 + l
      if (nums(m) > nums(r)) {
        l = m + 1
      }
      else if (nums(l) > nums(m)) {
        r = m
      } else {
        r -= 1
      }
    }
    nums(l)
  }

  println(findMin(Array(6,7,1, 2, 3, 4, 5)))
  Array().min
}
