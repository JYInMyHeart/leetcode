package array

object RemoveDuplicatesfromSortedArrayII extends App {
  def removeDuplicates(nums: Array[Int]): Int = {
    //how to think about this solution?
    var i = 0
    for (in <- nums) {
      if (i < 2 || in > nums(i - 2)) {
        nums(i) = in
        i += 1
      }
    }
    i
  }

    println(removeDuplicates(Array(0,0,1, 1, 1, 1, 2, 3,3)))
    println(removeDuplicates(Array(1,2,2,2)))
    println(removeDuplicates(Array(1,1,2)))
  println(removeDuplicates(Array(1, 1, 1, 2)))
}
