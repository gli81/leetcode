# -*- coding: utf-8 -*-

from typing import List

class RotateImage():
    def rotate(self, matrix: "List[List[int]]") -> "None":
        ## diagonal swap, aka transpose
        for i in range(len(matrix)):
            for j in range(i):
                matrix[i][j], matrix[j][i] =\
                    matrix[j][i], matrix[i][j]
        # print(matrix)
        ## horizontal swap
        for i in range(len(matrix[0]) // 2):
            for j in range(len(matrix)):
                matrix[j][i],\
                    matrix[j][len(matrix[0]) - i - 1] =\
                        matrix[j][len(matrix[0]) - i - 1],\
                            matrix[j][i]
        # print(matrix)


def main():
    test = RotateImage()
    test1 = [
        [1, 2, 3, ],
        [4, 5, 6, ],
        [7, 8, 9, ],
    ]
    test.rotate(test1)
    for row in test1:
        print(row)

if __name__ == "__main__":
    main()
