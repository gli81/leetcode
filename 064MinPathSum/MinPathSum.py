# -*- coding: utf-8 -*-

from typing import List

class MinPathSum:
    def minPathSum(self, grid: "List[List[int]]") -> "int":
        pass


def main():
    test = MinPathSum()
    print(test.minPathSum([
        [1, 3, 1],
        [1, 5, 1],
        [4, 2, 1]
    ]))
    print(test.minPathSum([
        [1, 2, 3],
        [4, 5, 6],
    ]))


if __name__ == "__main__":
    main()
