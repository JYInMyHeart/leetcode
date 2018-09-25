package array

import scala.collection.mutable

object MajorityElement {
  def majorityElement(nums: Array[Int]): Int = {
    val map = new mutable.HashMap[Int,Int]()
    for(i <- nums){
      if(map.contains(i))
        map += i -> (map(i) + 1)
      else
        map += i -> 1
    }
    map.find(_._2 > nums.length / 2).get._1
  }
}
