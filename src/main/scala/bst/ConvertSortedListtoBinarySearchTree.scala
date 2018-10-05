package bst

import linkedlist.ListNode

object ConvertSortedListtoBinarySearchTree {
  def sortedListToBST(head: ListNode): TreeNode = {
    def helper(nums:Array[Int],start:Int,end:Int):TreeNode = {
      if(nums.isEmpty) return null
      if(start > end) return null
      val mid = (end - start) / 2 + start
      val root = new TreeNode(nums(mid))
      root.left = helper(nums,start,mid - 1)
      root.right = helper(nums,mid + 1,end)
      root
    }
    var list = List[Int]()
    var h = head
    while(h != null){
      list :+= h.x
      h = h.next
    }
    val nums = list.toArray
    helper(nums,0,nums.length - 1)
  }

  def sortedListToBST1(head: ListNode): TreeNode = {
    def helper(head:ListNode,tail:ListNode):TreeNode = {
      if( head == tail) return null
      var fast = head
      var slow = head
      while(fast != tail && fast.next != tail){
        slow = slow.next
        fast = fast.next.next
      }
      val root = new TreeNode(slow.x)
      root.left = helper(head,slow)
      root.right = helper(slow.next,tail)
      root
    }
    helper(head,null)
  }
}
