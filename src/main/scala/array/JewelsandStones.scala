package array

object JewelsandStones extends App {
  def numJewelsInStones(J: String, S: String): Int = {
        val j = J.toCharArray
      val s = S.toCharArray
      var count = 0
      for(i <- j){
        for(k <- s){
          if(i == k){
            count += 1
          }
        }
      }
      count
    }
}
