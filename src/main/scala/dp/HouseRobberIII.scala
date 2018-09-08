package dp

object HouseRobberIII {

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _
  }

  def rob(root: TreeNode): Int = {
    if (root == null) return 0
    var v = 0
    if (root.left != null) {
      v += rob(root.left.left) + rob(root.left.right)
    }
    if (root.right != null) {
      v += rob(root.right.left) + rob(root.right.right)
    }

    v = math.max(v + root.value, rob(root.left) + rob(root.right))
    v
  }

  var map = Map[TreeNode,Int]()
  def robWithMap(root: TreeNode):Int = {
    if (root == null) return 0
    if(map.contains(root)) return map(root)
    var v = 0
    if (root.left != null) {
      v += rob(root.left.left) + rob(root.left.right)
    }
    if (root.right != null) {
      v += rob(root.right.left) + rob(root.right.right)
    }

    v = math.max(v + root.value, rob(root.left) + rob(root.right))
    map += root -> v
    v
  }


  def robWithArray(root:TreeNode):Int = {
    def robSub(root:TreeNode):Array[Int] = {
      if(root == null) return Array.ofDim[Int](2)
      val left = robSub(root.left)
      val right = robSub(root.right)
      val res = Array.ofDim[Int](2)
      res(0) = math.max(left(0),left(1)) + math.max(right(0),right(1))
      res(1) = left(0) + right(0) + root.value
      res
    }
    val res = robSub(root)
    res.max
  }



}
