package bst

object PathSumIII {

  def count(root: TreeNode, sum: Int):Int = {
    if(root == null) return 0
    val c = count(root.left,sum - root.value) + count(root.right,sum - root.value)
    if(root.value == sum) c + 1 else c
  }

  def pathSum(root: TreeNode, sum: Int): Int = {
    if (root == null) return 0
    count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum)
  }

}
