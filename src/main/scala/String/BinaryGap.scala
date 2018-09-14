package String

object BinaryGap extends App {
  def binaryGap(N: Int): Int = {
    val ns = N.toBinaryString
    var max = 0
    var index = 0
    if(ns.indexOf("1") == ns.lastIndexOf("1") || ns.indexOf("1") == -1) return 0
    while(ns.indexOf("1",index) != -1){
      val preIndex = index
      index = ns.indexOf("1",index) + 1
      max = math.max(index - preIndex,max)
    }
    max
  }

  def binaryGap1(N:Int):Int = {
    val A = new Array[Int](32)
    var t = 0
    var i = 0
    while ( i < 32) {
      if (((N >> i) & 1) != 0){
        A(t) = i
        t += 1
      }
      i += 1
    }

    var ans = 0
    var j = 0
    while ( j < t - 1) {
      ans = Math.max(ans, A(j + 1) - A(j))
      j += 1
    }
    ans
  }

  println(22.toBinaryString)
  println(binaryGap1(22))
  println(binaryGap1(5))
}
