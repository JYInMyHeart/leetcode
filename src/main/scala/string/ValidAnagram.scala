package String



object ValidAnagram {
  def isAnagram(s: String, t: String): Boolean = {
    import scala.collection.mutable
    if(s.length != t.length) return false
    val map = new mutable.HashMap[Char,Int]()
    for(i <- s){
      if(map.contains(i))
        map += i -> (map(i) + 1)
      else
        map += i -> 1
    }
    for(i <- t){
      if(map.contains(i)){
        map += i -> (map(i) - 1)
      }
    }
    map.count(_._2 != 0) <= 0
  }
}
