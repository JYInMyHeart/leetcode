package String

object IsPalindrome extends App{
  def isPalindrome(s: String): Boolean = {
    if(s.isEmpty) return true
    var t = s.filter(x => Character.isAlphabetic(x) || Character.isDigit(x)).map(_.toLower)
    if(t.length == 1) return true
    if(t.isEmpty) return true
    val n = t.length / 2
    val s1 = t.substring(0,n)
    val s2 = t.substring(n)
    val s3 = t.substring(n + 1)
    s1.nonEmpty && (s1 == s2.reverse || s1 == s3.reverse)
  }

//  println(isPalindrome("A man, a plan, a canal: Panama"))
  println(isPalindrome("0P"))
}
