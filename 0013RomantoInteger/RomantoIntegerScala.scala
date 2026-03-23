

class RomantoIntegerScala {
    def romanToInteger(s: String): Int = {
        var ans = 0
        if (s.indexOf("IV") != -1) ans -= 2
        if (s.indexOf("IX") != -1) ans -= 2
        if (s.indexOf("XL") != -1) ans -= 20
        if (s.indexOf("XC") != -1) ans -= 20
        if (s.indexOf("CD") != -1) ans -= 200
        if (s.indexOf("CM") != -1) ans -= 200

        for (ch <- s) {
            ch match {
                case 'I' => ans += 1
                case 'V' => ans += 5
                case 'X' => ans += 10
                case 'L' => ans += 50
                case 'C' => ans += 100
                case 'D' => ans += 500
                case 'M' => ans += 1000
            }
        }
        ans
    }
}

object RomantoIntegerScala {
    def main(args: Array[String]): Unit = {
        val testCase = Array("I", "II", "III", "IV", "V", "VI", "IX", "CMDLVI")
        for (test <- testCase) println(new RomantoIntegerScala().romanToInteger(test))
    }
}