

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object TwoSumScala {
    def twoSum1(nums : Array[Int], target : Int) : Array[Int] = {
        for (i : Int <- 0 until nums.length; j : Int <- (i + 1) until nums.length) {
            // println((i, j, nums(i) + nums(j)))
            if (nums(i) + nums(j) == target) {
                return Array(i, j)
            }
        }
        Array()
    }

    def twoSum2(nums : Array[Int], target : Int) : Array[Int] = {
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
        val nums: Array[Int] = Array(11, 15, 2, 7)
        val target: Int = 9
        println(
            twoSum1(nums, target).mkString("Array(", ", ", ")")
        )
        val nums2: Array[Int] = Array(1, 2, 3, 4, 5, 7)
        val target2: Int = 10
        println(
            twoSum2(nums2, target2).mkString("Array(", ", ", ")")
        )
    }
}