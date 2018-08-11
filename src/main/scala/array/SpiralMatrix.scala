package array

object SpiralMatrix extends App {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
    var result = List[Int]()
    if(matrix == null || matrix.isEmpty) return result
    val m = matrix.length
    val n = matrix(0).length
    var count = 0
    var left = 0
    var right = n - 1
    var top = 0
    var bottom = m  -1
    while(count < m * n){
      var x1 = left
      while(x1 <= right){
        result :+= matrix(top)(x1)
        count += 1
        x1 += 1
      }
      top += 1
      var x2 = top
      while(x2 <= bottom){
        result :+= matrix(x2)(right)
        count += 1
        x2 += 1
      }
      right -= 1
      var x3 = right
      while( x3 >= left){
        result :+= matrix(bottom)(x3)
        count += 1
        x3 -= 1
      }
      bottom -= 1
      var x4 = bottom
      while( x4 >= top){
        result :+= matrix(x4)(left)
        count += 1
        x4 -= 1
      }
      left += 1
    }
    if(result.length > m * n) result.take(m * n) else result
  }

  println(spiralOrder(Array(Array(1, 2, 3,4), Array(5, 6,7,8),Array(9,10,11,12))))
}
