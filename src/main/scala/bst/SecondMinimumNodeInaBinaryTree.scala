package bst



object SecondMinimumNodeInaBinaryTree {
  import scala.collection.mutable

  def findSecondMinimumValue(root:TreeNode ):Int = {
    def dfs(root: TreeNode,uniques:mutable.HashSet[Int]): Unit = {
      if (root != null) {
        uniques += root.value
        dfs(root.left, uniques)
        dfs(root.right, uniques)
      }
    }
    val uniques =  mutable.HashSet[Int]()
    dfs(root, uniques);

    val min1 = root.value;
    var ans = Long.MaxValue;
    for ( v <- uniques) {
      if (min1 < v && v < ans) ans = v
    }
    if (ans < Long.MaxValue )ans.toInt else -1
  }
}
