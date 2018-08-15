package array

object LongestConsecutiveSequence extends App {
  def longestConsecutive(nums: Array[Int]): Int = {
    if(nums.isEmpty) return 0
    //Using sorted is really not a good solution.
    //We should consider using hashmap. It's a strong data structure.
    val t = nums.sorted.distinct
    var i = 0
    var c = 1
    var max = 1
    while(i < t.length - 1){
      if(t(i) + 1 == t(i + 1)){
        c += 1
        max = math.max(c,max)
      }else{
        c = 1
      }
      i += 1
    }
    max
  }

  println(longestConsecutive(Array(100,200,2,1,4,3)))
  println(longestConsecutive(Array(0,-1)))
  println(longestConsecutive(Array(1,2,0,1)))
}
