package string

object IsomorphicString {
  def isIsomorphic(s1: String, s2: String): Boolean = {
    val m = new Array[Int](512)
    var i = 0
    while (i < s1.length) {
      if (m(s1.charAt(i)) != m(s2.charAt(i) + 256)) return false
      m(s1.charAt(i)) = i + 1
      m(s2.charAt(i) + 256) = i + 1
      i += 1
    }
    true
  }
}
