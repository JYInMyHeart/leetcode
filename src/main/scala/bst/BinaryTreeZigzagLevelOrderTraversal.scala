package bst

import scala.collection.mutable

object BinaryTreeZigzagLevelOrderTraversal {
  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    var ans = List[List[Int]]()
    var flag = true
    if(root == null) return ans
    val queue = new mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while(queue.nonEmpty){
      var temp = List[Int]()
      for(_ <- queue.indices){
        val  node = queue.dequeue()
        if(flag)
          temp :+= node.value
        else
          temp +:= node.value
        if(node.left != null) queue.enqueue(node.left)
        if(node.right != null) queue.enqueue(node.right)
      }
      flag = !flag
      ans :+= temp
    }
    ans
  }
}
