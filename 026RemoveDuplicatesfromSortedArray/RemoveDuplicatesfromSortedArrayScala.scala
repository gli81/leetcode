

object RemoveDuplicatesfromSortedArrayScala {
    def main(args: Array[String]): Unit = {
        println(removeDuplicates(Array(1, 1, 2)))
    }

    def removeDuplicates(nums: Array[Int]): Int = {
        if (nums.length == 0) return 0;
        var i = 1	//count
        for (j <- 1 until nums.length) {
            if (nums(j) != nums(i - 1)) {
                nums(i) = nums(j)
                i += 1
            }
        }
    i
    }
}
