package dp

class RangeSumQueryImmutable(_nums:Array[Int]) {
  def sumRange(i: Int, j: Int): Int = {
    _nums.slice(i, j + 1).sum
  }
}
object RangeSumQueryImmutable extends App {
  println(new RangeSumQueryImmutable(Array(-2, 0, 3, -5, 2, -1)).sumRange(0, 2))
}