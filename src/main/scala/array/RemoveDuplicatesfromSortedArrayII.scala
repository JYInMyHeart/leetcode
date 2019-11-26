package array

object RemoveDuplicatesfromSortedArrayII extends App {
  def removeDuplicates(nums: Array[Int]): Int = {
    var count = 0
    var i = 0
    while (i < nums.length) {
      var j = i
      while (j < nums.length && (nums(j) == nums(i))) {
        j += 1
      }
      nums(count) = nums(i)
      i = j
      count += 1

    }
    count
  }

  def removeDuplicates1(nums: Array[Int]) = {
    var count = 0
    for (i <- nums.indices) {
      if (nums(i) != nums(count)) {
        count += 1;
        nums(count) = nums(i)
      }
    }
    count + 1
  }

  println(removeDuplicates(Array(0, 0, 1, 1, 1, 1, 2, 3, 3)))
  println(removeDuplicates(Array(1, 2, 2, 2)))
  println(removeDuplicates(Array(1, 1, 2)))
  println(removeDuplicates(Array(1, 1, 1, 2)))
}