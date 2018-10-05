package bst

object BalancedBinaryTree {
  def isBalanced(root: TreeNode): Boolean = {
    def sizeMax(root: TreeNode): Int = {
      if (root == null) return 0
      math.max(sizeMax(root.right), sizeMax(root.left)) + 1
    }
    if(root == null) return true
    (
      math.abs(sizeMax(root.left) - sizeMax(root.right)) <= 1
        && isBalanced(root.left)
        && isBalanced(root.right)
      )
  }
}
