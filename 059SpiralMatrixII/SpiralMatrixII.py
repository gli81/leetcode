# -*- coding:utf-8 -*-

from typing import List

class SpiralMatrix:
    def generateMatrix(self, n: "int") -> "List[List[int]]":
        # if n == 0: return []
        ans = [[0] * n for _ in range(n)]
        x = y = 0
        right_border = bottom_border = n
        left_border = top_border = -1
        cur_dir = 'l'



def main():
    test = SpiralMatrix()
    print(test.generateMatrix(3))
    print(test.generateMatrix(1))


if __name__ == "__main__":
    main()
