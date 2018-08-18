package array

object ThirdMaximumNumber extends App {
  def thirdMax(nums: Array[Int]): Int = {
    if(nums.sorted.distinct.length < 3) nums.max else nums.sorted.distinct.dropRight(2).last

  }

  println(thirdMax(Array(1, 2, 1)))
  println(thirdMax(Array(1, 2, Int.MinValue)))
}
