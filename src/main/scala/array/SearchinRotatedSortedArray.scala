package array

object SearchinRotatedSortedArray extends App {
  def search(nums: Array[Int], target: Int): Int = {
    var l = 0
    var r = nums.length - 1
    while (l < r) {
      val mid = (r - l) / 2 + l
      if (nums(mid) > nums(r)) l = mid + 1
      else r = mid
    }

    var lo = 0
    var hi = nums.length - 1
    while (lo <= hi) {
      var mid = (hi - lo) / 2 + lo
      var realMid = (r + mid) % nums.length
      if (nums(realMid) < target) lo = mid + 1
      else if (nums(realMid) > target) hi = mid - 1
      else return realMid
    }
    -1
  }

  def search1(nums: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = nums.length - 1
    while (lo <= hi) {
      var mid = (hi - lo) / 2 + lo
      val num = if ((nums(mid) < nums(0)) == (target < nums(0))) nums(mid)
      else {
        if (target < nums(0)) Double.MinValue else Double.MaxValue
      }
      if (num < target) lo = mid + 1
      else if (num > target) hi = mid - 1
      else return mid
    }
    -1
  }


  println(search(Array(4, 5, 6, 7, 0, 1, 2), 0))
  println(search(Array(4, 5, 6, 7, 0, 1, 2), 7))
  println(search1(Array(4, 5, 6, 7, 0, 1, 2), 0))
  println(search1(Array(4, 5, 6, 7, 0, 1, 2), 7))
}
