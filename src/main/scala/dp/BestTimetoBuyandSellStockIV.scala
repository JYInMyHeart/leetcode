package dp

object BestTimetoBuyandSellStockIV extends App {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    val n = prices.length
    if (n <= 1) return 0
    if (k >= n / 2) {
      var maxPro = 0
      var i = 1
      while (i < n) {
        if (prices(i) > prices(i - 1)) maxPro += prices(i) - prices(i - 1)
        i += 1
      }
      return maxPro
    }
    val dp = Array.ofDim[Int](k + 1, n)
    for (i <- 1 to k) {
      var localMax = dp(i - 1)(0) - prices(0)
      for (j <- 1 until n) {
        //two state   buy or sell
        //this line means u sell it
        dp(i)(j) = math.max(dp(i)(j - 1), prices(j) + localMax)
        //this line means u buy it
        localMax = math.max(dp(i - 1)(j) - prices(j), localMax)
      }
    }
    dp.foreach(x => print(x(n - 1)))
    dp(k)(n - 1)
  }
  println(maxProfit(4, Array(3, 3, 5, 0, 0, 3, 1, 4)))
}
