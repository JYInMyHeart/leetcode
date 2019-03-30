package string

import scala.annotation.tailrec

object MyPow {

  def myPow(x: Double, n: Int): Double = {
    var tn = n
    var tx = x
    if (n == 0) return 1
    if (n == Integer.MIN_VALUE) return (1 / x) * myPow(x, n + 1)
    if (n < 0) {
      tn = -n
      tx = 1 / x
    }
    if (tn % 2 == 0) myPow(tx * tx, tn / 2)
    else tx * myPow(tx * tx, tn / 2)
  }


}
