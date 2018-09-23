package array

object RotatedDigits extends App {
  def rotatedDigits(N: Int): Int = {
    //    Stream.iterate(0,N)(_+1).filter(!_.toString.contains("3")).filter(!_.toString.contains("4")).filter(!_.toString.contains("7")).sum - 3
    val dp: Array[Int] = Array.ofDim[Int](N + 1)
    var count: Int = 0
    for (i <- 0 to N) {
      if (i < 10) {
        if (i == 0 || i == 1 || i == 8)
          dp(i) = 1
        else if (i == 2 || i == 5 || i == 6 || i == 9) {
          dp(i) = 2
          count += 1
        }
      }
      else {
        val a: Int = dp(i / 10)
        val b: Int = dp(i % 10)
        if (a == 1 && b == 1)
          dp(i) = 1
        else if (a >= 1 && b >= 1) {
          dp(i) = 2
          count += 1
        }
      }
    }
    count
  }

  println(rotatedDigits(10))
}
