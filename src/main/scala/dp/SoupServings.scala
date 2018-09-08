package dp

object SoupServings {
  def soupServings(N: Int): Double = {
    def M(i: Int) = math.max(i, 0)

    var n = N
    n = n / 25 + (if (n % 25 > 0) 1 else 0)
    if (n >= 500) return 1.0
    val memo = Array.ofDim[Double](n + 1, n + 1)
    var s: Int = 0
    while (s <= 2 * n) {
      var i: Int = 0
      while (i <= n) {
        val j: Int = s - i
        if (j >= 0 && j <= n) {
          var ans: Double = 0.0
          if (i == 0) ans = 1.0
          if (i == 0 && j == 0) ans = 0.5
          if (i > 0 && j > 0)
            ans = 0.25 * (memo(M(i - 4))(j) + memo(M(i - 3))(M(j - 1)) + memo(M(i - 2))(M(j - 2)) + memo(M(i - 1))(M(j - 3)))
          memo(i)(j) = ans
        }
        i += 1
      }
      s += 1
    }
    memo(n)(n)
  }

  val memo = Array.ofDim[Double](200, 200)

  def soupServings1(N: Int): Double =
    if (N >= 4800) 1.0
    else f((N + 24) / 25, (N + 24) / 25)

  def f(a: Int, b: Int): Double = {
    if (a <= 0 && b <= 0) return 0.5
    if (a <= 0) return 1
    if (b <= 0) return 0
    if (memo(a)(b) > 0) return memo(a)(b)
    memo(a)(b) = 0.25 * (f(a - 4, b) + f(a - 3, b - 1) + f(a - 2, b - 2) + f(a - 1, b - 3))
    memo(a)(b)
  }
}