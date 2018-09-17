package bst

import scala.collection.mutable.ArrayBuffer


object IncreasingOrderSearchTree {
  def increasingBST(root: TreeNode): TreeNode = {
    def helper(root: TreeNode,list:ArrayBuffer[Int]): Unit = {
      if (root == null) return
      helper(root.left,list)
      list += root.value
      helper(root.right,list)
    }
    val vals = ArrayBuffer[Int]()
    helper(root,vals)
    val ans = new TreeNode(0)
    var cur = ans
    for (v <- vals) {
      cur.right = new TreeNode(v)
      cur = cur.right
    }
    ans.right
  }
}
