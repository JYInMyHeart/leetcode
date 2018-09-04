package dp

object TwoKeysKeyboard extends App {
  def minSteps(n: Int): Int = {
    var N= n
    var count = 0
    var d = 2
    while(N > 1){
      while(N % d == 0){
        count += d
        N /= d
      }
      d += 1
    }
    count
  }

  println(minSteps(4))
  println(minSteps(3))
}
