# -*- coding: utf -8-*-

from typing import List
import copy

class SetMatrixZeros:
    def setZeros1(self, matrix: "List[List[int]]") \
           -> "List[List[int]]":
        ans = copy.deepcopy(matrix)
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    for k in range(len(matrix[0])):
                        ans[i][k] = 0
                    for k in range(len(matrix)):
                        ans[k][j] = 0
        return ans

    def setZeros2(self, matrix: "List[List[int]]") \
                -> "None":
        r_zeros = []
        c_zeros = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    r_zeros.append(i)
                    c_zeros.append(j)
        for row in r_zeros:
            for _ in range(len(matrix[0])):
                matrix[row][_] = 0
        for col in c_zeros:
            for _ in range(len(matrix)):
                matrix[_][col] = 0


def main():
    test = SetMatrixZeros()
    print(test.setZeros2([
        [1, 1, 1],
        [1, 0, 1],
        [1, 1, 1]
    ]))
    print(test.setZeros2([
        [0, 1, 2, 0],
        [3, 4, 5, 2],
        [1, 3, 1, 5]
    ]))

if __name__ == "__main__":
    main()
