package string

object CountBinarySubstrings extends App {
  def countBinarySubstrings(s: String): Int = {
    var ans = 0
    var prev = 0
    var cur = 1
    for ( i <- 1 until s.length) {
      if (s.charAt(i - 1) != s.charAt(i)) {
        ans += math.min(prev, cur)
        prev = cur
        cur = 1
      }
      else cur += 1
    }
    ans + math.min(prev, cur)
  }

  println(countBinarySubstrings("110001111000000"))
}
