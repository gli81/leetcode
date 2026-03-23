

object ZigzagConversion2Scala{
    def convert(s : String, numRows : Int) : String = {
        val n : Int = s.length()
        val cycle : Int = numRows * 2 - 2
        if (numRows == 1) return s
        val ans : StringBuilder = new StringBuilder()
        for (i <- 0 until numRows; j <- Range(0, n - i, cycle)) {
            ans.append(s.charAt(i + j))
            if (i != 0 && i != numRows - 1 && j < (n + i - cycle)) {
                ans.append(s.charAt(j - i + cycle))
            }
        }
        ans.toString()
    }

    def main(args : Array[String]) : Unit = {
        println(convert("PAYpalISHIRing", 3))
    }
}