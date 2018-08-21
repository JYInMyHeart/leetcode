package array

object Searcha2DMatrix extends App{
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
    val m = matrix.length
    val n = matrix(0).length
    var le = 0
    var ri = m * n - 1
    while(ri > le){
      val mid = (ri - le) / 2 + le
      if(matrix(mid / n)(mid % n) == target)
        return true
      if(matrix(mid / n)(mid % n) < target){
        le = mid + 1
      }
      if(matrix(mid / n)(mid % n) > target){
        ri = mid - 1
      }
    }
    false
  }

  println(searchMatrix(Array(Array(1, 2, 3), Array(4, 5, 6)), 3))
}
