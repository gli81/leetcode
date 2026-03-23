# -*- coding: utf-8 -*-

from typing import List

class FindAllNumbersDisappearedinanArray:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        s = set(range(1, n + 1))
        for num in nums:
            if num in s:
                s.remove(num)
        return list(s)


def main():
    test = FindAllNumbersDisappearedinanArray()

if __name__ == "__main__":
    main()
