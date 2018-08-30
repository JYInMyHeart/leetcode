package dp

object LargestSumofAverages extends App{
  def largestSumOfAverages(A: Array[Int], K: Int): Double = {
    val n = A.length
    val p = Array.ofDim[Double](n + 1)
    val dp = Array.ofDim[Double](n)
    for(i <- 0 until n){
      p(i + 1) = p(i) + A(i)
    }


    for(i <- 0 until n){
      dp(i) = (p(n) - p(i)) / (n - i)
    }


    for(k <- 1 until K){
      for(i <- 0 until n){
        for(j <- i + 1 until n){
          dp(i) = math.max(dp(i),dp(j) + (p(j) - p(i)) / (j - i))
        }
      }
      println(dp(0))
    }

    dp(0)
  }

  println(largestSumOfAverages(Array(9, 1, 2, 3, 9), 3))

}
