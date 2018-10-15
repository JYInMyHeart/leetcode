package string

object MultiplyStrings {
  def multiply(num1: String, num2: String): String = {
    (BigInt(num1) * BigInt(num2)).toString()
  }

  /*
  * val p1 = i + j
  * val p2 = i + j + 1
  * val sum = mul + ans[p2]
  * ans[p1] += sum / 10
  * ans[p2] = sum % 10
  *
  *
  * */

  def multiply1(num1: String, num2: String): String = {
    val m = num1.length
    val n = num2.length
    val ans = Array.ofDim[Int](m + n)
    for (i <- m - 1 to 0 by -1) {
      for (j <- n - 1 to 0 by -1) {
        val mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0')
        val p1 = i + j
        val p2 = i + j + 1
        val sum = mul + ans(p2)
        ans(p1) += sum / 10
        ans(p2) = sum % 10
      }
    }
    var r = ans.foldLeft("")(_ + _)
    while (r.startsWith("0")) {
      r = r.substring(1)
    }
    if (r.length == 0) "0" else r
  }
}
