package array

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
}
