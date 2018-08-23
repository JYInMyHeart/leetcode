package dp

object ArithmeticSlices extends App {
  //compute all the arithmetic sequences and store their length in array.then compute each length contains how many arithmetic sequences.
  def numberOfArithmeticSlices(A: Array[Int]): Int = {
    if(A.length < 3) return 0
    var i = 2
    var curr = 0
    var res = 0
    while(i < A.length){
      if(A(i) - A(i - 1) == A(i - 1) - A(i - 2)){
        curr += 1
        res += curr
      }else{
        curr = 0
      }
      i += 1
    }
    res
  }

  println(numberOfArithmeticSlices(Array(1, 2, 3, 4)))
  println(numberOfArithmeticSlices(Array(1, 2, 3, 8,9,10)))
}
