object LongestSubstringwithoutRepeatingCharactersScala {
    def lengthOfLongestSubstring(s : String) : Int = {
        val index : Array[Int] = new Array(128)
        var ans : Int = 0
        val n : Int = s.length
        var i : Int = 0
        for(j <- 0 until n) {
            i = Math.max(i, index(s.charAt(j)))
            ans = Math.max(ans, j - i + 1)
            index(s.charAt(j)) = j + 1
        }
        ans
    }

    
    def main(args : Array[String]) : Unit = {
        print(lengthOfLongestSubstring("abcabcbb"))
    }
}