package linkedlist

object ReverseLinkedList {
  def reverseList(head: ListNode): ListNode = {
    if (head == null || head.next == null) return head
    val p = reverseList(head.next)
    head.next.next = head
    head.next = null
    p
  }

  def reverseList1(head:ListNode):ListNode = {
    var prev:ListNode = null
    var curr = head
    while (curr != null) {
      val nextTemp = curr.next
      curr.next = prev
      prev = curr
      curr = nextTemp
    }
    prev
  }
}
