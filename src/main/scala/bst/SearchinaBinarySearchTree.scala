package bst

object SearchinaBinarySearchTree {
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    root match {
      case null => null
      case x if x._value == `val` => root
      case x if x.value > `val` => searchBST(x.left,`val`)
      case x if x.value < `val` => searchBST(x.right,`val`)
    }
//    if(root == null) return null
//    if(root._value == `val`) return root
//    if(root.value > `val`) return searchBST(root.left,`val`)
//    if(root.value < `val`) return searchBST(root.right,`val`)
  }
}
