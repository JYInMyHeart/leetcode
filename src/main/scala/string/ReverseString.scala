package string

object ReverseString {
  def reverseString(s: Array[Char]): Unit = {
    var j = s.length - 1
    var i = 0
    while(i < j){
      val tmp = s(i)
      s(i) = s(j)
      s(j) = tmp
      j -= 1
      i += 1
    }

    def demo(s:Array[Char]):Unit = {
      val tmp = s.reverse
      for(i <- tmp.indices){
        s(i) = tmp(i)
      }
    }
  }


}
