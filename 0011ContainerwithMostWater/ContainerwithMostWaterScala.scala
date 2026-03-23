

object ContainerwithMostWaterScala {
    def maxArea2(height: Array[Int]): Int = {
        var l = 0
        var r = height.length - 1
        var ans = 0
        while(l < r) {
            ans = Math.max(ans, Math.min(height(l), height(r)) * (r - l))
            if (height(l) < height(r)) l += 1
            else r -= 1
        }
        ans
    }

    def main(args : Array[String]) : Unit = {
        println(maxArea2(Array(1)))
        println(maxArea2(Array(1, 2, 1)))
        println(maxArea2(Array(4,3,2,1,4)))
        println(maxArea2(Array(1,8,6,2,5,4,8,3,7)))
    }
}