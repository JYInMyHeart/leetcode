package linkedlist

object SwapNodesinPairs extends App {
  def swapPairs(head: ListNode): ListNode = {
    if (head == null) return null
    val n = head.next
    head.next = swapPairs(head.next.next)
    n.next = head
    n
  }

  def swapPairs1(head: ListNode): ListNode = {
    val dmy: ListNode = new ListNode(0)
    var pre: ListNode = dmy
    dmy.next = head
    while (pre.next != null && pre.next.next != null) {
      val cur: ListNode = pre.next
      val suc: ListNode = cur.next
      val tmp: ListNode = suc.next
      pre.next = suc
      suc.next = cur
      cur.next = tmp
      pre = cur
    }
    dmy.next
  }

  def swapNode1(head:ListNode):ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head
    var pre = dummy
    var cur = pre.next
    var suc = cur.next
    while(suc != null) {
      cur.next = suc.next
      suc.next = pre.next
      pre.next = suc
      suc = cur.next
    }
    dummy.next
  }

    def swapNode(head:ListNode):ListNode = {
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

  val node1 = new ListNode(1)
  val node2 = new ListNode(2)
  val node3 = new ListNode(3)
  val node4 = new ListNode(7)
  val node5 = new ListNode(9)

  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node5

  println(node1)
//  println(swapNode(node1))
  println(swap(node1))


  def swap(root:ListNode):ListNode = {
    val dummy = new ListNode(0)
    dummy.next = root

    var pre:ListNode = dummy
    var cur = pre.next
    var tail = cur.next
    while(tail != null){
      cur.next = tail.next
      tail.next = pre.next
      pre.next = tail
      tail = cur.next
    }
    dummy.next
  }
}
