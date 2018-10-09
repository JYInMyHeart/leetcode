package bst

object BinaryTreeTilt {
  def findTilt(root: TreeNode): Int = {
    var ans = 0
    def helper(root:TreeNode):Int = {
      if(root == null) return 0
      val left = helper(root.left)
      val right = helper(root.right)
      ans += math.abs(left - right)
      root.value + left + right
    }
    helper(root)
  }
}
