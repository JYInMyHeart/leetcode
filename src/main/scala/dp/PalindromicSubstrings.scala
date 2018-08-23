package dp

object PalindromicSubstrings extends App {
  def countSubstrings(s: String): Int = {
    var count = 0
    val chars = s.toCharArray
    for (i <- chars.indices) {
      var j = i
      val sb: StringBuilder = new StringBuilder()
      while (j < chars.length) {
        sb.append(chars(j))
        if (isPalindromic(sb.toString())) {
          count += 1
        }
        j += 1
      }
    }

    def isPalindromic(str: String): Boolean = {
      val chars = str.toCharArray
      for (i <- chars.indices) {
        if (chars(i) != chars(chars.length - 1 - i))
          return false
      }
      true
    }

    count
  }

  //a more smart solution
  def countSubstrings1(s: String): Int = {
    //judge a number whether is palindromic.u can start at pivot.
    def countPalindromic(str: String, left: Int, right: Int) = {
      var i = left
      var j = right
      while (i >= 0 && j < str.length && str(i) == str(j)) {
        count += 1
        i -= 1
        j += 1
      }
    }

    var count = 0
    for (i <- s.toCharArray.indices) {
      countPalindromic(s, i, i + 1)
      countPalindromic(s, i, i)
    }
    count
  }


  println(countSubstrings1("aaa"))
}
