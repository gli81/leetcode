

object LongestPalindromicSubstringScala {
    def longestPalindromSubstring4(s : String) : String = {
        /**
         * traverse the String, make every letter (or two letters) the center of a palindrome word
         * see if the letters before the center and after the center are the same
         * if so, spread the center to include these two letters as part of the palindrome 
         */
        var start : Int = 0
        var endd : Int = 0
        for (i <- 0 until s.length()) {
            val len1 = palindromeCenteredAt(s, i, i)
            val len2 = palindromeCenteredAt(s, i, i + 1)
            val len = Math.max(len1, len2)
            if (len > endd - start + 1) {
                start = i - (len - 1) / 2
                endd = i + len / 2
            }
        }
        s.substring(start, endd + 1)
    }

    def palindromeCenteredAt(s : String, leftIndex : Int, rightIndex : Int) : Int = {
        var left : Int = leftIndex
        var right : Int = rightIndex
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left -= 1
            right += 1
        }
        right - left + 1 - 2
    }


    def main(args : Array[String]) : Unit = {
        val s = "liguanggnailga"
        println(longestPalindromSubstring4(s))
    }
}


// LEARN FROM LEETCODE
// REAL Scala style answer

// object Solution {
//   def longestPalindrome(s: String): String = {
//     var (ansS, ansE) = (0, 0)

//     def expand(l: Int, r: Int): (Int, Int) = {
//       var (i, j) = (l, r)
//       while (i >= 0 && j < s.length && s(i) == s(j)) {
//         i -= 1
//         j += 1
//       }
//       (i + 1, j - 1)
//     }

//     s.indices.foreach { i =>
//       var (s1, e1) = expand(i, i)
//       var (s2, e2) = expand(i, i + 1)
//       if (e1 - s1 > ansE - ansS) {
//         ansS = s1
//         ansE = e1
//       }
//       if (e2 - s2 > ansE - ansS) {
//         ansS = s2
//         ansE = e2
//       }
//     }

//     s.substring(ansS, ansE + 1)
//   }
// }