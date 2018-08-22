package array

object MergeTwoSortedLists extends App {
  //there are two great solutions for this problem.
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val head = new ListNode(Int.MinValue)
    var t = head
    var ll1 = l1
    var ll2 = l2
    while(ll1 != null && ll2 != null){
      if(ll1.x > ll2.x){
        t.next = new ListNode(ll2.x)
        ll2 = ll2.next
      }else{
        t.next = new ListNode(ll1.x)
        ll1 = ll1.next
      }
      t = t.next
    }
    if(ll1 != null) t.next = ll1 else if(ll2 != null) t.next = ll2
    head.next

  }

  def mergeTwoLists1(l1: ListNode, l2: ListNode): ListNode = {
    if(l1 == null) return l2
    if(l2 == null) return l1
    var ll1 = l1
    var ll2 = l2
    if(ll1.x < ll2.x){
      ll1.next = mergeTwoLists(ll1.next,ll2)
       ll1
    }else{
      ll2.next = mergeTwoLists(ll1,ll2.next)
       ll2
    }
  }
  val l1 = new ListNode(1)
  l1.next = new ListNode(2)
  val l2 = new ListNode(3)
  l2.next = new ListNode(4)
  println(mergeTwoLists1(l1, l2))


  class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }



}
