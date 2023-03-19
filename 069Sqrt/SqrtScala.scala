

object SqrtScala {
    def mySqrt(x: Int): Int = {
        if (x == 0) return 0
        if (x == 1) return 1
        var l: Int = 0
        var r: Int = x
        var ans: Int = 0
        while (l <= r) {
            var mid: Int = (l + r) / 2
            var div: Int = x / mid
            if (div == mid) return mid
            else if (mid < div) {
                ans = mid
                l = mid + 1
            } else r = mid - 1
        }
        ans
    }

    def main(args: Array[String]): Unit = {
        println(mySqrt(4))
        println(mySqrt(8))
    }
}