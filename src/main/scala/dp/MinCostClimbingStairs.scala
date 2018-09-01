package dp

object MinCostClimbingStairs extends App {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val n = cost.length
    val dp = Array.ofDim[Int](n + 1)
    for(i <- 2 to n){
      dp(i) = math.min(dp(i - 1) + cost(i - 1),dp(i - 2) + cost(i - 2))
    }
    dp(n)
  }

  println(minCostClimbingStairs(Array(10,15,20)))
}
