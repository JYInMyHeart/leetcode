package linkedlist

object RemoveNthNodeFromEndofList {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head
    var t = dummy
    var h = dummy
    for(i <- 0 to n)
      t = t.next
    while(t != null){
      h = h.next
      t = t.next
    }
    h.next = h.next.next
    dummy.next
  }
}
