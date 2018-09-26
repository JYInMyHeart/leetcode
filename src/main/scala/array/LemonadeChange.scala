package array

object LemonadeChange {
  def lemonadeChange(bills: Array[Int]): Boolean = {
    var five = 0
    var ten = 0
    for (i <- bills) {
      i match {
        case 5 => five += 1
        case 10 =>
          if (five == 0) return false
          else {
            five -= 1
            ten += 1
          }
        case 20 =>
          if (five > 0 && ten > 0) {
            five -= 1
            ten -= 1
          } else if (five >= 3)
            five -= 3
          else
            return false
        case _ => return false
      }
    }
    true
  }
}
