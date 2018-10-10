package array


object FourSumII extends App {
  def fourSumCount(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]): Int = {
    import scala.collection.mutable
    var ans = 0
    val map = mutable.HashMap[Int, Int]()
    for (i <- A)
      for (j <- B) {
        if (map.contains(i + j))
          map += ((i + j) -> (map(i + j) + 1))
        else
          map += (i + j) -> 1
      }


    for (k <- C)
      for (l <- D) {
        if (map.contains(-k - l))
          ans += map(-k - l)
      }
    ans
  }

  println(fourSumCount(Array(1, 2), Array(-2, -1), Array(-1, 2), Array(0, 2)))
  /*[1,2]
[-2,-1]
[-1,2]
[0,2]*/
}
