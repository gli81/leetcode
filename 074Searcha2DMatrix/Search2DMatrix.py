# -*- coding: utf -8-*-

from typing import List

class Search2DMatrix:
    def searchMatrix1(self, matrix: "List[List[int]]",
                      target: "int") -> "bool":
        flat = []
        for lst in matrix:
            flat.extend(lst)
        left = 0
        right = len(flat) - 1
        while left <= right:
            mid = (left + right) // 2
            if flat[mid] == target: return True
            elif flat[mid] < target:
                left = mid + 1
            else: right = mid - 1
        return False


def main():
    test = Search2DMatrix()
    print(test.searchMatrix1([
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ], 3))
    print(test.searchMatrix1([
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ], 13))

if __name__ == "__main__":
    main()
