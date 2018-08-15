package array



object AdvantageShuffle extends App {
  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    //TLE  i don't know how to optimize
    import scala.collection.mutable.Stack
    var i = 0
    val t = Stack[Int](A:_*)
    B.foreach(
      x => {
        A(i) =
          if (t.exists(_ > x)) {
            val temp = t.filter(_ > x).min
            t(t.indexOf(temp)) = Int.MinValue
            temp
          } else {
            val tt = t.filter(_ != Int.MinValue).min
            t(t.indexOf(tt)) = Int.MinValue
            tt
          }
        i += 1
      }
    )
    A
  }

  val a = Array(2, 0, 4, 1, 2)
  val b = Array(1, 3, 0, 0, 2)
  advantageCount(a, b).foreach(print)
}
