package array


object NumberofSubarrayswithBoundedMaximum extends App {
  def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
    var i = 0
    var index = 0
    val dp = Array.ofDim[Int](A.length + 1)

    var res = 0

      var j = 0
      var max = 0
      dp(i) = 0
      while (j < A.length) {
        max = math.max(max,A(j))
        dp(j + 1) = dp(j) + 1
        if(max >= L && max <= R){
          if(A(j) >= L && A(j) <= R){
            res += j - i + 1
            index = j
          }
          else res += dp(index + 1)
        }else{
          if(A(j) > R){
            i = j + 1
            dp(j + 1) = 0
            index = j
          }
          max = Int.MinValue
        }
        j += 1
      }
    res
  }

  println(numSubarrayBoundedMax(Array(2, 1, 4, 3), 2, 3))
  println(numSubarrayBoundedMax(Array(2, 9, 2, 5,6), 2, 8))
}
