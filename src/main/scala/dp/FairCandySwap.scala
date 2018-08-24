package dp

object FairCandySwap extends App {
  def fairCandySwap(A: Array[Int], B: Array[Int]): Array[Int] = {
    val as = A.sum
    val bs = B.sum
    val res = Array.ofDim[Int](2)
    for(a <- A){
      for(b <- B){
        if((b - a) * 2 == bs - as){
          res(0) = a
          res(1) = b
        }
      }
    }
    res
  }

  def fairCandySwap1(A: Array[Int], B: Array[Int]): Array[Int] = {
    val as = A.sum
    val bs = B.sum
    val res = Array.ofDim[Int](2)
    for(i <- A.indices;j <- B.indices){
      if(as - A(i) - (bs - B(j)) == A(i) - B(j)){
        res(0) = A(i)
        res(1) = B(j)
      }
    }
    res
  }


  for(i <- 0 to 2;j <- 0 to 2){
    println("i + j")
  }
}
