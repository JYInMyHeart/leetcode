package linkedlist

import scala.collection.mutable.ListBuffer

object PartitionList extends App {
  def partition(head: ListNode, x: Int): ListNode = {
    val restList = ListBuffer[Int]()
    val root = new ListNode(0)
    root.next = head
    var node = root
    while (node != null && node.next != null) {
      if (node.next.x >= x) {
        restList += node.next.x
        node.next = node.next.next
      } else
        node = node.next
    }
    for (i <- restList) {
      node.next = new ListNode(i)
      node = node.next
    }
    root.next
  }

  def partition1(head: ListNode, x: Int): ListNode = {
    val d1 = new ListNode(0)
    val d2 = new ListNode(0)
    var c1 = d1
    var c2 = d2
    var node = head
    while (node != null) {
      if (node.x < x) {
        c1.next = node
        c1 = node
      } else {
        c2.next = node
        c2 = node
      }
      node = node.next
    }
    c2.next = null
    c1.next = d2.next
    d1.next
  }

  val node1 = new ListNode(1)
  val node2 = new ListNode(4)
  val node3 = new ListNode(3)
  val node4 = new ListNode(2)
  val node5 = new ListNode(5)
  val node6 = new ListNode(2)
  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node5
  node5.next = node6
  println(partition1(node1, 3))
}
