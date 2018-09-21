package array

import bst.TreeNode



object TwoSumIVInputisaBST {
  def findTarget(root: TreeNode, k: Int): Boolean = {
    import scala.collection.mutable
    val set = mutable.HashSet[Int]()
    val queue = mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while (queue.nonEmpty) {
      val node = queue.dequeue()
      if (set.contains(k - node.value)) return true
      set.add(node.value)
      if (node.right != null) queue.enqueue(node.right)
      if (node.left != null) queue.enqueue(node.left)
    }
    false
  }
}
