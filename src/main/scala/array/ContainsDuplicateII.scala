package array

import scala.collection.mutable

object ContainsDuplicateII extends App {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    var i = 0
    while( i < nums.length){
      var j = i + 1
      while(j < nums.length){
        if(nums(i) == nums(j) && j - i <= k){
          return true
        }
        j += 1
      }
      i += 1
    }
    false
  }


  import java.util

  def containsNearbyDuplicate1(nums: Array[Int], k: Int): Boolean = {
    val map = mutable.HashMap[Int,Int]()
    var list = List[Int]()
    for (i <- nums.indices) {
      if (map.contains(nums(i))) list :+= (i - map(nums(i)))
      map += (nums(i) -> i)
    }
    list.exists(_ <= k)
  }
}
