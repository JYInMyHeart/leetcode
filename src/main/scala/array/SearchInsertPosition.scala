package array

object SearchInsertPosition extends App {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    var i = 0
    while(i < nums.length){
      if(target > nums(i)){
        i += 1
      }else {
        return i
      }
    }
    i
  }
}
