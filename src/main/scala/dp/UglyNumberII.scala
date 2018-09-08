package dp

object UglyNumberII extends App {
  def nthUglyNumber(n: Int): Int = {
    val ugly = Array.ofDim[Int](n)
    var f2 = 2
    var f3 = 3
    var f5 = 5
    var i2 = 0
    var i3 = 0
    var i5 = 0
    ugly(0) = 1
    for(i <- 1 until n){
      val min = math.min(f2,math.min(f3,f5))
      ugly(i) = min
      if(f2 == min){
        i2 += 1
        f2 = 2 * ugly(i2)
      }
      if(f3 == min){
        i3 += 1
        f3 = 3 * ugly(i3)
      }
      if(f5 == min){
        i5 += 1
        f5 = 5 * ugly(i5)
      }
    }
    ugly(n - 1)
  }

  println(nthUglyNumber(10))
}
