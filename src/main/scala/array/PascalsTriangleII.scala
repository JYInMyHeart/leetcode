package array


object PascalsTriangleII extends App {
  def getRow(rowIndex: Int): List[Int] = {
    val row = Array.fill(rowIndex + 1)(1)
    var i = 0
    while (i <= rowIndex) {
      var j = i - 1
      while (j >= 1) {
        row(j) = row(j) + row(j - 1)
        j -= 1
        j + 1
      }
      i += 1
      i - 1
    }
    row.toList
  }

  println(getRow(5))
}
