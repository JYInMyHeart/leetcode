package dp

object PushDominoes extends App {
  def pushDominoes(dominoes: String): String = {
    val N = dominoes.length
    val indexes = new Array[Int](N + 2)
    val symbols = new Array[Char](N + 2)
    var len = 1
    indexes(0) = -1
    symbols(0) = 'L'

    var i = 0
    while (i < N) {
      if (dominoes.charAt(i) != '.') {
        indexes(len) = i
        symbols(len) = dominoes.charAt(i)
        len += 1
      }

      i += 1
    }

    indexes(len) = N
    symbols(len) = 'R'
    len += 1

    val ans = dominoes.toCharArray
    var index = 0
    while (index < len - 1) {
      val i = indexes(index)
      val j = indexes(index + 1)
      val x = symbols(index)
      val y = symbols(index + 1)
      val write = 0
      if (x == y) {
        var k = i + 1
        while (k < j) {
          ans(k) = x
          k += 1
        }
      }
      else if (x > y) { // RL
        var k = i + 1
        while (k < j) {
          ans(k) = if (k - i == j - k) '.'
          else if (k - i < j - k) 'R'
          else 'L'
          k += 1
        }
      }
      index += 1
    }
    new String(ans)
  }

  println(pushDominoes(".L.R...LR..L.."))
}
