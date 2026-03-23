# -*- coding: utf-8 -*-

from typing import List

class NQueensII:
    def totalNQueens(self, n: "int") -> "int":
        ans = []
        self.__backtrack(ans, n, [], 0)
        return len(ans)

    def __backtrack(self, ans: "List[List[str]]",
                    n: "int", pos: "List[int]",
                    y: "int") -> "None":
        """
        pos: records where are the dots
        """
        for row in range(n):
            if self.__is_valid(pos, row, y):
                ## if (y, row) works,
                ## add position to the position list
                pos.append(row)
                if len(pos) == n:
                    ## every column has a dot
                    ans.append(pos[:])
                    pos.pop()
                    if n > 1: pos.pop()
                    return
                self.__backtrack(ans, n, pos, y+1)
        if y != 0: pos.pop()
        return

    def __is_valid(self, pos: "List[int]",
                    x: "int", y: "int") -> "bool":
        for i in range(y):
            if pos[i] == x: return False
            if pos[i] == x + y - i: return False
            if pos[i] == x - y + i: return False
        return True


def main():
    test = NQueensII()
    print(test.totalNQueens(4))
    print(test.totalNQueens(1))
    print(test.totalNQueens(3))

if __name__ == "__main__":
    main()
