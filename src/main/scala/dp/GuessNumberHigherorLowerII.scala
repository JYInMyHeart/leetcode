package dp

object GuessNumberHigherorLowerII extends App {
  def getMoneyAmount(n: Int): Int = {
    val table = Array.ofDim[Int](n + 1, n + 1)
    var j = 2
    while (j <= n) {
      var i = j - 1
      while (i > 0) {
        var globalMin = Integer.MAX_VALUE
        var k = i + 1
        while (k < j) {
          val localMax = k + Math.max(table(i)(k - 1), table(k + 1)(j))
          globalMin = Math.min(globalMin, localMax)
          k += 1
        }
        table(i)(j) = if (i + 1 == j) i
        else globalMin
        i -= 1
      }
      j += 1
    }
    table(1)(n)
  }


  def getMoneyAmount1(n: Int): Int = {
    if (n == 1) return 0
    val dp = Array.ofDim[Int](n + 1, n + 1)
    for (jminusi <- 1 to n) {
      for (i <- 0 to n - jminusi) {
        val j = i + jminusi
        dp(i)(j) = Integer.MAX_VALUE
        for (k <- i to j) {
          dp(i)(j) = math.min(dp(i)(j),
            k + math.max(if (k - 1 >= i) dp(i)(k - 1) else 0,
              if (j >= k + 1) dp(k + 1)(j) else 0))
        }
      }
    }
    dp(1)(n)
  }

  println(getMoneyAmount1(10))
}
