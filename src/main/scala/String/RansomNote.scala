package String

import scala.collection.mutable

object RansomNote {
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val mapv = new mutable.HashMap[Char, Int]()
    magazine.foreach(
      x =>
        if (mapv.contains(x))
          mapv += x -> (mapv(x) + 1)
        else mapv += x -> 1
    )
    ransomNote.foreach(
      x =>
        if (mapv.contains(x))
          mapv += x -> (mapv(x) - 1)
        else
          return false
    )
    !(mapv.count(_._2 < 0) > 0)
  }
}
