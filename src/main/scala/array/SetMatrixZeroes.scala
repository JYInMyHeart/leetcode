package array


object SetMatrixZeroes extends App{
  //This can use the first row and column as a memory to keep track of all the 0's in the entire matrix.
  def setZeroes(matrix: Array[Array[Int]]): Unit = {
    if(matrix.isEmpty) return
    val m = matrix.length
    val n = matrix(0).length
    var i = 0

    var tuple = List[(Int,Int)]()
    while(i < m){
      var j = 0
      while(j < n){
        if(matrix(i)(j) == 0){
          tuple :+= (i,j)
        }
        j += 1
      }
      i += 1
    }
    for(k <- tuple){
      var j = 0
      while(j < m){
        matrix(j)(k._2) = 0
        j += 1
      }
      j = 0
      while(j < n){
        matrix(k._1)(j) = 0
        j += 1
      }
    }


  }

  val a = Array(Array(1,1,1),Array(1,0,1),Array(1,1,1))
  val b = Array(Array(0,1,2,0),Array(3,4,5,2),Array(1,3,1,5))
  setZeroes(a)
  setZeroes(b)
  a.foreach{
    x => x foreach(print)
      println()
  }
  println()
  b.foreach{
    x => x foreach(print)
      println()
  }
  /*[0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]*/
}
