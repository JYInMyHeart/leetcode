package bst



object LeafSimilarTrees extends App {
  def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {
    import scala.collection.mutable
    def helper(root:TreeNode,stack:mutable.Stack[Int]):Unit = {
      if(root == null) return
      if(root.left == null && root.right == null)
        stack.push(root.value)
      if(root.left != null) helper(root.left,stack)
      if(root.right != null) helper(root.right,stack)
    }
    val stack1 = mutable.Stack[Int]()
    val stack2 = mutable.Stack[Int]()
    helper(root1,stack1)
    helper(root2,stack2)
    if(stack1.length == stack2.length){
      for(i <- stack1.indices)
        if(stack1.pop() != stack2.pop())
          return false
      return true
    }else
      false
  }
}
