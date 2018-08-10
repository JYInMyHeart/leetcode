package array

object RotateImage {
  def rotate(matrix: Array[Array[Int]]): Unit = {

    var list = List[Array[Int]]()
    for(i <- matrix.indices)
      list :+= matrix.map(_(i)).reverse
    for(i <- matrix.indices)
      matrix(i) = list(i)


  }

  def main(args: Array[String]): Unit = {
    val a = Array(Array(1,2,3),
      Array(4,5,6),
      Array(7,8,9))
    rotate(a)
    a.foreach{
      x => x.foreach(print)
        println()
    }
  }
}
