package bst



object AverageofLevelsinBinaryTree {
  def averageOfLevels(root: TreeNode): Array[Double] = {
    import scala.collection.mutable
    import scala.collection.mutable.ArrayBuffer
    val ans = ArrayBuffer[Double]()
    if(root == null) return ans.toArray
    val queue = mutable.Queue[TreeNode]()
    queue.enqueue(root)
    while(queue.nonEmpty){
      val temp = ArrayBuffer[Long]()
      for(i <- queue.indices){
        val node = queue.dequeue()
        temp += node.value.toLong
        if(node.left != null) queue.enqueue(node.left)
        if(node.right != null) queue.enqueue(node.right)
      }
      ans += (temp.sum.toDouble / temp.length)
    }
    ans.toArray
  }
}
