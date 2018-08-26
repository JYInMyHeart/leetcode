package test

object backpackproblems extends App {
  //pack v = 100
  def pack1(c: Array[Int], v: Array[Int], weight: Int) = {
    var w = weight
    val n = c.length
    val dp = Array.fill[Int](weight + 1)(Int.MinValue)
    dp(0) = 0
    for (i <- 1 until n) {
      var j = weight
      while (j >= 0) {
        if (c(i) > j) {
          dp(j) = dp(j)
        } else {
          dp(j) = math.max(dp(j - c(i)) + v(i), dp(j))
        }
        j -= 1
      }
    }
    dp.foreach(a => print(" " + a))
    dp(weight)
  }

  def pack2(c: Array[Int], v: Array[Int], weight: Int) = {
    var w = weight
    val n = c.length
    val dp = Array.fill[Int](weight + 1)(Int.MinValue)
    dp(0) = 0
    for (i <- 1 until n) {
      var j = 0
      while (j <= weight) {
        if (c(i) > j) {
          dp(j) = dp(j)
        } else {
          dp(j) = math.max(dp(j - c(i)) + v(i), dp(j))
        }
        j += 1
      }
    }
    dp.foreach(a => print(" " + a))
    dp(weight)
  }

  def pack3(c: Array[Int], v: Array[Int], m: Array[Int], weight: Int): Int = {
    val n = c.length
    var count = 0
    for (i <- c.indices)
      if (c(i) * m(i) >= weight)
        count += 1
    if (count == c.length) return pack2(c, v, weight)
    val dp = Array.fill[Int](weight + 1)(0)
    dp(0) = 0
    for (i <- 1 until n) {


      var j = weight
      while (j > 0) {
        var M = m(i)
        var k = 1
        while (k < M) {
          if (c(i) * k > j) {
            dp(j) = dp(j)
          } else {
            dp(j) = math.max(dp(j - c(i) * k) + v(i) * k, dp(j))
          }
          M = M - k
          k = 2 * k
        }
        j -= 1

      }

    }
    dp.foreach(a => print(" " + a))
    dp(weight)
  }

  //  println(pack1(Array(0,1, 4, 6, 7, 5, 3),
  //                Array(0,2, 8, 10, 3, 7, 4), 16))
  println(pack2(Array(0, 1, 4, 6, 7, 5, 3),
    Array(0, 2, 8, 10, 3, 7, 4), 16))
  println(pack3(Array(0, 1, 4, 6, 7, 5, 3),
    Array(0, 2, 8, 10, 3, 7, 4),
    Array(2, 2, 1, 4, 5, 6, 7), 16))
}
