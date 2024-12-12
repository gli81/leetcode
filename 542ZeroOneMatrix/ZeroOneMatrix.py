# -*- coding: utf-8 -*-

from typing import List
from sys import maxsize

class ZeroOneMatrix:
    def updateMatrix(
        self,
        mat: "List[List[int]]"
    ) -> "List[List[int]]":
        rows = len(mat)
        cols = len(mat[0])
        ans = [[0] * cols for _ in range(rows)]
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] != 0: ans[i][j] = maxsize
        for i in range(rows):
            for j in range(cols):
                if i - 1 >= 0:
                    ans[i][j] = min(
                        ans[i][j], ans[i - 1][j] + 1
                    )
                if j - 1 >= 0:
                    ans[i][j] = min(
                        ans[i][j], ans[i][j - 1] + 1
                    )
        for i in range(rows - 1, -1, -1):
            for j in range(cols):
                if i + 1 < rows:
                    ans[i][j] = min(
                        ans[i][j], ans[i + 1][j] + 1
                    )
                if j - 1 >= 0:
                    ans[i][j] = min(
                        ans[i][j], ans[i][j - 1] + 1
                    )
        for i in range(rows):
            for j in range(cols - 1, -1, -1):
                if i - 1 >= 0:
                    ans[i][j] = min(
                        ans[i][j], ans[i - 1][j] + 1
                    )
                if j + 1 < cols:
                    ans[i][j] = min(
                        ans[i][j], ans[i][j + 1] + 1
                    )
        for i in range(rows - 1, -1, -1):
            for j in range(cols - 1, -1, -1):
                if i + 1 < rows:
                    ans[i][j] = min(
                        ans[i][j], ans[i + 1][j] + 1
                    )
                if j + 1 < cols:
                    ans[i][j] = min(
                        ans[i][j], ans[i][j + 1] + 1
                    )
        return ans



def main():
    test = ZeroOneMatrix()
    print(test.updateMatrix([
        [0, 0, 0],
        [0, 1, 0],
        [0, 0, 0]
    ]))
    print(test.updateMatrix([
        [0, 0, 0],
        [0, 1, 0],
        [1, 1, 1]
    ]))

if __name__ == "__main__":
    main()
