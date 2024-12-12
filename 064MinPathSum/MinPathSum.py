# -*- coding: utf-8 -*-

from typing import List, Dict, Tuple
import sys

class MinPathSum:
    def minPathSum(self, grid: "List[List[int]]") -> "int":
        return self.__get_ans(0, 0, len(grid) - 1,
                              len(grid[0]) - 1, {}, grid)

    def __get_ans(self, x: "int", y: "int",
                  m: "int", n: "int",
                  visited: "Dict[Tuple, int]",
                  grid : "List[List[int]]") -> "int":
        if x == m and y == n: return grid[m][n]
        n1 = n2 = sys.maxsize
        ## down
        if (x + 1, y) not in visited:
            if x + 1 <= m:
                n1 = self.__get_ans(x + 1, y, m, n,
                                    visited, grid)
        else: n1 = visited.get((x + 1, y))
        ## right
        if (x, y + 1) not in visited:
            if y + 1 <= n:
                n2 = self.__get_ans(x, y + 1, m, n,
                                    visited, grid)
        else: n2 = visited.get((x, y + 1))
        ## put
        visited[(x, y)] = min(n1, n2) + grid[x][y]
        return min(n1, n2) + grid[x][y]


    def minPathSum2(self, grid: "List[List[int]]") -> "int":
        ## last row
        m = len(grid)
        n = len(grid[0])
        ## initialize
        for i in range(n - 2, -1, -1):
            grid[m - 1][i] += grid[m - 1][i + 1]
        for i in range(m - 2, -1, -1):
            grid[i][n - 1] += grid[i + 1][n - 1]
        ## update
        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                grid[i][j] += \
                    min(grid[i + 1][j], grid[i][j + 1])
        return grid[0][0]

def main():
    test = MinPathSum()
    print(test.minPathSum2([
        [1, 3, 1],
        [1, 5, 1],
        [4, 2, 1]
    ]))
    print(test.minPathSum2([
        [1, 2, 3],
        [4, 5, 6],
    ]))


if __name__ == "__main__":
    main()
