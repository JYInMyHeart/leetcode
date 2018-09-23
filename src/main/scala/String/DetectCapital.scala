package String

object DetectCapital extends App {

  //direct solution
  def detectCapitalUse(word: String): Boolean = {
    word match{
      case x if x.head.isUpper =>
        x.substring(1) match {
          case y if y.toLowerCase == y
            | y.toUpperCase == y =>
            true
          case _ =>
            false
        }
      case x if x.toLowerCase == x =>
        true
      case _ =>
        false
    }
  }

  //regex solution
  def detectCapitalUse1(word:String):Boolean =
    word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+")
}
