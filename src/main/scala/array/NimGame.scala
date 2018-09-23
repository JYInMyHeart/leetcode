package array

object NimGame extends App {
  def canWinNim(n: Int): Boolean = {
    n % 4 != 0
  }
}
