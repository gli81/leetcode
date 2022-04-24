# -*- coding: utf-8 -*-

class ValidSudoku:
    def isValidSudoku1(self, board: list[list[str]]) -> bool:
        def validRow(rowNum: int) -> bool:
            rowMap: dict[str, int] = {}
            for char in board[rowNum]:
                if char != ".":
                    if char in rowMap: return False
                    else: rowMap[char] = 1
            return True
        def validCol(colNum: int) -> bool:
            colMap: dict[str, int] = {}
            for row in range(9):
                if board[row][colNum] != ".":
                    if board[row][colNum] in colMap: return False
                    else: colMap[board[row][colNum]] = 1
            return True
        def validSub(rowNum: int, colNum: int) -> bool:
            subMap: dict[str, int] = {}
            for i in range(3):
                for j in range(3):
                    if board[rowNum + i][colNum + j] != ".":
                        if board[rowNum + i][colNum + j] in subMap: return False
                        else: subMap[board[rowNum + i][colNum + j]] = 1
            return True
        for i in range(9):
            if not validRow(i): return False
        for i in range(9):
            if not validCol(i): return False
        for i in range(0, 7, 3):
            for j in range(0, 7, 3):
                if not validSub(i, j): return False
        return True

def main():
    test = ValidSudoku()
    print(test.isValidSudoku1(
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
    ))
    print(test.isValidSudoku1(
       [[".",".",".",".","5",".",".","1","."],
        [".","4",".","3",".",".",".",".","."],
        [".",".",".",".",".","3",".",".","1"],
        ["8",".",".",".",".",".",".","2","."],
        [".",".","2",".","7",".",".",".","."],
        [".","1","5",".",".",".",".",".","."],
        [".",".",".",".",".","2",".",".","."],
        [".","2",".","9",".",".",".",".","."],
        [".",".","4",".",".",".",".",".","."]]
    ))

if __name__ == "__main__":
    main()