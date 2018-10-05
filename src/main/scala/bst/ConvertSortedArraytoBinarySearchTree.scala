package bst

object ConvertSortedArraytoBinarySearchTree {
  def sortedArrayToBST(nums: Array[Int]): TreeNode = {
    def helper(nums:Array[Int],start:Int,end:Int):TreeNode = {
      if(nums.isEmpty) return null
      if(start > end) return null
      val mid = (end - start) / 2 + start
      val root = new TreeNode(nums(mid))
      root.left = helper(nums,start,mid - 1)
      root.right = helper(nums,mid + 1,end)
      root
    }
    helper(nums,0,nums.length - 1)
  }
}
