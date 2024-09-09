# -*- coding: utf-8 -*-

from typing import List

class NQueens():
    def solveNQueens(self, n: "int") -> "List[List[str]]":
        ans = []
        self.__backtrack([], ans, 0, n)
        return ans

    def __backtrack(self, pos: "List[int]",
                    ans: "List[List[str]]",
                    y: "int", n: "int") -> "None":
        for row in range(n):
            if self.__is_valid(pos, row, y):
                pos.append(row)
                if len(pos) == n:
                    tmp_list = []
                    for col in range(n):
                        tmp = ['.'] * n
                        tmp[pos[col]] = 'Q'
                        tmp = ''.join(tmp)
                        tmp_list.append(tmp[:])
                    ans.append(tmp_list[:])
                    pos.pop()
                    if n > 1: pos.pop()
                    return
                self.__backtrack(pos, ans, y + 1, n)
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
    test: "NQueens" = NQueens()
    print(test.solveNQueens(1))
    print(test.solveNQueens(4))
    # print(test.solveNQueens(9))

if __name__ == "__main__":
    main()
