package bst

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object PathSumII {
  def pathSum(root: TreeNode, sum: Int): List[List[Int]] = {
    val currentResult = ListBuffer[Int]()
    val result = ListBuffer[List[Int]]()
    pathSum1(root, sum, currentResult, result)
    result.map(_.toList).toList
  }

  def pathSum1(root: TreeNode, sum: Int, currentResult: ListBuffer[Int], result: ListBuffer[List[Int]]): Unit = {
    if (root == null) return
    currentResult += root.value
    if (root.left == null && root.right == null && sum == root.value) {
      result += List(currentResult:_*)
      currentResult -= currentResult.last //don't forget to remove the last integer
      return
    }
    else {
      pathSum1(root.left, sum - root.value, currentResult, result)
      pathSum1(root.right, sum - root.value, currentResult, result)
    }
    currentResult -= currentResult.last
  }
}
