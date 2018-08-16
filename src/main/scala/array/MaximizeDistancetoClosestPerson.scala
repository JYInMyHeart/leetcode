package array

object MaximizeDistancetoClosestPerson extends App {
  def maxDistToClosest(seats: Array[Int]): Int = {
    var i = 0
    var max = 0
    var left = 0
    var right = 0
    var list = List[Int]()
    while (i < seats.length) {
      if (seats(i) == 1) {
        list :+= i
      }
      i += 1
    }
    i = 0
    while(i < list.size - 1){
      max = math.max(max,(list(i + 1) - list(i)) / 2)
      i += 1
    }
    max = math.max(list.head,max)
    max = math.max(seats.size - 1 - list.last,max)
    max
  }

  println(maxDistToClosest(Array(1, 0, 0, 0)))
}
