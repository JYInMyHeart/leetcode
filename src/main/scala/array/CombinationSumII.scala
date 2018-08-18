package array

object CombinationSumII extends App {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    import scala.collection.mutable

    var res: mutable.Stack[List[Int]] = mutable.Stack()
    var t: mutable.Stack[Int] = mutable.Stack()

    def dfs(candidates: Array[Int],
            target: Int,
            s: Int,
            temp: mutable.Stack[Int],
            res: mutable.Stack[List[Int]]): Unit = {
      if (target == 0) {
        res push temp.toList
        return
      }
      var i = s
      while (i < candidates.length) {
        if (target >= candidates(i)) {
          temp.push(candidates(i))
          dfs(candidates, target - candidates(i), i + 1, temp, res)
          temp.pop()
        }
        i += 1
      }
    }

    val tt = candidates.sorted
    dfs(tt, target, 0, t, res)
    res.distinct.toList
  }
}
