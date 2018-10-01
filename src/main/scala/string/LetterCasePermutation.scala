package string



object LetterCasePermutation extends App{
  def letterCasePermutation(S: String): List[String] = {
    import scala.collection.mutable
    if (S == null) return List[String]()
    val queue = new mutable.Queue[String]
    queue.enqueue(S)

    for (i <- 0 until S.length) {
      if (!Character.isDigit(S.charAt(i))) {
        val size = queue.size
        for (j <- 0 until size) {
          val cur = queue.dequeue
          val chs = cur.toCharArray
          chs(i) = Character.toUpperCase(chs(i))
          queue.enqueue(chs.:\("")(_ + _))
          chs(i) = Character.toLowerCase(chs(i))
          queue.enqueue(chs.:\("")(_ + _))
        }
      }
    }
    queue.toList
  }

  println(letterCasePermutation("abc"))
}
