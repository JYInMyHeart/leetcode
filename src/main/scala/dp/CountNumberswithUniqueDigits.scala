package dp

object CountNumberswithUniqueDigits extends App {
  def countNumbersWithUniqueDigits(n: Int): Int = {
    var N = n
    if (n == 0) return 1
    var res = 10
    var uniqueDigits = 9
    var availableNumber = 9
    while (N > 1 && availableNumber > 0) {
      uniqueDigits = uniqueDigits * availableNumber
      res += uniqueDigits
      availableNumber -= 1
      N -= 1
    }
    res
  }

  println(countNumbersWithUniqueDigits(3))

}
