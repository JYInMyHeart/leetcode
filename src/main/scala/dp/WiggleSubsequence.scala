package dp

object WiggleSubsequence extends App{
  def wiggleMaxLength(nums: Array[Int]): Int = {
    val n = nums.length
    if(n < 2) return n
    val up = Array.ofDim[Int](n)
    val down = Array.ofDim[Int](n)
    for(i <- 1 until n){
      for(j <- 0 until i){
        if(nums(i) > nums(j)){
          up(i) = math.max(down(j) + 1,up(i))
        }else if(nums(i) < nums(j)){
          down(i) = math.max(up(j) + 1,down(i))
        }
      }
    }

    math.max(down(n - 1),up(n - 1)) + 1
  }


  def wiggleMaxLength1(nums: Array[Int]): Int = {
    val n = nums.length
    if(n < 2) return n
    val up = Array.ofDim[Int](n)
    val down = Array.ofDim[Int](n)

    for(i <- 1 until n){
        if(nums(i) > nums(i - 1)){
          up(i) = down(i - 1) + 1
          down(i) = down(i - 1)
        }else if(nums(i) < nums( i - 1)){
          up(i) = up(i - 1)
          down(i) = up(i - 1) + 1
        }else{
          up(i) = up(i - 1)
          down(i) = down(i - 1)
        }
    }

    math.max(down(n - 1),up(n - 1)) + 1
  }

  def wiggleMaxLength2(nums: Array[Int]): Int = {
    val n = nums.length
    if(n < 2) return n
    var up = 0
    var down = 0
    for(i <- 1 until n){
      if(nums(i) > nums(i - 1)){
        up = down + 1
      }else if(nums(i) < nums( i - 1)){
        down = up + 1
      }
    }
    math.max(down,up) + 1
  }
}
