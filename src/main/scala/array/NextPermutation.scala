package array

object NextPermutation {
  def nextPermutation(nums: Array[Int]): Unit = {
    for(i <- nums.indices){
      var failed = true
      for(j <- i + 1 until nums.length){
        if(nums(j) > nums(i)){
          failed = false
        }
      }
      if(failed && i < nums.length - 1){
        val tmp = nums(i - 1)
        nums(i - 1) = nums(i)
        nums(i) = tmp
        return
      }else{
        nums.reverse
        return
      }
    }
  }
}
