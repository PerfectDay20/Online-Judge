import scala.collection.mutable

object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val cache = new mutable.HashMap[Int, Int]
    for ((v, i) <- nums.zipWithIndex) {
      if (cache contains target - v) {
        return Array(cache(target - v), i)
      } else {
        cache(v) = i
      }
    }
    throw new IllegalArgumentException()
  }
}
