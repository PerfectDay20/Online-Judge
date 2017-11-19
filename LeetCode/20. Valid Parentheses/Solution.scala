import scala.collection.mutable.ArrayBuffer

object Solution {
  def isValid(s: String): Boolean = {
    val cache = Map(')' -> '(', ']' -> '[', '}' -> '{')

    val stack = new ArrayBuffer[Char]
    for (c <- s) {
      if (stack.isEmpty || !cache.contains(c) || cache(c) != stack.last) {
        stack.append(c)
      } else {
        stack.remove(stack.length - 1)
      }
    }
    stack.isEmpty
  }
}


