package array

object MergeIntervals extends App {
  def merge(intervals: List[Interval]): List[Interval] = {
    val sortedIntervals = intervals.sortBy(_.start).toArray
    var i = 0
    while(i < sortedIntervals.length - 1){
      if(sortedIntervals(i).end >= sortedIntervals(i + 1).start){
        val interval = new Interval(sortedIntervals(i).start,math.max(sortedIntervals(i + 1).end,sortedIntervals(i).end))
        sortedIntervals(i) = null
        sortedIntervals(i + 1) = interval
      }
      i += 1
    }
    sortedIntervals.filter(_ != null).toList
  }

  class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end

    override def toString: String = s"[$start,$end]"

  }

  //1,3],[2,6],[8,10],[15,18
  val a = Array(new Interval(1, 4), new Interval(0, 2), new Interval(3,5))
  println(merge(a.toList))


}
