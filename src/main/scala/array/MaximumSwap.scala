package array

object MaximumSwap extends App{
  def maximumSwap(num: Int): Int = {
    var t = num.toString
    val max = t.max
    val index = t.indexOf(max)
    t = t.replaceFirst(max.toString,t.head.toString)
    t = t.replaceFirst(t.head.toString,max.toString)
    t.toInt
  }

  println(maximumSwap(2736))
}
