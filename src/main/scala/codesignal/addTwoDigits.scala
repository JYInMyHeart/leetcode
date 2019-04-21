package codesignal

object addTwoDigits {
  def addTwoDigits(n: Int): Int = {
    val str = n.toString
    var sum = 0
    for(i <- str) sum += (i - '0')
    sum
  }

}
