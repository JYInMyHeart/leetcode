package linkedlist

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object MergekSortedLists extends App {
  //brute force
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    def values(root: ListNode): List[Int] = {
      val list = ListBuffer[Int]()
      var r = root
      while (r != null) {
        list += r.x
        r = r.next
      }
      list.toList
    }

    val temp = lists.flatMap(values).sorted
    val head = new ListNode(0)
    var current = head
    for (i <- temp) {
      current.next = new ListNode(i)
      current = current.next
    }
    head.next
  }

  //priority queue
  def mergeKLists1(lists: Array[ListNode]): ListNode = {
    val ord: Ordering[ListNode] = Ordering.by(_.x)
    implicit val odr1: Ordering[ListNode] = ord.reverse
    if (lists == null || lists.isEmpty) return null
    val queue = mutable.PriorityQueue()
    val dummy = new ListNode(0)
    var tail = dummy
    for (i <- lists) {
      if (i != null)
        queue enqueue i
    }
    while (queue.nonEmpty) {
      tail.next = queue.dequeue()
      tail = tail.next
      if (tail.next != null) {
        queue enqueue tail.next
      }
    }
    dummy.next
  }

  //divide and conquer
  def mergeKLists2(lists: Array[ListNode]): ListNode = {
    def partion(lists: Array[ListNode], s: Int, e: Int): ListNode = {
      if (s == e) return lists(s)
      if (s < e) {
        val q = (s + e) / 2
        val l1 = partion(lists, s, q)
        val l2 = partion(lists, q + 1, e)
        merge(l1, l2)
      }
      else
        null
    }


    def merge(l1: ListNode, l2: ListNode): ListNode = {
      if (l1 == null) return l2
      if (l2 == null) return l1
      if (l1.x < l2.x) {
        l1.next = merge(l1.next, l2)
        l1
      }
      else {
        l2.next = merge(l1, l2.next)
        l2
      }
    }

    partion(lists, 0, lists.length - 1)
  }

  val node1 = new ListNode(1)
  val node2 = new ListNode(2)
  val node3 = new ListNode(3)
  val node4 = new ListNode(7)
  val node5 = new ListNode(9)
  val node6 = new ListNode(4)
  val node7 = new ListNode(8)
  node1.next = node2
  node2.next = node3
  node3.next = node4
  node4.next = node5

  node6.next = node7
  val list = List(node1, node6)
  //  println(mergeKLists(list.toArray))
  //  println(mergeKLists1(list.toArray))
  println(mergeKLists2(list.toArray))
}
