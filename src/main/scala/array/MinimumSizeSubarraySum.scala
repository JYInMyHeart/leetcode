package array

object MinimumSizeSubarraySum extends App {
  //all the contiguous sub array problems's general idea is maintaining a sliding window.
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    if(nums.isEmpty) return 0
    //outer loop index
    var i = 0
    //sub array's target value
    var value = 0
    //result
    var size = Int.MaxValue
    //inner loop index
    var j = 0
    while(i < nums.length){
      //first add nums's element until value >= target value
      value += nums(i)
      //then calculate the sub array's size
      //`j <= i`  is just for the sliding window remove left value.
      while(j <= i && value >= s ){
        size = math.min(size, i - j + 1)
        //the sliding window remove left value and then it will get new right value until value >= target value
        value -= nums(j)
        j += 1
      }
      i += 1
    }
    //finally u can get the result. check it if the whole array's sum still < target value.
    // it should return 0.otherwise it will get the sliding window's min size
    if(size == Int.MaxValue) 0 else size
  }

  println(minSubArrayLen(7, Array(2,3,1,2,4,3)))
}
