package string




object LetterCombinationsofaPhoneNumber extends App {
  import scala.collection.mutable.ListBuffer
  def letterCombinations(digits: String): List[String] = {
    val ans = new java.util.LinkedList[String]()
    if (digits.length == 0) {
      return List[String]()
    }

    val ref: Array[String] = Array("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

    ans add ""

    while ( ans.peek().length != digits.length) {
      val remove: String = ans.remove()
      val map: String = ref(digits.charAt(remove.length) - '0')
      for (i <- map) {
        ans addLast  (remove + i)
      }
    }
    val a = ListBuffer[String]()
    println(ans)
    ans.stream().forEach((x:String) => a += x)
    a.toList
  }


  def letterCombinations1(digits: String): List[String] = {
    if(digits.isEmpty) return List[String]()
    def nums(i:Char):String = i match {
      case '0' => "0"
      case '1' => "1"
      case '2' => "abc"
      case '3' => "def"
      case '4' => "ghi"
      case '5' => "jkl"
      case '6' => "mno"
      case '7' => "pqrs"
      case '8' => "tuv"
      case '9' => "wxyz"
    }
    def strs(digits:String):List[String] = digits map nums toList

    def combineStrs(list:List[String]):List[String] = {
      var res = ListBuffer[String]()
      res += ""
      for(i <- list)
        res = combine(res,i)
      res.toList
    }
    def combine(res:ListBuffer[String],s:String):ListBuffer[String] = {
      var ans = ListBuffer[String]()
      for(j <- s)
        for(i <- res)
          ans += (i + j)
      ans
    }
    combineStrs (strs (digits))
  }

  println(letterCombinations("23"))
  println(letterCombinations1("23"))
}
