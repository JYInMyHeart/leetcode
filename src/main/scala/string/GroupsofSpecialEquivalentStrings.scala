package string


object GroupsofSpecialEquivalentStrings extends App{
  def numSpecialEquivGroups(A: Array[String]): Int = {

    import scala.collection.mutable
    val seen = new mutable.HashSet[String]()
    for (s <- A) {
      val count: Array[Int] = new Array[Int](52)
      var i: Int = 0
      while (i < s.length) {
        count(s.charAt(i) - 'a' + 26 * (i % 2)) += 1
        i += 1
      }
      seen.add(count.:\("")(_+_))
    }
    seen.size
  }

  println(Array(1, 2, 3).toString)
}
