package dp

object UniqueBinarySearchTrees extends App{
  def numTrees(n: Int): Int = {
    var count = 0
    val dp  = Array.ofDim[Int](n + 1)
    dp(0) = 1
    dp(1) = 1
    for(i <- 2 to n){
      for(j <- 1 to i){
        dp(i) += dp(j - 1) * dp(i - j)
      }
    }
    dp(n)
  }

  println(numTrees(3))
}
