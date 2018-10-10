package array

import scala.collection.mutable

object FourSum extends App{
  //this solution will be TLE.It's too slow to finish this question.
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
      var res:mutable.Stack[List[Int]] = mutable.Stack()
      var t:mutable.Stack[Int] = mutable.Stack()
      def dfs(candidates: Array[Int], target: Int,s:Int,temp:mutable.Stack[Int],res:mutable.Stack[List[Int]]): Unit ={
        if(temp.size == 4 && target == temp.sum){
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
      dfs(tt,target,0,t,res)
      res.distinct.toList
  }

  def fourSum1(num: Array[Int], target: Int): List[List[Int]] = {
    import scala.collection.mutable.ListBuffer
    val nums = num.sorted
    val ans = ListBuffer[List[Int]]()
    for(i <- 0 until nums.length - 1){
      for(j <- (i + 1) until nums.length - 1){
        var lo = j + 1
        var hi = nums.length - 1
        val sum = target - nums(i) - nums(j)
        while (lo < hi){
          if(nums(lo) + nums(hi) == sum){
            ans += List(nums(lo),nums(hi),nums(i),nums(j))
            lo += 1
            hi -= 1
          }else if(nums(lo) + nums(hi) < sum)
            lo += 1
          else
            hi -= 1
        }
      }
    }
    ans.toList.distinct
  }

//  println(fourSum(Array(-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492), 6189))
  println(fourSum1(Array(-493,-482,-482,-48,383,413,431,471,474,481,492), 492 + 471 + 413 + 481))
}
