package bst

object MaximumDepthofBinaryTree {
  def maxDepth(root: TreeNode): Int = {
    if(root == null) return 0
    math.max(maxDepth(root.left) + 1,maxDepth(root.right) + 1)
  }
}
