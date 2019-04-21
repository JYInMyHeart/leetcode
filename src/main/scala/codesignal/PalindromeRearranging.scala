package codesignal

object PalindromeRearranging {
  def palindromeRearranging(inputString: String): Boolean = {
    inputString.distinct.map(x => inputString.count(x == _)).count(_ % 2 != 0) <= 1
  }
}
