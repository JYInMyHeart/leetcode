package array

object MaxChunksToMakeSorted {
  def maxChunksToSorted(arr: Array[Int]): Int = {
    /**
      *  My idea is to process the array from the biggest number. Find the position of the max number in the array.
      *  Then split this array to two small array. The right array must be ordered in a chunk. Next do the same things to left array.
      *  But I can't write the right code. I am failed.
      *  More simple answer is finding the max number in the array that equal to the index. Every position like this must be a split point.
      *  That's magic and imaginable.
      *
      */
//    var flag = true
//    var temp = arr
//    var c = 0
//    while(temp.length >= 1){
//      val t = temp.indexOf(temp.max)
//      temp = temp.take(t)
//      if(arr.takeRight(arr.length - t).nonEmpty && arr.takeRight(arr.length - t).min < t){
//        temp = temp take temp.length - 1
//        flag = false
//      }
//      else
//        c += 1
//    }
//    if(!flag) c + 1 else c
    var i = 0
    var j = 0
    var max = 0
    while(i < arr.length){
      max = Math.max(arr(i),max)
      if(max == i)
        j += 1
      i += 1
    }
    j
  }

  def main(args: Array[String]): Unit = {

    val a = Array(4,3,2,1,0)
    val a1 = Array(1,0,2,3,4)
    val a2 = Array(1,2,0,3)
    val a3 = Array(0,1)
    val a4 = Array(0,4,5,2,1,3)
    val a5 = Array(1,2,3,4,5,0)

    println(maxChunksToSorted(a))
    println(maxChunksToSorted(a1))
    println(maxChunksToSorted(a2))
    println(maxChunksToSorted(a3))
    println(maxChunksToSorted(a4))
    println(maxChunksToSorted(a5))
  }
}
