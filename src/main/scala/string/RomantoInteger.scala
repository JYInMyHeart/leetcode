package string

object RomantoInteger extends App {
  def romanToInt(s: String): Int = {
    def value(c:String):Int =
      c match {
        case "I" => 1
        case "V" => 5
        case "X" => 10
        case "L" => 50
        case "C" => 100
        case "D" => 500
        case "M" => 1000
      }



    var t = 0
    var flag = true
    var ss = s
    while(flag){
      ss match {
        case x if x.contains("CD") =>
          t += count(x,"CD") * 200
          ss = ss.replace("CD","")
        case x if x.contains("CM") =>
          t += count(x,"CM") * 200
          ss = ss.replace("CM","")
        case x if x.contains("XL") =>
          t += count(x,"XL") * 20
          ss = ss.replace("XL","")
        case x if x.contains("XC") =>
          t += count(x,"XC") * 20
          ss = ss.replace("XC","")
        case x if x.contains("IV") =>
          t += count(x,"IV") * 2
          ss = ss.replace("IV","")
        case x if x.contains("IX") =>
          t += count(x,"IX") * 2
          ss = ss.replace("IX","")
        case _ => flag = false
      }
    }

    var sum = 0
    for(i <- s){
      sum += value(i.toString)
    }
    sum - t

  }
  def count(s:String,c:String):Int = {
    var count = 0
    var index = 0
    while(s.indexOf(c,index) != -1){
      index = s.indexOf(c,index) + 1
      count += 1
    }
    count
  }

  println(count("IV", "IV"))
}
