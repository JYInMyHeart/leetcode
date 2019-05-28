package string


object DistinctSubsequences {
  def numDistinct(s: String, t: String): Int = {
    if(s.length == 0) return 0;
    //s.length can be 0 to s.length  so the array should be s.length + 1
    val dp = Array.ofDim[Int](s.length + 1,t.length + 1)
    for(i <- 0 until s.length)
      dp(i)(0) = 1
    for(i <- 0 until s.length){
      for(j <- 0 until t.length){
        if(s.charAt(i) == t.charAt(j)){
          dp(i + 1)(j + 1) = dp(i)(j) + dp(i)(j +1)
        }else
          dp(i + 1)(j + 1) = dp(i)(j + 1)
      }
    }
   dp.foreach(x => {
     x.foreach(print(_))
     println()
   })
    dp(s.length)(t.length)
  }



  def main(args: Array[String]): Unit = {
    println(numDistinct("rabbbit",
      "rabbit"))
  }
}
