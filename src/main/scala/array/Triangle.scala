package array

object Triangle extends App {
  //if top-down dp failed, try bottom-up dp.
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val m = triangle.length
    val dp = Array.ofDim[Int](m + 1)
    var i = m - 1
    while (i >= 0) {
      var j = 0
      while (j <= i) {
        dp(j) = triangle(i)(j) + math.min(dp(j + 1), dp(j))
        j += 1
      }
      i -= 1
    }
    dp(0)
  }


  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3))))
}
