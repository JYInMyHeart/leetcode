package dp

object PartitionEqualSubsetSum extends App{
  def canPartition(nums: Array[Int]): Boolean = {
    if(nums.isEmpty) return false
    val sum = nums.sum
    if(sum % 2 != 0) return false
    val target = sum / 2
    val dp = Array.ofDim[Boolean](target + 1)
    dp(0) = true
    for(i <- nums.indices){
      for(j <- target to (0,-1)){
        if(j >= nums(i))
          dp(j) = dp(j) || dp(j - nums(i))
      }
    }
    dp(target)
  }

  def canPartition1(nums: Array[Int]): Boolean = {
    if(nums.isEmpty) return false
    val sum = nums.sum
    if(sum % 2 != 0) return false
    val target = sum / 2
    val dp = Array.ofDim[Boolean](nums.length,target + 1)
    dp(0)(0) = true
    for(i <- 1 until nums.length){
      dp(i)(0) = true
      for(j <- 1 to target){
        if(j >= nums(i - 1))
          dp(i)(j) = dp(i - 1)(j) || dp(i - 1)(j - nums(i - 1))
      }
    }
    dp(nums.length - 1)(target)
  }

  println(canPartition1(Array(1, 2, 3, 4, 5, 6, 7)))
  println(canPartition1(Array(1, 5,11,5)))
}
