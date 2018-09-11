package linkedlist

object MiddleoftheLinkedList extends App{

  def middleNode(head: ListNode): ListNode = {
    var temp = head
    var c = 0
    while(temp != null){
      c += 1
      temp = temp.next
    }
    temp = head
    for(i <- 0 until c / 2)
      temp = temp.next
    temp
  }


  def middleNode1(head: ListNode): ListNode = {
    var slow = head
    var fast = head
    while(fast != null && fast.next != null){
      slow = slow.next
      fast = fast.next.next
    }
    slow
  }

  val node1 = new ListNode(1)
  val node2 = new ListNode(2)
  val node3 = new ListNode(3)
  val node4 = new ListNode(4)
  val node5 = new ListNode(5)
  val node6 = new ListNode(6)
  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node5
//  node5.next = node6

  middleNode1(node1)
}
