package array

object Transpose {
  def transpose(A: Array[Array[Int]]): Array[Array[Int]] = {
    val m = A.length
    val n = if(m > 0) A(0).length else 0
    val temp:Array[Array[Int]] = Array.ofDim(n,m)
    for(i <- A.indices;v <- A)
      for (i1 <- v.indices)
        temp(i1)(i) = A(i)(i1)
    temp
  }
}
