package array

object ContainerWithMostWater extends App {
  def maxArea(height: Array[Int]): Int = {
    var max = 0
    var i = 0
    while(i < height.length){
      var j = i
      while(j < height.length){
        if(height(i) > height(j)){
          max = math.max(max,height(j) * math.abs(j - i))
        }else{
          max = math.max(max,height(i) * math.abs(j - i))
        }
        j += 1
      }
      i += 1
    }
    max
  }

  println(maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}
