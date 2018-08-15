package array

object SubsetsII extends App {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    var res: mutable.Stack[List[Int]] = mutable.Stack()
    var t: mutable.Stack[Int] = mutable.Stack()

    def dfs(candidates: Array[Int], s: Int, temp: mutable.Stack[Int], res: mutable.Stack[List[Int]]): Unit = {
      res push temp.toList
      var i = s
      while (i < candidates.length)  {
        if (i > s && (nums(i) == nums(i - 1))){//remove duplicate elements
        }else{
          temp.push(candidates(i))
          dfs(candidates, i + 1, temp, res)
          temp.pop()
        }
        i += 1
      }
    }
    val tt = nums.sorted
    dfs(tt, 0, t, res)
    res push List[Int]()
    res.toList
  }

  subsetsWithDup(Array(1, 2, 2))


}
