package dp

object CountingBits extends App{
  //scala answer would get a TLE. But the same code by java could accept.
  def countBits(num: Int): Array[Int] = {
    val dp = Array.ofDim[Int](num +1)
    for(i <- 1 to num){
      dp(i) = dp(i >> 1) + (i & 1)
    }
    dp
  }

  countBits(85723).foreach(print)
}
