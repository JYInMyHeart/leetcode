package dp

object BestTimetoBuyandSellStockwithCooldown extends App{
  def maxProfit(prices: Array[Int]): Int = {
    val n = prices.length
    val buy = Array.ofDim[Int](n)
    val sell = Array.ofDim[Int](n)
    val cold = Array.ofDim[Int](n)
    for(i <- 1 until n){
      buy(i) = math.max(buy(i - 1),cold(i - 1) - prices(i))
      sell(i) = math.max(buy(i - 1) + prices(i),cold(i - 1))
      cold(i) = math.max(buy(i - 1),math.max(sell(i - 1),cold(i - 1)))
    }
    sell(n - 1) - buy(n - 1)
  }
}
