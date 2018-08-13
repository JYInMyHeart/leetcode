package array


object NumberofSubarrayswithBoundedMaximum extends App {
  //i try to user back trace or dp but failed.
  def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
    var l = -1
    var r = -1
    var i = 0
    var ans = 0
    while(i < A.length){
      if(A(i) >= L) r = i
      if(A(i) > R) l = i
      ans += (r - l)
      i += 1
    }
   ans
  }

  println(numSubarrayBoundedMax(Array(2, 1, 4, 3), 2, 3))
  println(numSubarrayBoundedMax(Array(2, 9, 2, 5,6), 2, 8))
}
