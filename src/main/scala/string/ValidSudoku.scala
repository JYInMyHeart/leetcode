package string

import java.util



object ValidSudoku {
  def isValidSudoku(board: Array[Array[Char]]): Boolean = {
    val m = board.length
    val n = board(0).length
    for(i <- 0 until 9){
      val rows = new util.HashSet[Char]()
      val cloumns = new util.HashSet[Char]()
      val cube = new util.HashSet[Char]()
      for(j <- 0 until n){
        if(board(i)(j) != '.' && !rows.add(board(i)(j)))
          return false
        if(board(j)(i) != '.' && !cloumns.add(board(j)(i)))
          return false
        var rowIndex = (i / 3) * 3
        var cloumnIndex = (i % 3) * 3
        if(board(rowIndex + j/3)(cloumnIndex + j%3)!='.' && !cube.add(board(rowIndex + j/3)(cloumnIndex + j%3)))
          return false
      }
    }
    true
  }
}
