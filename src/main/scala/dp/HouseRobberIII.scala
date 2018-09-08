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
}
