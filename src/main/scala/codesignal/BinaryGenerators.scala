package codesignal

import scala.collection.mutable.ArrayBuffer

object BinaryGenerators {
  def r(s: String): Seq[String] =
    if (s == "") Seq("")
    else
      for {
        x <- (if (s(0) == '0') Seq("0") else Nil) ++ Seq("1")
        y <- r(s tail)
      } yield x + y

  def binaryGenerator: String => Array[String] = r(_: String) toArray

}
