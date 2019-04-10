package bst

object CountUnivalSubtrees {
  def countUnivalSubtrees(root: TreeNode): Int = {
    if (root == null) return 0
    if (isunivalTree(root, root.value))
      1 + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right)
    else countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right)
  }

  def isunivalTree(root: TreeNode, value: Int): Boolean = {
    if (root == null) return true
    if (root.value == value) {
      return isunivalTree(root.left, value) && isunivalTree(root.right, value)
    }
    false
  }
}
