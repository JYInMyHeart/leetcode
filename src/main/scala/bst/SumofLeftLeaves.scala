package bst

object SumofLeftLeaves {

  def sumOfLeftLeaves(root: TreeNode): Int = {
    var ans = 0
    def sum(root:TreeNode,right:Boolean):Int = {
      if(root == null) return ans
      if(!right && root.left == null && root.right == null) return ans + root.value
      ans + sum(root.left,false) + sum(root.right,true)
    }
    sum(root,true)
  }

}
