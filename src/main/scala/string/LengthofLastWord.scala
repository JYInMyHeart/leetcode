package String

object LengthofLastWord {
  def lengthOfLastWord(s: String): Int = {
    val strs = s.split(" ")
    if(strs.isEmpty)  0
    else  strs.last.length
  }
}
