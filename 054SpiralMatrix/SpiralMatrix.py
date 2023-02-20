# -*- coding: utf-8 -*-

from typing import List

class SpiralMatrix:
    def spiralOrder(self,
           matrix: "List[List[int]]") -> "List[int]":
        ans = []
        n = len(matrix)
        if n == 0: return ans
        m = len(matrix[0])
        x = y = 0
        top_border = left_border = -1
        right_border = m
        down_border = n
        current_dir = 'r'
        while True:
            if len(ans) == m * n: return ans
            ans.append(matrix[y][x])
            if current_dir == 'r':
                if x == right_border - 1:
                    current_dir = 'd'
                    y += 1
                    top_border += 1
                else:
                    x += 1
            elif current_dir == 'd':
                if y == down_border - 1:
                    current_dir = 'l'
                    x -= 1
                    right_border -= 1
                else:
                    y += 1
            elif current_dir == 'l':
                if x == left_border + 1:
                    current_dir = 'u'
                    y -= 1
                    down_border -= 1
                else:
                    x -= 1
            elif current_dir == 'u':
                if y == top_border + 1:
                    current_dir = 'r'
                    x += 1
                    left_border += 1
                else:
                    y -= 1



def main():
    test = SpiralMatrix()
    print(test.spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))


if __name__ == "__main__":
    main()
