package array

object SortColors extends App{
  def sortColors(nums: Array[Int]): Unit = {
    var i = 0
    var c1 = 0
    var c2 = 0
    while(i < nums.length){
      val v = nums(i)
      nums(i) = 2
      if (v < 2 ){
        nums(c2) = 1
        c2 += 1
      }
      if(v == 0){
        nums(c1) = 0
        c1 += 1
      }
      i += 1
      nums.foreach(print)
      println()
    }
  }

  sortColors(Array(2,0,2,1,1,0))
//  sortColors(Array(2,0,1))
}
