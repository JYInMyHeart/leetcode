package String

object ExcelSheetColumnTitle {
  def convertToTitle(n: Int): String = {
    var t = n
    var ans = ""
    while(t > 26){
      val temp = (t - 1) / 26
      val mod = t - temp * 26 - 1
      ans += (mod + 'A').toChar
      t = (t - 1) / 26
    }
    ans += (t + 'A' - 1).toChar
    ans.reverse
  }
}
