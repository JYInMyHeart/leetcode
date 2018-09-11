package array

object SelfDividingNumbers extends App {
  def selfDividingNumbers(left: Int, right: Int): List[Int] = {
    var res = List[Int]()
    for(i <- left to right){
      if(!i.toString.contains('0')){
        if(i.toString.toCharArray.exists(i % _.toString.toInt != 0)){
        }else
          res :+= i
      }
    }
    res
  }

  println(selfDividingNumbers(1, 22))
}
