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

  println(dominantIndex(Array(3, 6, 1, 0)))
}
