package array
/**
  * Definition for a binary tree node.
  * class TreeNode(var _value: Int) {
  *   var value: Int = _value
  *   var left: TreeNode = null
  *   var right: TreeNode = null
  * }
  */
object ConstructBinaryTreefromPreorderandInorderTraversal extends App {
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    def build(pre:Array[Int],in:Array[Int],preStart:Int,inStart:Int,inEnd:Int):TreeNode = {
      if(preStart > pre.length - 1 || inStart > inEnd) return null
      val root = new TreeNode(pre(preStart))
      var index = 0
      var i = inStart
      while(i <= inEnd){
        if(in(i) == root.value)
          index = i
        i += 1
      }
      root.left = build(pre,in,preStart + 1,inStart,index - 1)
      root.right = build(pre,in,preStart + index - inStart + 1,index + 1,inEnd)
      root
    }
    build(preorder,inorder,0,0,inorder.length - 1)
  }

  println(buildTree(Array(3, 9, 20, 15, 7), Array(9, 3, 15, 20, 7)))
}


