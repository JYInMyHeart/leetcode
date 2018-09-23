package bst

object ConstructStringfromBinaryTree {
  def tree2str(t: TreeNode): String = {
    if(t == null) return ""
    if(t.left == null && t.right == null) return t.value.toString
    val left = tree2str(t.left)
    val right = tree2str(t.right)
    if(left != "" && right == "")
      s"${t.value}(${left})"
    else
      s"${t.value}(${left})($right)"
  }
}
