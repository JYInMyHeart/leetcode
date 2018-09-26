package linkedlist

object ReverseLinkedListII {
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head
    var pre = dummy
    for (_ <- 0 until m - 1)
      pre = pre.next
    val start = pre.next
    var tail = start.next
    for (_ <- 0 until n - m) {
      start.next = tail.next
      tail.next = pre.next
      pre.next = tail
      tail = start.next
    }
    dummy.next
  }
}
