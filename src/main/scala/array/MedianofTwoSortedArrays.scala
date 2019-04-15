package array

object MedianofTwoSortedArrays extends App{
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    //hack code to accept
    var list = List[Int]()
    if(nums1.nonEmpty)
      for(n1 <- nums1)
        list :+= n1
    if(nums2.nonEmpty)
      for(n2 <- nums2)
        list :+= n2
    list = list.sorted
    if(list.size % 2 == 0) (list(list.size / 2) + list(list.size / 2 - 1)).toDouble / 2 else list(list.size / 2).toDouble
  }

  def findMedianSortedArrays1(A: Array[Int], B: Array[Int]) = {
    val m = A.length
    val n = B.length
    val l = (m + n + 1) / 2
    val r = (m + n + 2) / 2
    (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0
  }

  def getkth(A: Array[Int], aStart: Int, B: Array[Int], bStart: Int, k: Int): Double = {
    if (aStart > A.length - 1) return B(bStart + k - 1)
    if (bStart > B.length - 1) return A(aStart + k - 1)
    if (k == 1) return Math.min(A(aStart), B(bStart))
    var aMid = Integer.MAX_VALUE
    var bMid = Integer.MAX_VALUE
    if (aStart + k / 2 - 1 < A.length) aMid = A(aStart + k / 2 - 1)
    if (bStart + k / 2 - 1 < B.length) bMid = B(bStart + k / 2 - 1)
    if (aMid < bMid) getkth(A, aStart + k / 2, B, bStart, k - k / 2) // Check: aRight + bLeft
    else getkth(A, aStart, B, bStart + k / 2, k - k / 2) // Check: bRight + aLeft
  }

}
