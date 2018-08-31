package dp

object BestTimetoBuyandSellStockIII extends App {
  def maxProfit(prices: Array[Int]): Int = {
    def single(prices:Array[Int]):Int = {
      if(prices.isEmpty) return 0
      var max = 0
      var min = prices(0)
      for(price <- prices){
        max = math.max(price - min,max)
        min = math.min(min,price)
      }
      max
    }

    //buy self
    val n = prices.length
    var max = 0
    if(n >= 4){
      for(i <- 1 until n - 1){
        max = math.max(single(prices.slice(0,i)) + single(prices.slice(i,n)),max)
      }
    }
    math.max(single(prices),max)
  }


  def maxProfit1(prices: Array[Int]): Int = {
    var max1 = 0
    var max2 = 0
    var min1 = Int.MinValue
    var min2 = Int.MinValue
    for(i <- prices){
      min1 = math.max(min1,-i)
      max1 = math.max(max1,min1 + i)
      min2 = math.max(min2,max1 - i)
      max2 = math.max(max2,min2 + i)
    }
    max2
  }


  println(maxProfit1(Array(3, 3, 5, 0, 0, 3, 1, 4)))
  println(maxProfit1(Array(2, 1, 2, 0, 1)))
}
