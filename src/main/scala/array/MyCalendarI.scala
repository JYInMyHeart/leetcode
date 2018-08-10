package array

class MyCalendarI {
  var list = List[(Int, Int)]()

  def book(start: Int, end: Int): Boolean = {
    var flag = true
    var i = 0
    if (list.isEmpty) {
      list :+= (start, end)
    }
    else {
      while (i < list.size) {
        if (((list(i)._2 - start).toLong * (end - list(i)._1) )> 0) {
          flag =  false
        }
        i += 1
      }
    }
    if(flag) list :+= (start, end)
    flag
  }
}

object MyCalendarI extends App {
  val o = new MyCalendarI
//  println(o.book(23, 32))
//  println(o.book(42, 50))
//  println(o.book(6, 14))
//  println(o.book(0, 7))
//  println(o.book(21, 30))
//  println(o.book(26, 31))
//  println(o.book(46, 50))
//  println(o.book(28, 36))
//  println(o.book(0, 6))
//  println(o.book(27, 36))
  println(o.book(877997, 881496))
  println(o.book(964833, 967071))

  /*
  * ["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
[[],[23,32],[42,50],[6,14],[0,7],[21,30],[26,31],[46,50],[28,36],[0,6],[27,36],[6,11],[20,25],[32,37],[14,20],[7,16],[13,22],[39,47],[37,46],[42,50],[9,17],[49,50],[31,37],[43,49],[2,10],[3,12],[8,14],[14,21],[42,47],[43,49],[36,43]]
  * */
}