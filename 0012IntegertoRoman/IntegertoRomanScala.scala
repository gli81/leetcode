

class IntegertoRomanScala {
    def intToRoman(num: Int): String = {
        var toBeChanged = num
        val nums: Array[Int] = Array(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val roms: Array[String] = Array("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var ans: String = ""
        for (i <- 0 until nums.length) {
            while(toBeChanged >= nums(i)) {
                ans = ans + roms(i)
                toBeChanged -= nums(i)
            }
        }
        ans
    }
}

object IntegertoRomanScala {
    def main(args: Array[String]): Unit = {
        val testCase = Array(1, 2, 3, 4, 5, 9, 10, 14, 15, 19, 21, 25, 58, 99, 100, 101, 499, 500, 501, 999, 1000, 1001)
        for (i <- testCase) println(new IntegertoRomanScala().intToRoman(i))
    }
}