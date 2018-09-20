package array

object AddDigits extends App{
  def addDigits(num: BigInt): BigInt = {
    (num - 1) % 9 + 1
  }

  println(addDigits(BigInt("9283829589283968293869283968923869329869328688293869829")))
}
