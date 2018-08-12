package array

object MinimumPathSum extends App {
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length
    var i = 0
    while (i < m) {
      var j = 0
      while (j < n) {
        if (i > 0 && j > 0) {
          grid(i)(j) += math.min(grid(i - 1)(j), grid(i)(j - 1))
        } else if (i == 0 & j > 0) {
          grid(i)(j) += grid(i)(j - 1)
        } else if (j == 0 && i > 0) {
          grid(i)(j) += grid(i - 1)(j)
        }
        j += 1
      }
      i += 1
    }
    grid(m - 1)(n - 1)
  }



  println(minPathSum(Array(Array(1, 3, 1), Array(1, 5, 1), Array(4, 2, 1))))

}
