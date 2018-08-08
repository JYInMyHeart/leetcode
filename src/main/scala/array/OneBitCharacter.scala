package array

object OneBitCharacter {
  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    if(bits.indexOf(1) == -1) return true
    def li(m:Int,a:Array[Int]):Boolean = {
      val l = a.length - 1
      a.indexOf(0,m) match {
        case `l`  => if ((a.length - m) % 2 != 0) true else false
        case n => li(n + 1,a)
        case _ => false
      }
    }
    li(0,bits)
  }

  def isOneBitCharacter1(bits: Array[Int]): Boolean = {
    val n = bits.length - 1
    var i = 0
    while(i < n){
      if(bits(i) == 0) i += 1
      else i += 2
    }
    i == n
  }

  def main(args: Array[String]): Unit = {
    val a = Array(0,1,0)
    println(isOneBitCharacter1(a))
  }

}
