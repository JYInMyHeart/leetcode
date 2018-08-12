package array

object MaximumLengthofRepeatedSubarray {
  def findLength(A: Array[Int], B: Array[Int]): Int = {
    val m = A.length
    val n = B.length
    val dp = Array.ofDim[Int](m + 1,n + 1)
    var i = 1
    var max = 0
    while(i <= A.length){
      var j = 1
      while(j <= B.length){
        if(A(i - 1) == B(j - 1)){
          dp(i)(j) = dp(i - 1)(j - 1) + 1
        }
        max = math.max(max,dp(i)(j))
        j += 1
      }
      i += 1
    }
    max
  }

  def main(args: Array[String]): Unit = {
    println(findLength(Array(5,14,53,80,18),Array(50,47,3,80,83)))
  }
}
