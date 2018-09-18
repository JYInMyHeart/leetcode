package array

object BinaryNumberwithAlternatingBits {
  def hasAlternatingBits(n: Int): Boolean = {
    val temp = n.toBinaryString.toCharArray
    for(i <- 1 until temp.length){
      if(temp(i) == temp(i - 1))
        return false
    }
    true
  }

  def hasAlternatingBits1(n:Int):Boolean = {
    var N = n
    var cur = N % 2
    N /= 2
    while (N > 0) {
      if (cur == N % 2) return false
      cur = N % 2
      N /= 2
    }
    true
  }
}
