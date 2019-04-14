package array

object OrderedCount {
  def orderedCount(chars: String): List[(Char, Int)] = {
    (for(c <- chars.toCharArray.distinct) yield (c,chars.count(_ == c))).toList
  }
}
