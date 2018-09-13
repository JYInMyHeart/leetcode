package bst

object KeyboardRow {
  def findWords(words: Array[String]): Array[String] = {
    words.filter(_.toLowerCase.matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
  }
}
