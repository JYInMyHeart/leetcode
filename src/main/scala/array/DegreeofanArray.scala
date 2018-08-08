package array

object DegreeofanArray {
  def findShortestSubArray(nums: Array[Int]): Int = {
    var map1 = Map[Int, Int]()
    nums.foreach(x => if (map1.contains(x)) {
      map1 += x -> (map1(x) + 1)
    } else {
      map1 += x -> 1
    })
    val max = map1.maxBy(x => x._2)._2
    map1.filter(_._2 == max).map(x => nums.lastIndexOf(x._1) - nums.indexOf(x._1)).min + 1
  }

  def main(args: Array[String]): Unit = {
    var a = Array(1, 2, 2, 3, 1)
    println(findShortestSubArray(a))
  }
}
