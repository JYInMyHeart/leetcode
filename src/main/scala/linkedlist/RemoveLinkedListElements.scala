package linkedlist

object RemoveLinkedListElements extends App {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    var temp = head
    while (temp != null && (temp.x == `val`)) temp = temp.next
    var tempp = temp
    while (tempp != null && tempp.next != null) {
      if (tempp.next._x == `val`) {
        tempp.next = tempp.next.next
      } else
        tempp = tempp.next
    }
    temp
  }

  val node1 = new ListNode(1)
  val node2 = new ListNode(2)
  val node3 = new ListNode(6)
  val node4 = new ListNode(4)
  val node5 = new ListNode(5)
  val node6 = new ListNode(6)
  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node5
  node5.next = node6
  println(removeElements(node1, 6))
}
