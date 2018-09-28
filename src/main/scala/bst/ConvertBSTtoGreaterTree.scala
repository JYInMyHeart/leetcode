package bst

object ConvertBSTtoGreaterTree {
  def convertBST(root: TreeNode): TreeNode = {
    var sum:Int = 0
    def helper(root: TreeNode): TreeNode = {
      if (root != null) {
        convertBST(root.right)
        sum += root.value
        root.value = sum
        convertBST(root.left)
      }
      root
    }
    helper(root)
  }
}
