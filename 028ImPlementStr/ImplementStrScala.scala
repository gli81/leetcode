

object RemoveElementScala {
    def main(args: Array[String]): Unit = {
        println(removeElement(Array(1, 1, 2), 1))
    }

    def removeElement(nums: Array[Int], `val`: Int): Int = {
        if (nums.length == 0) return 0;
        var i = 0	//index
        for (j <- 0 until nums.length) {
            if (nums(j) != `val`) {
                nums(i) = nums(j)
                i += 1
            }
        }
    i
    }
}
