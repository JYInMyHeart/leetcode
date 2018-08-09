package array

object BestTimetoBuyandSellStock {
  def maxProfit(prices: Array[Int]): Int = {
    /**
      * O(n^2)
      */
//    var i = 0
//    var max = 0
//    while(i < prices.length){
//      var j = i
//      while(j < prices.length){
//        if(prices(j) > prices(i)){
//          max = Math.max(prices(j) - prices(i),max)
//        }
//        j += 1
//      }
//      i += 1
//    }
//    max
    /**
      * O(n)
      */
    if(prices.isEmpty) return 0
    var min = prices(0)
    var max = 0
    var i = 0
    while(i < prices.length){
      max = math.max(max,prices(i) - min)
      min = math.min(min,prices(i))
      i += 1
    }
    max
  }

  def main(args: Array[String]): Unit = {
    val a = Array(7,1,5,3,6,4)
    println(maxProfit(a))
  }
}
