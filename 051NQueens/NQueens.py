# -*- coding: utf-8 -*-

from typing import List

class NQueens():
    def solveNQueens(self, n: "int") -> "List[List[str]]":
        ans = []
        self.__backtrack2(n, ans, [])
        # self.__backtrack([], ans, 0, n)
        return ans

    def __backtrack(
        self,
        pos: "List[int]",
        ans: "List[List[str]]",
        y: "int",
        n: "int"
    ) -> "None":
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
    
    def __is_valid(
        self, pos: "List[int]",
        x: "int",
        y: "int"
    ) -> "bool":
        for i in range(y):
            if pos[i] == x: return False
            if pos[i] == x + y - i: return False
            if pos[i] == x - y + i: return False
        return True
    
    def __backtrack2(self, n, ans, cur):
        for i in range(n):
            if self.__is_valid2(cur, i):
                cur.append(i)
                if len(cur) == n:
                    tmp_list = []
                    for j in range(n):
                        tmp = ['.'] * n
                        tmp[cur[j]] = 'Q'
                        tmp_list.append(''.join(tmp))
                    ans.append(tmp_list[:])
                    cur.pop()
                    if n > 1: cur.pop()
                    return
                self.__backtrack2(n, ans, cur)
        if cur: cur.pop()

    def __is_valid2(self, cur: "List[int]", x: "int"):
        n = len(cur)
        for i in range(n):
            ## check row
            if cur[i] == x: return False
            if x - n + i >= 0 and cur[i] == x - n + i: return False ## diagonal
            if cur[i] == x + n - i: return False
        return True


def main():
    test: "NQueens" = NQueens()
    print(test.solveNQueens(1))
    print(test.solveNQueens(4))
    print(test.solveNQueens(9))
    # print(test.is_valid2([1], 0))

if __name__ == "__main__":
    main()
