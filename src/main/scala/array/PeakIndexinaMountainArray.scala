package array

object PeakIndexinaMountainArray extends App {
  def peakIndexInMountainArray(A: Array[Int]): Int = {
    A.indexOf(A.max)
  }
}
