package array

object PascalsTriangle extends App {
  def generate(numRows: Int): List[List[Int]] = {
    if(numRows <= 0) return List[List[Int]]()
    if(numRows == 1) return List[List[Int]](List(1))
    if(numRows == 2) return List[List[Int]](List(1),List(1,1))
    var res = List[List[Int]]()
    val last = generate(numRows - 1)
    var i = 0
    var l = List(1)
    res ++= last
    while(i < last.last.size - 1){
      l :+= last.last(i) + last.last(i + 1)
      i += 1
    }
    l :+= 1
    res :+= l
    res
  }

  println(generate(5))
}
