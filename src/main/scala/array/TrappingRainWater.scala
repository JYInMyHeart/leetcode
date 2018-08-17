package array

object TrappingRainWater extends App {
  def trap(height: Array[Int]): Int = {
    if(height.isEmpty) return 0
    var left = 0
    var right = 0
    val n = height.length
    var i = 0
    var max = 0
    while(i <= height.indexOf(height.max)){
      if(height(i) > height(left)){
        val t = (for(index <- left + 1 until i) yield height(index)).sum
        max += (i - left - 1) * height(left) - t
        left = i
      }
      i += 1
    }
    val hs = height.reverse
    i = 0
    left = 0
    right = 0
    while(i <= hs.indexOf(hs.max)){
      if(hs(i) > hs(left)){
        val t = (for(index <- left + 1 until i) yield hs(index)).sum
        max += (i - left - 1) * hs(left) - t
        left = i
      }
      i += 1
    }
    left = height.indexOf(height.max)
    right = height.lastIndexOf(height.max)
    if(left != right){
      val t = (for(index <- left + 1 until right) yield height(index)).sum
      max += height.max * (right - 1 - left) - t
    }
    max
  }

  def trap1(h:Array[Int]):Int = {
    var l = 0
    var r = h.length - 1
    var water = 0
    var height = 0
    while(l < r){
      while(l < r && height >= h(l)){
        water += height - h(l)
        l += 1
      }
      while(l < r && height >= h(r)){
        water += height - h(r)
        r -= 1
      }
      height = math.min(h(l),h(r))
    }
    water
  }

  println(trap1(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}
