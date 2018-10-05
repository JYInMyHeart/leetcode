package bst

object BinaryTreeLevelOrderTraversalII {
  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    import scala.collection.mutable
    var ans = List[List[Int]]()
    if(root == null) return ans
    val queue = mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while(queue.nonEmpty){
      var temp = List[Int]()
      for(_ <- queue.indices){
        val node = queue.dequeue()
        temp :+= node.value
        if(node.left != null) queue.enqueue(node.left)
        if(node.right != null) queue.enqueue(node.right)
      }
      ans :+= temp
    }
    ans
  }
}
