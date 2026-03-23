

import java.util.Arrays


object ThreeSumClosestScala {
    def main(args: Array[String]): Unit = {
        println(threeSumClosest2(Array(-1,2,1,-4), 1))
        println(threeSumClosest2(Array(0, 0, 0), 1))
    }

    def threeSumClosest2(nums: Array[Int], target: Int): Int = {
        var ans: Int = 0
        var diff = Integer.MAX_VALUE
        Arrays.sort(nums)
        for (i <- 0 to nums.length - 2) {
            var lo = i + 1
            var hi = nums.length - 1
            while (lo < hi) {
                if (Math.abs(nums(i) + nums(lo) + nums(hi) - target) < diff) {
                    diff = Math.abs(nums(i) + nums(lo) + nums(hi) - target)
                    ans = nums(i) + nums(lo) + nums(hi)
                }
                if (diff == 0) return ans
                if (nums(i) + nums(lo) + nums(hi) > target) hi -= 1
                else if (nums(i) + nums(lo) + nums(hi) < target) lo += 1
            }
        }
        ans
    }
}