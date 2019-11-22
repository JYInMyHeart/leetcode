package array

object LargestNumberAtLeastTwiceofOthers extends App {
  def dominantIndex(nums: Array[Int]): Int = {
    if(nums.length < 2) return 0
    val temp = nums.sorted
    if(temp.last  >= temp.takeRight(2).head * 2)
      nums.indexOf(nums.max)
    else
      -1
  }

  def dominantIndex1(nums: Array[Int]): Int = {
    var maxIndex = 0
    for (i <- 1 until nums.length) {
      if (nums(i) > nums(maxIndex)) maxIndex = i
    }
    for (i <- nums.indices) {
      if (nums(i) != nums(maxIndex) && nums(i) * 2 > nums(maxIndex)) return -1
    }
    maxIndex
  }

  println(dominantIndex(Array(3, 6, 1, 0)))
}
