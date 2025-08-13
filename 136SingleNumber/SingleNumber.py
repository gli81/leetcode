# -*- coding: utf-8 -*-

from typing import List

class SingleNumber:
    def singleNumber1(self, nums: List[int]) -> int:
        d = {}
        for num in nums:
            if num in d:
                d[num] += 1
            else:
                d[num] = 1
        for num in d:
            if d[num] == 1:
                return num
        return 0

    def singleNumber2(self, nums: List[int]) -> int:
        ans = 0
        for num in nums:
            ans ^= num
        return ans


def main():
    test = SingleNumber()

if __name__ == "__main__":
    main()
