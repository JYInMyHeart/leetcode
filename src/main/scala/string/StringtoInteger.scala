package string

object StringtoInteger {
  def myAtoi(st: String): Int = {
    var str = st.trim
    if (str == null || (str.length == 0)) {
      return 0
    }
    val firstChar: Char = str.charAt(0)
    var sign: Int = 1
    var start: Int = 0
    val len: Int = str.length
    var sum: Long = 0
    if (firstChar == '+') {
      sign = 1
      start += 1
    }
    else {
      if (firstChar == '-') {
        sign = -1
        start += 1
      }
    }
    var i: Int = start
    while (i < len) {
      if (!Character.isDigit(str.charAt(i))) {
        return sum.toInt * sign
      }
      sum = sum * 10 + str.charAt(i) - '0'
      if (sign == 1 && sum > Integer.MAX_VALUE) {
        return Integer.MAX_VALUE
      }
      if (sign == -1 && (-1) * sum < Integer.MIN_VALUE) {
        return Integer.MIN_VALUE
      }
      i += 1
    }
    sum.toInt * sign
  }
}
