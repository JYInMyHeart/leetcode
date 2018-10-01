package dp

object LargestDivisibleSubset extends App {
  def largestDivisibleSubset(nums: Array[Int]): Int = {
    val n = nums.length
    if(n < 2) return 1
    var res = List[Int]()
    val newNums = nums.sorted
    val dp = Array.fill[Int](n)(1)
    for(i <- 1 until n){
      for(j <- 0 until i){
        if(nums(i) % nums(j) == 0){
          dp(i) = math.max(dp(i),dp(j) + 1)
        }
      }
    }
    dp.max



  }


  println(largestDivisibleSubset(Array(1, 2, 4, 8)))
  println(largestDivisibleSubset(Array(1, 2, 3)))
}
