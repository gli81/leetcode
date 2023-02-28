# -*- coding:utf-8 -*-

from typing import List

class SpiralMatrix:
    def generateMatrix(self, n: "int") -> "List[List[int]]":
        ans = [[0] * n for _ in range(n)]
        


def main():
    test = SpiralMatrix()
    print(test.generateMatrix(3))
    print(test.generateMatrix(1))


if __name__ == "__main__":
    main()
