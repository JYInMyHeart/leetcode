package array

object ConstructBinaryTreefromInorderandPostorderTraversal extends App {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    def build(inorder:Array[Int],postorder:Array[Int],inStart:Int,inEnd:Int,postEnd:Int):TreeNode = {
      if( inStart > inEnd || postEnd < 0){
        return null
      }
      val root = new TreeNode(postorder(postEnd))
      var i = 0
      var index = 0
      while(i < inorder.length){
        if(inorder(i) == root.value){
          index = i
        }
        i += 1
      }
      root.right = build(inorder,postorder,index + 1,inEnd ,postEnd - 1)
      root.left = build(inorder,postorder,inStart,index - 1,postEnd + index - inEnd - 1 )
      root
    }
    build(inorder,postorder,0,inorder.length - 1,postorder.length - 1)
  }

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = _
    var right: TreeNode = _

    override def toString: String =
      s"""$value
         |$left,$right""".stripMargin
  }

  println(buildTree(Array(9, 3, 15, 20, 7), Array(9, 15, 7, 20, 3)))
}
