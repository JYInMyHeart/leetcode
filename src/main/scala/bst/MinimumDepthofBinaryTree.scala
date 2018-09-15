package bst

object MinimumDepthofBinaryTree {
  var min = Int.MaxValue
  def minDepth(root: TreeNode): Int = {
    if(root == null) return 1
    val left = minDepth(root.left)
    val right = minDepth(root.right)
   if(root.left == null || root.right == null) left + right + 1 else math.min(left,right) + 1
  }
}
