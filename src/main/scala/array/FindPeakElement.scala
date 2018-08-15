package array

object FindPeakElement {
  def findPeakElement(nums: Array[Int]): Int = {
    if(nums.length < 2) return  0
    var i = 1
    if(nums(0) > nums(1)) return 0
    if(nums.last > nums(nums.length - 2)) return  nums.length - 1
    while(i < nums.length - 1){
      if(nums(i) > nums(i + 1) && nums(i) > nums(i - 1)){
        return nums.indexOf(nums(i))
      }
      i += 1
    }
    0
  }
}
