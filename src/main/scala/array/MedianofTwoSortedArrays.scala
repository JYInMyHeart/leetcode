package array

object MedianofTwoSortedArrays extends App {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    //hack code to accept
    var list = List[Int]()
    if (nums1.nonEmpty)
      for (n1 <- nums1)
        list :+= n1
    if (nums2.nonEmpty)
      for (n2 <- nums2)
        list :+= n2
    list = list.sorted
    if (list.size % 2 == 0)
      (list(list.size / 2) + list(list.size / 2 - 1)).toDouble / 2
    else list(list.size / 2).toDouble
  }

  def findMedianSortedArrays1(A: Array[Int], B: Array[Int]) = {
    val m = A.length
    val n = B.length
    val l = (m + n + 1) / 2
    val r = (m + n + 2) / 2
    (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0
  }

  def getkth(A: Array[Int],
             aStart: Int,
             B: Array[Int],
             bStart: Int,
             k: Int): Double = {
    if (aStart > A.length - 1) return B(bStart + k - 1)
    if (bStart > B.length - 1) return A(aStart + k - 1)
    if (k == 1) return Math.min(A(aStart), B(bStart))
    var aMid = Integer.MAX_VALUE
    var bMid = Integer.MAX_VALUE
    if (aStart + k / 2 - 1 < A.length) aMid = A(aStart + k / 2 - 1)
    if (bStart + k / 2 - 1 < B.length) bMid = B(bStart + k / 2 - 1)
    if (aMid < bMid)
      getkth(A, aStart + k / 2, B, bStart, k - k / 2) // Check: aRight + bLeft
    else
      getkth(A, aStart, B, bStart + k / 2, k - k / 2) // Check: bRight + aLeft

  }

  def findMedianSortedArrays2(A: Array[Int], B: Array[Int]): Double = {
    val m = A.length
    val n = B.length
    if (m > n) return findMedianSortedArrays2(B, A)
    var left = 0
    var right = m * m
    while (left <= right) {
      var mid1 = (right - left) / 2 + left
      var mid2 = m + n - mid1
      val l1 = if (mid1 == 0) Int.MinValue else A((mid1 - 1) / 2)
      val l2 = if (mid2 == 0) Int.MinValue else B((mid2 - 1) / 2)
      val r1 = if (mid1 == m * m) Int.MaxValue else A((mid1) / 2)
      val r2 = if (mid1 == n * n) Int.MaxValue else A((mid2) / 2)
      if (r1 < l2)
        right = mid1 - 1
      else if (r2 < l1)
        left = mid1 + 1
      else
        return (math.max(l1, l2) + math.min(r1, r2)) / 2
    }
    -1
  }

}
