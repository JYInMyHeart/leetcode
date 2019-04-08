package dp

import array.ConstructBinaryTreefromInorderandPostorderTraversal.TreeNode

object UniqueBinarySearchTreesII {
  def generateTrees(n: Int): List[TreeNode] = {
    if(n == 0) return List[TreeNode]()
    helper(1, n)
  }

  def helper(start: Int, end: Int): List[TreeNode] = {
    var list = List[TreeNode]()

    if (start > end) {
      list :+= null
      return list
    }

    if (start == end) {
      list :+= new TreeNode(start)
      return list
    }

    var left: List[TreeNode] = null
    var right: List[TreeNode] = null
    var i: Int = start
    while (i <= end) {
      left = helper(start, i - 1)
      right = helper(i + 1, end)
      for (lnode <- left) {
        for (rnode <- right) {
          val root: TreeNode = new TreeNode(i)
          root.left = lnode
          root.right = rnode
          list :+= root
        }
      }
      i += 1
    }
    list
  }
}
