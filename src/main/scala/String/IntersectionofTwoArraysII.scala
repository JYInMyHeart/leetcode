package String

object IntersectionofTwoArrays {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    var ans = List[Int]()
    for (i <- nums1) {
      if (nums2.contains(i)){
        ans :+= i
        nums2(nums2.indexOf(i)) = Int.MaxValue
      }
    }
    ans.toArray
  }
}
