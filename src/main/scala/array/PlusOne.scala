package array

object PlusOne extends App{
  def plusOne(digits: Array[Int]): Array[Int] = {
    var i = digits.length - 1
    var flag = true
    while(flag && i >= 0){
      if(digits(i) == 9){
        digits(i) = 0
        i -= 1
      }else{
        digits(i) += 1
        flag = false
      }
    }
    if(flag) 1 +: digits else digits
  }
}
