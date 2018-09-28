package bst

object MinimumDistanceBetweenBSTNodes {
  def minDiffInBST(root: TreeNode): Int = {
    var res = Int.MaxValue
    var pre:TreeNode = null

    def helper(root: TreeNode): Unit = {
      if(root == null) return
      helper(root.left)
      if (pre != null) res = math.min(res, root.value - pre.value)
      pre = root
      helper(root.right)
    }
    helper(root)
    res
  }
}
