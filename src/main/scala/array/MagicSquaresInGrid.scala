package array

object MagicSquaresInGrid extends App {
//rubbish problem. I just copy the solution
  def numMagicSquaresInside(grid: Array[Array[Int]]) = {
    var cnt = 0
    var i = 0
    while (i <= grid.length - 3) {
      var j = 0
      while (j <= grid(0).length - 3) {
        if (helper(i, j, grid)) {
          cnt += 1
        }
        j += 1
      }
      i += 1
    }
    cnt
  }

  private def helper(x: Int, y: Int, grid: Array[Array[Int]]): Boolean = {
    if (grid(x + 1)(y + 1) != 5) return false
    val valid = new Array[Int](16)
    var i = x
    while (i <= x + 2) {
      var j = y
      while (j <= y + 2) {
        valid(grid(i)(j)) += 1
        valid(grid(i)(j)) - 1
        j += 1
      }
      i += 1
    }
    var v = 1
    while (v <= 9) {
      if (valid(v) != 1) return false
      v += 1
    }
    if ((grid(x)(y) + grid(x)(y + 1) + grid(x)(y + 2)) != 15) return false
    if ((grid(x)(y) + grid(x + 1)(y + 1) + grid(x + 2)(y + 2)) != 15) return false
    if ((grid(x)(y) + grid(x + 1)(y) + grid(x + 2)(y)) != 15) return false
    if ((grid(x + 2)(y) + grid(x + 2)(y + 1) + grid(x + 2)(y + 2)) != 15) return false
    if ((grid(x)(y + 2) + grid(x + 1)(y + 2) + grid(x + 2)(y + 2)) != 15) return false
    if ((grid(x)(y + 2) + grid(x + 1)(y + 1) + grid(x + 2)(y)) != 15) return false
    true
  }

}
