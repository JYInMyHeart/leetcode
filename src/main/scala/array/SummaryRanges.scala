package array

object SummaryRanges extends App {
  def summaryRanges(nums: Array[Int]): List[String] = {
    var result = List[String]()
    var i = 0
    var j = 0
    while (i < nums.length && j < nums.length) {
      j = i + 1
      if (j < nums.length && nums(i) + 1 == nums(j)) {
        var c = i
        while (j < nums.length && nums(i) + 1 == nums(j)) {
          j += 1
          i += 1
        }
        result :+= s"${nums(c)}->${nums(j - 1)}"
      } else {
        result :+= s"${nums(i)}"
      }

      i += 1
    }
    result
  }

  println(summaryRanges(Array(0, 1, 2, 4, 5, 7)))
}
