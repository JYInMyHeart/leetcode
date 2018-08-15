package array

object FindPivotIndex extends App {
  def pivotIndex(nums: Array[Int]): Int = {
    var i = 0
    while(i < nums.length){
      if(nums.take(i).sum == nums.drop(i + 1).sum)
        return i
      i += 1
    }
    -1
  }
}
