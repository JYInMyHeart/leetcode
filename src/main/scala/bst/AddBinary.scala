package bst

import java.math.BigInteger

object AddBinary extends App {
  def addBinary(a: String, b: String): String = {
    (BigInt(a,2) + BigInt(b,2)).toString(2)
  }

  def addBinary1(a: String, b: String): String = {
    var ans = ""
    var carry = 0
    var i = a.length - 1
    var j = b.length - 1
    while(i >= 0 || j >= 0){
      var sum = carry
      if(i >= 0) sum += a.charAt(i) - '0'
      if(j >= 0) sum += b.charAt(j) - '0'
      ans += sum % 2
      carry = sum / 2
      i -= 1
      j -= 1
    }
    if(carry != 0)
      ans += carry
    ans.reverse
  }

  val s = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"

}
