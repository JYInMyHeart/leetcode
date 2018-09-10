package String

object RobotReturntoOrigin extends App {
  def judgeCircle(moves: String): Boolean = {
    (moves.filter(_ == 'L').length == moves.filter(_ == 'R').length) && (moves.filter(_ == 'U').length == moves.filter(_ == 'D').length)
  }

  println("UD".filter(_ == 'L').length)
}
