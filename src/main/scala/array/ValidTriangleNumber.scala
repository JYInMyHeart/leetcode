package array

import scala.collection.mutable.Stack

object ValidTriangleNumber extends App{
  def triangleNumber1(nums: Array[Int]): Int = {
    val res:Stack[Stack[Int]] = Stack()
    val t:Stack[Int] = Stack()
    def dfs(candidates: Array[Int], s:Int,temp:Stack[Int],res:Stack[Stack[Int]]): Unit ={
      if(temp.size == 3 && temp.takeRight(2).sum > temp.head){
        res push temp
        return
      }
      var i = s
      while(i < candidates.length){
          temp.push(candidates(i))
          dfs(candidates,i + 1,temp,res)
          temp.pop()
        i += 1
      }
    }
    val tt = nums.sorted
    dfs(tt,0,t,res)
    res.size
  }
  def triangleNumber(nums: Array[Int]): Int = {
    val tt = nums.sorted
    var i = 0
    var count = 0
    while(i < nums.length - 2){
      var j =  i + 1
      while(j < nums.length - 1){
        var k = j + 1
        while(k < nums.length){
          if(tt(i) + tt(j) > tt(k)){
            count += 1
          }
          k += 1
        }
        j += 1
      }
      i += 1
    }
    count
  }

  println(triangleNumber(Array(2,2,3,4,4,2,2,3,4,4,2,2,3,4,4,2,2,3,4,4,2,2,3,4,4,2,2,3,4,2,2,3,4,4,2,2,3,4,4,2,2,3,4,4,2,2,3,4,4)))
  println(triangleNumber(Array(0,1,0)))
  println(triangleNumber(Array(2,2,3,4)))

//  StackStack
}
