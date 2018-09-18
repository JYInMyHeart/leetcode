package array

object PrimeNumberofSetBitsinBinaryRepresentation extends App {
  def isPrimary(i: Int): Boolean ={
    var count = 0
    for(j <- 2 to i){
      if(i % j == 0)
        count += 1
    }
    if(count == 1) true else false
  }
  def countPrimeSetBits(L: Int, R: Int): Int = {

    var c = 0
    for(i <- L to R){
      if(isPrimary(Integer.bitCount(i)))
        c += 1
    }
    c
  }

}
