package string

object ExcelSheetColumnNumber {
  def titleToNumber(s: String): Int = {
    var sum = 0
    for(i <- 0 until s.length){
      sum += math.pow(26,s.length - 1 - i).toInt * (s.charAt(i) - 'A')
    }
    sum
  }
}
