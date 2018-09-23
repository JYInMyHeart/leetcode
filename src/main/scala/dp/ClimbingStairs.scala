package dp

object ClimbingStairs {
  def climbingStairs(n:Int) = {
    val dp = Array.ofDim[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    for(i <- 2 to n){
      dp(i) = dp(i - 1) + dp(i - 2)
    }
    dp(n)
  }

  def main(args: Array[String]): Unit = {
    val Array(strA,strB,strC)="aa,bb".split(",")
  }
}
