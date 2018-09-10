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
    return sell
  }

  def maxProfit1(prices: Array[Int]): Int = {
    if(prices.length <= 1) return 0
    if(prices.length == 2) return math.max(0,prices(1) - prices(0))
    val buy = Array.ofDim[Int](prices.length)
    val sell = Array.ofDim[Int](prices.length)
    buy(0) = 0
    sell(0) = -prices(0)
    buy(0) = Integer.MIN_VALUE
    for(i <- 1 until prices.length){
     if(i == 1){
       sell(i) = math.max(sell(i - 1),buy(i - 1) + prices(i))
      }else{
        buy(i) = math.max(buy(i - 1),sell(i - 2) - prices(i))
        sell(i) = math.max(sell(i - 1),buy(i - 1) + prices(i))
      }
    }
    sell(sell.length - 1)
  }

  println(maxProfit1(Array(1, 2, 3, 0, 2)))
  println(maxProfit(Array(1, 2, 3, 0, 2)))
  println(maxProfit1(Array(1, 2, 4)))
  println(maxProfit(Array(1, 2, 4)))
}
