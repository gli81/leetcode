import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object TwoSum2Scala {
    def twoSum(nums : Array[Int], target : Int) : Array[Int] = {
        val tmp : Array[Int] = Array()
        val mapp : mutable.Map[Int, Int] = mutable.Map()
        // put everything into the map
        for (i <- nums.indices) {
            mapp += ((nums(i), i))
        }
        // traverse nums
        for (i <- nums.indices) {
            var sub = target - nums(i)
            if (mapp.contains(sub) && mapp.get(sub).get != i) {
                return i +: mapp.get(sub).get +: tmp
            }
        }
        0 +: 0 +: tmp
    }
    def main(args : Array[String]) : Unit = {
        val nums : Array[Int] = Array(1, 2, 3, 4, 5, 7)
        val target : Int = 10
        println(twoSum(nums, target).mkString("Array(", ", ", ")"))
    }
}