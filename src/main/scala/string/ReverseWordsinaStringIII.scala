package string

object ReverseWordsinaStringIII {
  def reverseWords(s: String): String = {
    s.split(" ").map(_.reverse + " ").:\(" ")(_+_).trim
  }
}
