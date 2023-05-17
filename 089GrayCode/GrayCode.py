# -*- coding: utf -8-*-

from typing import List

class GrayCode:
    def grayCode(self, n: "int") -> "List[int]":
        ans = [0] ## ans for n = 0
        for i in range(n):
            for j in range(len(ans) - 1, -1, -1):
                ans.append(ans[j] + (1 << (i)))
        return ans


def main():
    test = GrayCode()
    print(test.grayCode(1))
    print(test.grayCode(2))

if __name__ == "__main__":
    main()
 