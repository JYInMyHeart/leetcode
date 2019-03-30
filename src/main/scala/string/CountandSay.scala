package string

object CountandSay {
  def countAndSay(n: Int): String = {
    var curr = new StringBuilder("1")
    var prev: StringBuilder = null
    var count = 0
    var say:Char = ' '
    var i = 1
    while (i < n) {
      prev = curr
      curr = new StringBuilder
      count = 1
      say = prev.charAt(0)
      var j = 1
      val len = prev.length
      while (j < len) {
        if (prev.charAt(j) != say) {
          curr.append(count).append(say)
          count = 1
          say = prev.charAt(j)
        } else {
          count += 1
        }
        j += 1
      }
      curr.append(count).append(say)
      i += 1
    }
    curr.toString()
  }
}
