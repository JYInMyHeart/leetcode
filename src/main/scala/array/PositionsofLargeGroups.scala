package array

object PositionsofLargeGroups {
  def largeGroupPositions(S: String): List[List[Int]] = {
    var i = 0
    var j = 1
    var res = List[List[Int]]()
    while(j < S.length){
      if(S(i) == S(j)){
        var tempList = List[Int]()
        tempList :+= i
        while(j < S.length && S(i) == S(j)){
          j += 1
        }
        tempList :+= j - 1
        if(j - i >= 3)
          res :+= tempList
        i = j - 1
      }else{
        i += 1
        j += 1
      }
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val s1 = "abbxxxxzzy"
    val s2 = "abcdddeeeeaabbbcd"
    val s = "aabbbcd"
    println(largeGroupPositions(s2))
  }
}
