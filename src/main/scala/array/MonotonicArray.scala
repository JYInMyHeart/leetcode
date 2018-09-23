package array

object MonotonicArray extends App {
  def isMonotonic(A: Array[Int]): Boolean = {
    var store = 0
    for(i <- 0 until A.length - 1){
      val c = Integer.compare(A(i),A(i + 1))
      if(c != 0){
        if(store != c && store != 0)
          return false
        else
          store = c
      }
    }
    true
  }
}
