object SudokuSolverScala {
    def main(args: Array[String]): Unit = {
        val test: SudokuSolverScala = new SudokuSolverScala()
        val test1: Array[Array[Char]] = Array(
            Array('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            Array('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            Array('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            Array('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            Array('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            Array('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            Array('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            Array('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            Array('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        test.solveSudoku(test1)
        for (i <- 0 until 9) {
            println(test1(i).mkString("[", ", ", "]"))
        }
    }
}

class SudokuSolverScala {

    def solveSudoku(board: Array[Array[Char]]): Unit = {solveSudoku_(board)}
    
    def solveSudoku_(board: Array[Array[Char]]): Boolean = {
        val nums: Array[Char] = Array('1', '2', '3', '4', '5', '6', '7', '8', '9')
        for (i <- 0 until 9) {
            for (j <- 0 until 9) {
                if (board(i)(j) == '.') {
                    for (k <- 0 until nums.length) {
                        board(i)(j) = nums(k)
                        if (check(board, i, j) && solveSudoku_(board)) return true
                        board(i)(j) = '.'
                    }
                    return false
                }
            }
        }
        true
    }

    def check(board: Array[Array[Char]], x: Int, y: Int): Boolean = {
        // check row and column
        for (i <- 0 to 8) {
            if (x != i && board(i)(y) == board(x)(y)) {return false}
            if (y != i && board(x)(i) == board(x)(y)) {return false}
        }
        // check square
        val m: Int = x / 3
        val n: Int = y / 3
        for (i <- Range(0, 3)) {
            for (j <- Range(0, 3)) {
                if ((3 * m + i != x || 3 * n + j != y) && board(3 * m + i)(3 * n + j) == board(x)(y)) return false
            }
        }
        true
    }
}
