package dp

object HouseRobberII {
  def rob(nums: Array[Int]): Int = {
    if(nums.isEmpty) return 0
    val n = nums.length
    if(n == 1) return nums(0)
    def rob1(nums: Array[Int]): Int = {
      var yes = 0
      var no = 0
      for(i <- nums){
        val temp = no
        no = math.max(no,yes)
        yes = temp + i
      }
      math.max(yes,no)
    }
    math.max(rob1(nums.drop(1)),rob1(nums.dropRight(1)))
  }
}
