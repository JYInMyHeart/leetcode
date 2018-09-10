package bst

object MergeTwoBinaryTrees {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }

  def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
    if(t1 == null && t2 == null) return null
    if(t1 == null) return t2
    if(t2 == null) return t1
    val res =  new TreeNode(t1.value + t2.value)
    res.left = mergeTrees(t1.left,t2.left)
    res.right = mergeTrees(t1.right,t2.right)
    res
  }
}
