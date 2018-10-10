package string

object IntegertoRoman {
  def intToRoman(num: Int): String = {
    val M = Array("", "M", "MM", "MMM")
    val C = Array("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val X = Array("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val I = Array("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    M(num / 1000) + C((num % 1000) / 100) + X((num % 100) / 10) + I(num % 10)
  }
}
