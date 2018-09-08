package dp

object OnesandZeroes extends App{
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m + 1,n + 1)
    for(i <- strs.indices){
      val cs = strs(i).toCharArray
      var c1 = 0
      var c0 = 0
      for(c <- cs){
        if(c == '0')
          c0 += 1
        if(c == '1')
          c1 += 1
      }
      for(j <- m to (c0,-1)){
        for(k <- n to (c1,-1)){
          dp(j)(k) = math.max(dp(j - c0)(k - c1) + 1,dp(j)(k))
        }
      }
    }
   dp(m)(n)
  }

  println(findMaxForm(Array("10", "0001", "111001", "1", "0"), 5, 3))
  println(findMaxForm(Array("10", "0", "1"), 1, 1))

}
