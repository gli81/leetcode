# -*- coding: utf-8 -*-

class SudokuSolver:
    def solveSudoku(self, board: "list[list[str]]") -> "bool":
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for k in "123456789":
                        board[i][j] = k
                        if self.check(board, i, j) and self.solveSudoku(board):
                            return True
                        board[i][j] = '.'
                    return False
        return True
    
    def check(self, board: "list[list[str]]", x: "int", y: "int") -> "bool":
        ## check row and column
        for i in range(9):
            if i != x and board[i][y] == board[x][y]: return False
            if i != y and board[x][i] == board[x][y]: return False
        ## check square
        m, n = x // 3, y // 3
        for i in range(3):
            for j in range(3):
                if (m * 3 + i != x or n * 3 + j != y) and board[x][y] == board[m * 3 + i][n * 3 + j]:
                    return False
        return True

def main():
    test = SudokuSolver()
    test1 = [
        ["5","3",".",".","7",".",".",".","."],
        ["6",".",".","1","9","5",".",".","."],
        [".","9","8",".",".",".",".","6","."],
        ["8",".",".",".","6",".",".",".","3"],
        ["4",".",".","8",".","3",".",".","1"],
        ["7",".",".",".","2",".",".",".","6"],
        [".","6",".",".",".",".","2","8","."],
        [".",".",".","4","1","9",".",".","5"],
        [".",".",".",".","8",".",".","7","9"]
    ]
    # print(test.check(test1, 0, 2))
    test.solveSudoku(test1)
    print(test1)
    test2 = [
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".","1",".",".",".",".",".","."],
        [".",".",".",".",".",".","2",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."]
    ]
    test.solveSudoku(test2)
    for i in test2:
        print(i)
    # print(test2)

if __name__ == "__main__":
    main()
    