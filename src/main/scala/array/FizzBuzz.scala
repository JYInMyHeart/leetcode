package array

object FizzBuzz extends App {
  def fizzBuzz(n: Int): List[String] = {
    Stream.iterate(1,n)(_ + 1).map {
      case y if y % 3 == 0 && y % 5 == 0 => "FuzzBuzz"
      case y if y % 3 == 0 => "Fuzz"
      case y if y % 5 == 0 => "Buzz"
      case y => y.toString
    }.toList
  }
}
