package String

object FindtheDifference {
  def findTheDifference(s: String, t: String): Char = {
    s.toCharArray.:\(t.toCharArray.:\(0)(_^_))(_^_).toChar
    //another soultion
    //s.concat(t).toCharArray.:\(0)(_^_).toChar
  }
}
