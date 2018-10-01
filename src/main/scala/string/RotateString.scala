package string

object RotateString extends App {
  def rotateString(A: String, B: String): Boolean = {
    if(A == B) return true
    var start = A.indexOf(B.head)
    for(i <- B){
      start += 1
      if(i != A.charAt(start % A.length))
        return false
    }
    true
  }

  rotateString("gcmbf","fgcmb")
}
