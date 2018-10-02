package linkedlist



object RemoveDuplicatesfromSortedList {
  def deleteDuplicates(head: ListNode): ListNode = {
    import scala.collection.mutable
    var h = head
    val set = new mutable.LinkedHashMap[Int,Int]()
    while(h != null){
      if(set.contains(h.x))
        set += h.x -> (set(h.x) + 1)
      else
        set += h.x -> 1
      h = h.next
    }
    val ans = new ListNode(0)
    var t = ans
    for(i <- set){
      t.next = new ListNode(i._1)
      t = t.next
    }
    ans.next
  }
  def deleteDuplicates1(head: ListNode): ListNode = {
    var h = head
    while(h != null && h.next != null){
      if(h.x == h.next.x)
        h.next = h.next.next
      else
        h = h.next
    }
    head
  }

}
