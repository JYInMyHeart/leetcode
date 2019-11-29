package string

import scala.collection.mutable


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


  def findRestaurant1(list1: Array[String], list2: Array[String]): Array[String] = {
    val map = mutable.HashMap[String,Int]()
    for (i <- list1.indices) {
      map.put(list1(i), i)
    }
    var min = Integer.MAX_VALUE
    val list = mutable.HashSet[String]()
    for (i <- list2.indices) {
      if (map.contains(list2(i))) {
        if ((i + map(list2(i))) < min) {
          list.clear
          list.add(list2(i))
          min = i + map(list2(i))
        }
        if ((i + map(list2(i))) == min) list.add(list2(i))
      }
    }
    list.toArray
  }
}
