# -*- coding:utf-8 -*-

from typing import List

class SpiralMatrix:
    def generateMatrix(self, n: "int") -> "List[List[int]]":
        # if n == 0: return []
        ans = [[0] * n for _ in range(n)]
        # print(ans)
        x = y = 0
        right_border = bottom_border = n - 1
        left_border = top_border = 0
        cur_dir = 'r'
        num = 1
        while num <= n * n:
            ans[x][y] = num
            if cur_dir == 'r':
                if y < right_border:
                    y += 1
                else:
                    cur_dir = 'd'
                    # y -= 1
                    x += 1
                    top_border += 1
            elif cur_dir == 'd':
                if x < bottom_border:
                    x += 1
                else:
                    cur_dir = 'l'
                    # x -= 1
                    y -= 1
                    right_border -= 1
            elif cur_dir == 'l':
                if y > left_border:
                    y -= 1
                else:
                    cur_dir = 'u'
                    # y += 1
                    x -= 1
                    bottom_border -= 1
            elif cur_dir == 'u':
                if x > top_border:
                    x -= 1
                else:
                    cur_dir = 'r'
                    # x += 1
                    y += 1
                    left_border += 1
            num += 1
        return ans


def main():
    test = SpiralMatrix()
    for arr in test.generateMatrix(3):
        print(arr)
    for arr in test.generateMatrix(1):
        print(arr)
    for arr in test.generateMatrix(20):
        print(arr)


if __name__ == "__main__":
    main()
