object Search2DMatrixScala {
    def searchMatrix(matrix: Array[Array[Int]],
                    target: Int): Boolean = {
        val flat: Array[Int] = matrix.flatten
        // println(flat.mkString(","))
        var left: Int = 0
        var right: Int = flat.length - 1;
        while (left <= right) {
            var mid : Int = (left + right) / 2
            if (flat(mid) == target) return true
            else if (flat(mid) < target) left = mid + 1
            else right = mid - 1
        }
        false
    }

    def main(args: Array[String]): Unit = {
        println(searchMatrix(
            Array(
                Array(1, 3, 5, 7),
                Array(10, 11, 16, 20),
                Array(23, 30, 34, 50)
            ), 3
        ))
        println(searchMatrix(
            Array(
                Array(1, 3, 5, 7),
                Array(10, 11, 16, 20),
                Array(23, 30, 34, 50)
            ), 13
        ))
    }
}