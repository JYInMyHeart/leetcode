package string



object GenerateParentheses {
  import scala.collection.mutable.ListBuffer
  def generateParenthesis(n: Int): List[String] = {
    val ans = ListBuffer[String]()
    if(n == 0)
      ans += ""
    else{
      for(a <- 0 until n){
        for(left <- generateParenthesis(a))
          for(right <- generateParenthesis(n - a - 1))
            ans += s"($left)$right"
      }
    }
    ans.toList
  }
  def generateParenthesis1(n: Int): List[String] = {
    def backtrack(ans: ListBuffer[String], cur: String, open: Int, close: Int, max: Int): Unit = {
      if (cur.length == max * 2) {
        ans += cur
        return
      }
      if (open < max) backtrack(ans, cur + "(", open + 1, close, max)
      if (close < open) backtrack(ans, cur + ")", open, close + 1, max)
    }
    val ans = ListBuffer[String]()
    backtrack(ans,"",0,0,n)
    ans.toList
  }


  /*
  * "((()))",   000111
  "(()())",     001011
  "(())()",     001101
  "()(())",     010011
  "()()()"      010101
  * */
}
