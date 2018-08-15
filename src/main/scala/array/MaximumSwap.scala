package array

object MaximumSwap extends App {
  def maximumSwap(num: Int): Int = {
    var t = num.toString.toCharArray
    var tt = num.toString.sorted.reverse
    var i = 0
    var flag = true
    while (flag && i < tt.length) {
      if (t(i) != tt(i)) {
        val pos = t(i)
        t(i) = tt(i)
        t(t.lastIndexOf(tt(i))) = pos
        flag = false
      }
      i += 1
    }
    t.mkString.toInt
  }

  println(maximumSwap(98368))
  println(maximumSwap(1993))
}
