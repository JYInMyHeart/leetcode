package array



object EvaluateReversePolishNotation {
  def evalRPN(tokens: Array[String]): Int = {
    import scala.collection.mutable
    val values = mutable.Stack[Int]()
    for(token <- tokens){
      token match {
        case "+" =>
          val e1 = values.pop()
          val e2 = values.pop()
          val e3 = e1 + e2
          values.push(e3)
        case "-" =>
          val e1 = values.pop()
          val e2 = values.pop()
          val e3 = e2 - e1
          values.push(e3)
        case "*" =>
          val e1 = values.pop()
          val e2 = values.pop()
          val e3 = e1 * e2
          values.push(e3)
        case "/" =>
          val e1 = values.pop()
          val e2 = values.pop()
          val e3 = e2 / e1
          values.push(e3)
        case _ => values.push(token.toInt)
      }
    }
    values.pop()
  }
}
