package string

object UncommonWordsfromTwoSentences extends App {
  def uncommonFromSentences(A: String, B: String): Array[String] = {
    val as = A.split(" ")
    val bs = B.split(" ")
    val ans =  for(b <- bs;a <- as)
      yield {
        if(!as.contains(b) && bs.count(_ == b) == 1) b
        else if(!bs.contains(a) && as.count(_ == a) == 1) a
        else ""
      }
    ans.distinct.filter(_ != "")
  }

  /*
  * "d b zu d t"
"udb zu ap"*/
  uncommonFromSentences("d b zu d t","udb zu ap")
}
