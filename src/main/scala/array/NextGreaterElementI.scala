package array

object NextGreaterElementI extends App {
  def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    val ans = Array.fill[Int](nums1.length)(-1)
    for(i <- nums1.indices){
      var j = nums2.indexOf(nums1(i))
      var flag = true
      while(flag && j < nums2.length){
        if(nums2(j) > nums1(i)){
          ans(i) = nums2(j)
          flag = false
        }
        j += 1
      }
    }
    ans
  }
}
