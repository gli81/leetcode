object TwoSum1Scala {
    def twoSum(nums : Array[Int], target : Int) : Array[Int] = {
        for (i : Int <- 0 until nums.length; j : Int <- (i + 1) until nums.length) {
            // println((i, j, nums(i) + nums(j)))
            if (nums(i) + nums(j) == target) {
                return Array(i, j)
            }
        }
        Array()
    }
    def main(args : Array[String]) : Unit = {
        val nums : Array[Int] = Array(11, 15, 2, 7)
        val target : Int = 9
        
        
        println(twoSum(nums, target).mkString("Array(", ", ", ")"));
    }
}