package bst

object PathSum {
  def hasPathSum(root: TreeNode, sum: Int): Boolean = {
    if(root == null) return false
    if(root.left == null && root.right == null && sum == root.value) return true
    hasPathSum(root.left,sum - root.value) || hasPathSum(root.right,sum - root.value)
  }
}
