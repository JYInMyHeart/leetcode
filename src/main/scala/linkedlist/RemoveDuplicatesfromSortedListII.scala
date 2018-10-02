package linkedlist

object RemoveDuplicatesfromSortedListII {
  def deleteDuplicates(head: ListNode): ListNode = {
    import scala.collection.mutable
    var h = head
    val set = new mutable.LinkedHashMap[Int, Int]()
    while (h != null) {
      if (set.contains(h.x))
        set += h.x -> (set(h.x) + 1)
      else
        set += h.x -> 1
      h = h.next
    }
    val ans = new ListNode(0)
    var t = ans
    for (i <- set.filter(_._2 == 1)) {
      t.next = new ListNode(i._1)
      t = t.next
    }
    ans.next
  }

  def deleteDuplicates1(head: ListNode): ListNode = {
    val dummy = new ListNode(0)
    var fast = head
    var slow = dummy
    slow.next = fast
    while (fast != null) {
      while (fast.next != null && fast.x == fast.next.x) {
        fast = fast.next
      }
      if (slow.next != fast) {
        slow.next = fast.next
        fast = slow.next
      } else {
        slow = slow.next
        fast = fast.next
      }
    }
    dummy.next
  }

  def deleteDuplicates2(head: ListNode): ListNode = {
    var h = head
    if (h == null) return null
    if (h.next != null && h.x == h.next.x) {
      while (h.next != null && h.x == h.next.x) {
        h = h.next
      }
      return deleteDuplicates2(h.next)
    } else {
      h.next = deleteDuplicates2(h.next)
    }
    h
  }
}
