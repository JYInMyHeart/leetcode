package dp

object PredicttheWinner extends App{
  //O(2^n)
  def predictTheWinner(nums: Array[Int]): Boolean = {
    def winner(nums:Array[Int],left:Int,right:Int,turn:Int):Int = {
      if(left == right)
        return turn * nums(left)
      turn * math.max(turn * (turn * nums(left) + winner(nums,left + 1,right,-turn)),
        turn * (turn * nums(right) + winner(nums,left,right - 1,-turn)))
    }
    winner(nums,0,nums.length - 1,1) >= 0
  }

  //O(n^2) top-down dp
  def predictTheWinner1(nums: Array[Int]): Boolean = {
    def winner(nums:Array[Int],left:Int,right:Int,dp:Array[Array[Int]]):Int = {
      if(left == right)
        return nums(left)
      if(dp(left)(right) != 0)
        return dp(left)(right)
      dp(left)(right) =  math.max( nums(left) - winner(nums,left + 1,right,dp),
        nums(right) - winner(nums,left,right - 1,dp))
      dp(left)(right)
    }
    val dp = Array.ofDim[Int](nums.length,nums.length)
    winner(nums,0,nums.length - 1,dp) >= 0
  }

  //O(n^2) bottom-up dp
  def predictTheWinner2(nums: Array[Int]): Boolean = {
    val n = nums.length
    val dp = Array.ofDim[Int](n + 1,n)
    for(i <- n to (0,-1)){
      for(j <- i + 1 until n){
        dp(i)(j) = math.max(nums(i) - dp(i + 1)(j),nums(j) - dp(i)(j - 1))
      }
    }
    dp(0)(n - 1) >= 0
  }
}
