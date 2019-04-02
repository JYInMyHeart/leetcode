package bst

object IsValidBST {
  def isValidBST(root: TreeNode): Boolean = {
    helper(root,Long.MaxValue,Long.MaxValue)
  }

  def helper(root:TreeNode,min:Long,max:Long) :Boolean = {
    if(root == null) return true
    if(min != Long.MaxValue && root.value <= min) return false
    if(max != Long.MaxValue && root.value >= max) return false
    return helper(root.left,min,root.value) && helper(root.right,root.value,max)
  }
}
