package string

object SubdomainVisitCount {
  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    import java.util
    val counts = new util.HashMap[String,Int]()
    for (domain <- cpdomains) {
      val cpinfo = domain.split("\\s+")
      val frags = cpinfo(1).split("\\.")
      val count = Integer.valueOf(cpinfo(0))
      var cur = ""
      var i = frags.length - 1
      while ( {
        i >= 0
      }) {
        cur = frags(i) + (if (i < frags.length - 1) "."
        else "") + cur
        counts.put(cur, counts.getOrDefault(cur, 0) + count)
          i -= 1
      }
    }

    var ans = List[String]()
    for (dom <- counts.keySet().toArray) {
      ans +:= ("" + counts.get(dom) + " " + dom)
    }
    ans
  }
}
