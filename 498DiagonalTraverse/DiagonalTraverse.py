# -*- coding: utf-8 -*-

from typing import List

class DiagonalTraverse:
    def findDiagonalOrder(
        self,
        mat: "List[List[int]]"
    ) -> "List[int]":
        m, n = len(mat), len(mat[0])
        # print(m, n)
        ans = [0] * (m * n)
        ct = 0
        for i in range(m + n - 1):
            # if m >= n:
            if i % 2 == 0:
                min_ = min(i, m-1)
                ## starting from (min_, i-min_), go up right
                x = min_
                y = i-min_
                while x >= 0 and y < n:
                    # print(m, n)
                    # print(x, y)
                    # print(ct)
                    ans[ct] = mat[x][y]
                    ct += 1
                    x -= 1
                    y += 1
            else:
                min_ = min(i, n-1)
                ## starting from (i-min_, min_), go bottom left
                x = i-min_
                y = min_
                while x < m and y >= 0:
                    # print(m, n)
                    # print(x, y)
                    # print(ct)
                    ans[ct] = mat[x][y]
                    ct += 1
                    x += 1
                    y -= 1
            # else:
            #     pass
        return ans


def main():
    test = DiagonalTraverse()
    print(test.findDiagonalOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
    print(test.findDiagonalOrder([[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]))
    print(test.findDiagonalOrder([[1, 2], [3, 4]]))
    print(test.findDiagonalOrder([[1, 2, 3, 4], [5, 6, 7, 8]]))
    print(test.findDiagonalOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9], [10, 11, 12]]))

if __name__ == "__main__":
    main()
