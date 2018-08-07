package array

object ArrayNesting {
  def arrayNesting(nums: Array[Int]): Int = {

    var counts = 0
    var tt = List[Int]()
    var i = 0
    for (i <- nums.indices) {
      var count = 0
      var temp = i
      var list = List[Int]()
      if (tt.contains(i)) {

      }
      else {
        do {
          list :+= nums(temp)
          count += 1
          temp = nums(temp)
        } while (!list.contains(nums(temp)))
        counts = Math.max(counts,count)
        tt ++= list
      }
    }
    counts
  }
}
