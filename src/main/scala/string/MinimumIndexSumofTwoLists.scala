package string



object MinimumIndexSumofTwoLists {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
    import scala.collection.mutable
    val map = mutable.HashMap[String,Int]()
    for(i <- list1.indices){
      val temp = list2.indexOf(list1(i))
      if(temp > -1)
        map += list1(i) -> (i + temp)
    }
    map.filter(_._2 > map.minBy(_._2)._2).keys.toArray
  }
}
