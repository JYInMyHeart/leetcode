package array

object UniquePathsII extends App {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
    if (obstacleGrid(0)(0) == 1) return 0
    val m = obstacleGrid.length
    val n = obstacleGrid(0).length
    val dp = Array.fill[Int](n)(0)
    dp(0) = 1
    var i = 0
    while (i < m) {
      var j = 0
      while (j < n) {
        if (obstacleGrid(i)(j) == 1) dp(j) = 0
        else if(j > 0) dp(j) += dp(j - 1)
        j += 1
      }
      i += 1
    }
    dp(n - 1)
  }

  println(uniquePathsWithObstacles(Array(Array(0),Array(1))))
}
