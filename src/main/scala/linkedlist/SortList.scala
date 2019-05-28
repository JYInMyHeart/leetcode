package linkedlist

object SortList {
  def sortList1(head: ListNode): ListNode = {
    var list = List[Int]()
    var root = head
    while (root != null) {
      list :+= root.x
      root = root.next
    }
    var node = new ListNode(-1)
    val dummy = node
    for (i <- list.sorted) {
      val temp = new ListNode(i)
      node.next = temp
      node = node.next
    }
    dummy.next
  }

  def merge(head: ListNode, tail: ListNode): ListNode = {
    val dummy = new ListNode(-1)
    var root = dummy
    var h = head
    var t = tail
    while (h != null && t != null) {
      if (h.x > t.x) {
        root.next = t
        t = t.next
        root = root.next
      } else {
        root.next = h
        h = h.next
        root = root.next
      }
    }
    if (h != null)
      root.next = h
    if (t != null)
      root.next = t
    dummy.next
  }
  def sortList(head: ListNode): ListNode = {
    if (head == null || head.next == null)
      return head
    var slow = head
    var fast = head
    var prev = head
    while (fast != null && fast.next != null) {
      prev = slow
      slow = slow.next
      fast = fast.next.next
    }
    prev.next = null
    val l1 = sortList(head)
    val l2 = sortList(slow)
    merge(l1, l2)
  }

}
