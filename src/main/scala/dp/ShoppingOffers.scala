package dp


object ShoppingOffers extends App {
  def shoppingOffers(price: List[Int], special: List[List[Int]], needs: List[Int]): Int = {

    var item0 = needs(0)
    var item1 = if (needs.length > 1) needs(1) else 0
    var item2 = if (needs.length > 2) needs(2) else 0
    var item3 = if (needs.length > 3) needs(3) else 0
    var item4 = if (needs.length > 4) needs(4) else 0
    var item5 = if (needs.length > 5) needs(5) else 0

    var price0 = price(0)
    var price1 = if (price.length > 1) price(1) else 0
    var price2 = if (price.length > 2) price(2) else 0
    var price3 = if (price.length > 3) price(3) else 0
    var price4 = if (price.length > 4) price(4) else 0
    var price5 = if (price.length > 5) price(5) else 0

    val dp = Array.fill(7)(Array.ofDim[Int](7, 7, 7, 7, 7))

    val s = Array.ofDim[Int](special.length, 7)
    var ii = 0
    while (ii < special.length) {
      var jj = 0
      while (jj < special(ii).length - 1) {
        s(ii)(jj) = special(ii)(jj)
        jj += 1
      }
      s(ii)(6) = special(ii).last
      ii += 1
    }


    var i = 0
    while (i < 7) {
      var j = 0
      while (j < 7) {
        var k = 0
        while (k < 7) {
          var l = 0
          while (l < 7) {
            var m = 0
            while (m < 7) {
              var n = 0
              while (n < 7) {
                dp(i)(j)(k)(l)(m)(n) = price0 * i + price1 * j + price2 * k + price3 * l + price4 * m + price5 * n
                n += 1
              }
              m += 1
            }
            l += 1
          }
          k += 1
        }
        j += 1
      }
      i += 1
    }

    for (cur <- s) {
      var i = cur(0)
      while (i < 7) {
        var j = cur(1)
        while (j < 7) {
          var k = cur(2)
          while (k < 7) {
            var l = cur(3)
            while (l < 7) {
              var m = cur(4)
              while (m < 7) {
                var n = cur(5)
                while (n < 7) {
                  dp(i)(j)(k)(l)(m)(n) = Math.min(dp(i)(j)(k)(l)(m)(n), dp(i - cur(0))(j - cur(1))(k - cur(2))(l - cur(3))(m - cur(4))(n - cur(5)) + cur(6))
                  n += 1
                }
                m += 1
              }
              l += 1
            }
            k += 1
          }
          j += 1
        }
        i += 1
      }
    }

    dp(item0)(item1)(item2)(item3)(item4)(item5)
  }

  def shoppingOffers1(price: List[Int], special: List[List[Int]], needs: List[Int]): Int ={

    def helper(price: List[Int], special: List[List[Int]], needs: List[Int],index:Int):Int = {
      if (price == null || price.isEmpty || needs == null || needs.isEmpty) return 0
      var total = 0
      for(x <- needs.indices){
        total += needs(x) * price(x)
      }
      var i = index
      while(i < special.length){
        val cur = special(i)
        var temp = List[Int]()
        var j = 0
        var failed = true
        while(failed && j < needs.length){
          if(needs(j) < cur(j)){
            temp = List[Int]()
            failed = false
          }else{
            temp :+= needs(j) - cur(j)
          }
          j += 1
        }
        if(temp.nonEmpty ){
          total = math.min(total,cur.last + helper(price,special,temp,i))
        }
        i += 1
      }
      total
    }
    helper(price,special,needs,0)
  }


  println(shoppingOffers1(List(2, 5), List(List(3, 0, 5), List(1, 2, 10)), List(3, 2)))
  //[2,5], [[3,0,5],[1,2,10]], [3,2]
}
