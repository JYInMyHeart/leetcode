package bst

object InvertBinaryTree {
  def invertTree(root: TreeNode): TreeNode = {
    if(root == null) return null
    val temp = new TreeNode(root.value)
    temp.left = invertTree(root.right)
    temp.right = invertTree(root.left)
    temp
  }
}
