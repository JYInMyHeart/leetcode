package bst

object SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {
    def invertTree(root: TreeNode): TreeNode = {
      if(root == null) return null
      val temp = new TreeNode(root.value)
      temp.left = invertTree(root.right)
      temp.right = invertTree(root.left)
      temp
    }
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
      if(p == null && q == null) return true
      if(p == null || q == null) return false
      p.value == q.value && isSameTree(p.left,q.left) && isSameTree(p.right,q.right)
    }
    if(root == null) return true
    val left = invertTree(root.left)
    isSameTree(left,root.right)
  }
  def isSymmetric1(root: TreeNode): Boolean = {
    def isMirror(root:TreeNode,root1:TreeNode):Boolean = {
      if(root == null && root1 == null) return true
      if(root == null || root1 == null) return false
      if(root.value == root1.value)
        isMirror(root.left,root1.right) && isMirror(root.right,root1.left)
      else
        false
    }
    isMirror(root,root)
  }

}
