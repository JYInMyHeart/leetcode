package string

import scala.collection.mutable

object ValidParentheses {
  def isValid(s: String): Boolean = {
    val stack = mutable.Stack[Char]()
    for(c <- s){
      c match {
        case '(' => stack.push(')')
        case '[' => stack.push(']')
        case '{' => stack.push('}')
        case _ =>
          if(stack.isEmpty || stack.pop() != c)
            return false
      }
    }
    stack.isEmpty
  }
}
