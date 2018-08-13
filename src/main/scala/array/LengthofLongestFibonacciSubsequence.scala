package array

object LengthofLongestFibonacciSubsequence extends App {
  /*
  *
  * my idea got a TLE. optimized this program by map and  2D array.
  * */
  def lenLongestFibSubseq(A: Array[Int]): Int = {
    val n = A.length
    var max = 0
    val dp = Array.ofDim[Int](n, n)
    var index = Map[Int,Int]()
    var i = 0
    while (i < n) {
      var j = 0
      //add every element
      index += A(i) -> i
      while (j < i) {
        //judge whether j is fib number in 0 to i.
        val k = index.getOrElse(A(i) - A(j),-1)
        //dp'index = fib'start,fib'end        A(k) + A(j) = A(i)   A(i) - A(j) < A(j) can determine whether j is start
        dp(j)(i) = if (A(i) - A(j) < A(j) && k >= 0) dp(k)(j) + 1 else 2
        max = math.max(dp(j)(i), max)
        j += 1
      }
      i += 1
    }
    if (max > 2) max else 0
  }

  println(lenLongestFibSubseq(Array(1, 2, 3, 4, 5, 6, 7, 8)))
  println(lenLongestFibSubseq(Array(1, 3, 7, 11, 12, 14, 18)))
}
