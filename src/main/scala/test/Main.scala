package test

object Main extends App {
  def subSets(nums: Array[Int]): Unit = {
    def helper(nums: Array[Int], subSet: Array[Int], index: Int): Unit = {
      if (index == subSet.length) {
        println(subSet)
      } else {
        subSet(index) = -1
        helper(nums, subSet, index + 1)
        subSet(index) = nums(index)
        helper(nums, subSet, index + 1)
      }
    }
    val subSet = Array.ofDim[Int](nums.length)
    helper(nums, subSet, 0)
  }

  def subSets1(nums: Array[Int]): Unit = {

    for (j <- 0 until math.pow(2,nums.length).toInt) {
      var index = 1
      val subSet = Array.ofDim[Int](nums.length)
      while (index <= subSet.length) {
        val t = j % nums.length
        for(k <- 0 until  t)
          subSet(k) = -1
        for(k <- t until nums.length)
          subSet(k) = nums(index - 1)
        index += 1
      }
      subSet.foreach(print)
      println()
    }
  }
    subSets1(Array(1, 2, 3))
  }
