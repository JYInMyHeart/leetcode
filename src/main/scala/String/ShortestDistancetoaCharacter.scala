package String

object ShortestDistancetoaCharacter extends App {
  def shortestToChar(S: String, C: Char): Array[Int] = {
    var index = 0
    var cs = List[Int]()
    while(S.indexOf(C.toString,index) != -1){
      val t = S.indexOf(C.toString,index)
      cs :+= t
      index = t + 1
    }
    (for(i <- S.indices)
      yield cs.map(x => math.abs(x - i)).min).toArray
  }

  println(shortestToChar("loveleetcode", 'e'))
}
