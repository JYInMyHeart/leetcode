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

  def findMedianSortedArrays1(nums1: Array[Int], nums2: Array[Int]): Double = {
    //some failed attempts
//    var n1 = 0.0
//    var n2 = 0.0
//
//    while(){
//      var mid1 = nums1.length / 2
//      var mid2 = nums2.length
//      if(nums1.nonEmpty) {
//        n1 = if(nums1.length % 2 == 0) (nums1(nums1.length / 2) + nums1(nums1.length / 2 - 1)).toDouble / 2 else nums1(nums1.length / 2).toDouble
//      }
//      if(nums2.nonEmpty) {
//        n2 = if(nums2.length % 2 == 0) (nums2(nums2.length / 2) + nums2(nums2.length / 2 - 1)).toDouble / 2 else nums2(nums2.length / 2).toDouble
//      }
//      if(n1 > n2){
//
//      }
//    }
//
//    if(nums1.isEmpty) n2
//    else if(nums2.isEmpty) n1
//    else (n1 + n2) / 2
    0.0
  }

}
