package array

object IslandPerimeter extends App {
  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    var c = 0
    val m = grid.length
    if(m == 0) return 0
    val n = grid(0).length
    for(i <- 0 until m){
      for(j <- 0 until n){
        if(grid(i)(j) == 1){
          if(i > 0 && grid(i - 1)(j) == 0)
            c += 1
          if(i < m - 1 && grid(i + 1)(j) == 0)
            c += 1
          if(j > 0 && grid(i)(j - 1) == 0)
            c += 1
          if(j < n - 1 && grid(i)(j + 1) == 0)
            c += 1
          if(i == 0)
            c += 1
          if(i == m - 1)
            c += 1
          if(j == 0)
            c += 1
          if(j == n - 1)
            c += 1
        }
      }
    }
    c
  }
}
