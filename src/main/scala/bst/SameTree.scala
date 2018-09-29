package bst



object SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if(p == null && q == null) return true
    if(p == null || q == null) return false
    p.value == q.value && isSameTree(p.left,q.left) && isSameTree(p.right,q.right)
  }

  def isSameTree1(p: TreeNode, q: TreeNode): Boolean = {
    import scala.collection.mutable
    val stack = new mutable.Stack[TreeNode]()
    var ans = true
    stack.push(p)
    stack.push(q)
    while(stack.nonEmpty){
      val node1 = stack.pop()
      val node2 = stack.pop()
      if(node1 == null && node2 == null) ans = true
      else if(node1 == null || node2 == null || node1.value != node2.value) return false
      else{
        stack.push(node1.left)
        stack.push(node2.left)
        stack.push(node1.right)
        stack.push(node2.right)
      }
    }
    ans
  }
}
