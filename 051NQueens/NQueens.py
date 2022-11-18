# -*- coding: utf-8 -*-

from typing import List

class NQueens():
    def solveNQueens(self, n: "int") -> "List[List[str]]":
        ans = []
        self.__backtrack(ans, n)
        return ans

    def __backtrack(self, ans: "List[List[str]]", n: "int") -> "None":
        for col in range(n):
            pass

def main():
    test: "NQueens" = NQueens()
    print(test.solveNQueens(1))
    print(test.solveNQueens(4))
    print(test.solveNQueens(9))

if __name__ == "__main__":
    main()
