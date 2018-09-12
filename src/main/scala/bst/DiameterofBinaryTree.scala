package bst

object DiameterofBinaryTree extends App {
  var max = 0
  def diameterOfBinaryTree(root: TreeNode): Int = {
    var ans = 0
    def helper(root:TreeNode):Int = {
      if(root == null) return 0
      val l = helper(root.left)
      val r = helper(root.right)
      ans = math.max(ans,l + r + 1)
      math.max(l,r) + 1
    }
    helper(root)
    ans
  }
}
