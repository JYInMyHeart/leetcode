package linkedlist

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x

  def apply(_x: Int = 0): ListNode = new ListNode(_x)

  override def toString: String = s"$x->$next"
}