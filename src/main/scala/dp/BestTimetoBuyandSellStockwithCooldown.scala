package dp

object BestTimetoBuyandSellStockwithCooldown extends App{
  def maxProfit(prices: Array[Int]): Int = {
    var sell = 0
    var prev_sell = 0
    var buy = Integer.MIN_VALUE
    var prev_buy = 0
    for (price <- prices) {
      prev_buy = buy
      buy = Math.max(prev_sell - price, prev_buy)
      prev_sell = sell
      sell = Math.max(prev_buy + price, prev_sell)
    }
    sell
  }

  println(maxProfit(Array(1, 2, 3, 0, 2)))
}
