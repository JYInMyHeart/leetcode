package bst

object SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean = {
    def invertTree(root: TreeNode): TreeNode = {
      if (root == null) return null
      val temp = new TreeNode(root.value)
      temp.left = invertTree(root.right)
      temp.right = invertTree(root.left)
      temp
    }
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
      if (p == null && q == null) return true
      if (p == null || q == null) return false
      p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right,
                                                                     q.right)
    }
    if (root == null) return true
    val left = invertTree(root.left)
    isSameTree(left, root.right)
  }
  def isSymmetric1(root: TreeNode): Boolean = {
    def isMirror(root: TreeNode, root1: TreeNode): Boolean = {
      if (root == null && root1 == null) return true
      if (root == null || root1 == null) return false
      if (root.value == root1.value)
        isMirror(root.left, root1.right) && isMirror(root.right, root1.left)
      else
        false
    }
    isMirror(root, root)
  }

  def isSymmetric2(root: TreeNode): Boolean = {
    import scala.collection.mutable
    if (root == null) return true
    val stack = mutable.Stack[TreeNode]()
    if (root.left != null) {
      if (root.right == null) return false
      stack.push(root.left)
      stack.push(root.right)
    } else if (root.right != null)
      return false

    while (stack.nonEmpty) {
      if (stack.size % 2 != 0) return false
      val right = stack.pop()
      val left = stack.pop()

      if (left.value != right.value) return false
      if (left.left != null) {
        if (right.right == null) return false
        stack.push(left.left)
        stack.push(right.right)
      } else if (right.right != null)
        return false
      if (left.right != null) {
        if (right.left == null) return false
        stack.push(left.right)
        stack.push(right.left)
      } else if (right.left != null)
        return false
    }
    true
  }

}
