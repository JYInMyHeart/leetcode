package array

import scala.collection.mutable.ListBuffer


object ThreeSum extends App {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    var res:mutable.Stack[List[Int]] = mutable.Stack()
    var t:mutable.Stack[Int] = mutable.Stack()
    def dfs(candidates: Array[Int], target: Int,s:Int,temp:mutable.Stack[Int],res:mutable.Stack[List[Int]]): Unit ={
      if(temp.size == 3 && target == temp.sum){
        res push temp.toList
        return
      }
      var i = s
      while(i < candidates.length){
        temp.push(candidates(i))
        dfs(candidates,target,i + 1,temp,res)
        temp.pop()
        i += 1
      }
    }
    val tt = nums.sorted
    dfs(tt,0,0,t,res)
    res.distinct.toList
  }
  def threeSum1(num: Array[Int]): List[List[Int]] = {
    val nums = num.sorted
    val ans = ListBuffer[List[Int]]()
    for(i <- 0 until nums.length - 1){
      if (i == 0 || (i > 0 && nums(i) != nums(i-1))) {
        var lo = i + 1
        var hi = nums.length - 1
        var sum = -nums(i)
        while (lo < hi){
          if(nums(lo) + nums(hi) == sum){
            ans += List(nums(lo),nums(hi),nums(i))
            while(lo < hi && nums(lo) == nums(lo + 1)) lo += 1
            while(lo < hi && nums(hi) == nums(hi - 1)) hi -= 1
            lo += 1
            hi -= 1
          }else if(nums(lo) + nums(hi) < sum)
            lo += 1
          else
            hi -= 1
        }
      }
    }
    ans.toList
  }

  val a = Array(-1,0,1,2,-1,-4)

  threeSum1(a)
}
