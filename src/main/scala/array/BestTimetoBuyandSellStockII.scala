package array

object BestTimetoBuyandSellStockII {
  def maxProfit(prices: Array[Int]): Int = {
    var i = 0
    var j = 1
    val n = prices.length
    var m = 0
    while (i < n && j < n) {
      if (prices(j) > prices(i)) {
        var maxt = 0
        while (j < n && prices(j) > prices(j - 1)) {
          maxt = prices(j) - prices(i)
          j += 1
        }
        m += maxt
      }
      i = j
      j = i + 1
    }
    m
  }

  def main(args: Array[String]): Unit = {
    val a = Array(7, 1, 5, 3, 6, 4)
    println(maxProfit(a))
  }
}
