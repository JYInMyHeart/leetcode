package bst

import scala.collection.mutable.ArrayBuffer

object TrimaBinarySearchTree extends App {
  def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {
    if(root == null) return null
    if(root.value > R) return trimBST(root.left,L,R)
    if(root.left < L) return trimBST(root.right,L,R)

    root.left = trimBST(root.left,L,R)
    root.right = trimBST(root.right,L,R)
    root
  }
}
