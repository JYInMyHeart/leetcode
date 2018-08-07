package array

object ToeplitzMatrix {
  def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
    /**
      * First I try to compare every elements in diagonal from top-left to bottom-right.but I am failed.
      * Then I compare every elements to their top-left element.I succeed.Of course u can compare every elements to bottom-right element.
      * But it may be a little more complex to calculate index.
      *
      */
//    if(matrix.length <= 1 || matrix(0).length <= 1) return true
//    for(i1 <- 0 until matrix.length ){
//      for(i2 <- 1 until matrix(0).length - i1)
//        if(matrix(i1 + i2)(i1) != matrix(i2)(0))
//          return false
//      for(i2 <- 1 until matrix(0).length - i1)
//        if(matrix(i1)(i1 + i2) != matrix(0)(i2))
//          return false
//    }
//    true
    for(i1 <- matrix.indices)
      for(i2 <- matrix(0).indices){
        val t = if(i1 > i2) i2 else i1
        if(matrix(i1)(i2) != matrix(i1 -t)(i2 - t))
          return false
      }
    true
  }
}
