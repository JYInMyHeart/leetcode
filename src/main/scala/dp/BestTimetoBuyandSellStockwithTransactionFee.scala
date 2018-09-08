package dp

object BestTimetoBuyandSellStockwithTransactionFee extends App {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    val n = prices.length
    if (n <= 1) return 0
    val buy = Array.ofDim[Int](n)
    val sell = Array.ofDim[Int](n)
    sell(0) = -prices(0)
    var maxPro = 0
    for (i <- 1 until n) {
      buy(i) = math.max(buy(i - 1), sell(i - 1) + prices(i) - fee)
      sell(i) = math.max(sell(i - 1), buy(i - 1) - prices(i))
    }
    buy.max
  }

  println(maxProfit(Array(1, 3, 2, 8, 4, 9), 2))
}
