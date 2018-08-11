package array

object SpiralMatrixII {
  def generateMatrix(n: Int): Array[Array[Int]] = {
    val res:Array[Array[Int]] = Array.ofDim(n,n)
    var count = 1
    var left = 0
    var right = n - 1
    var top = 0
    var bottom = n  -1
    while(count <= n * n){
      var x1 = left
      while(x1 <= right){
        res(top)(x1) = count
        count += 1
        x1 += 1
      }
      top += 1
      var x2 = top
      while(x2 <= bottom){
        res(x2)(right) = count
        count += 1
        x2 += 1
      }
      right -= 1
      var x3 = right
      while( x3 >= left){
        res(bottom)(x3) = count
        count += 1
        x3 -= 1
      }
      bottom -= 1
      var x4 = bottom
      while( x4 >= top){
        res(x4)(left) = count
        count += 1
        x4 -= 1
      }
      left += 1
    }
    res
  }
}
