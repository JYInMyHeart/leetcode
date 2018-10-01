package string
object LongestCommonPrefix {
    def longestCommonPrefix(strs: Array[String]): String = {
        if(strs.isEmpty) return ""
        var ans = ""
        val ss = strs.sortBy(_.length).min
        for(i <- ss.indices){
           if(strs.map(_.charAt(i)).distinct.length == 1)
            ans += strs(0).charAt(i)
            else
            return ans
        }
        ans
    }
}
