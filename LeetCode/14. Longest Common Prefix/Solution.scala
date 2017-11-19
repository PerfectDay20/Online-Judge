object Solution {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) {
      ""
    }else {
      val minLength = strs.map(_.length).min
      for (i <- 0 until minLength) {
        for (j <- 1 until strs.length) {
          if (strs(j - 1).charAt(i) != strs(j).charAt(i)) {
            return strs(0).substring(0, i)
          }
        }
      }
      strs(0).substring(0, minLength)
    }

  }
}
