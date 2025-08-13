# -*- coding: utf-8 -*-

from typing import List

class TargetSum:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        """
        backtrack
        """
        self.__ans = 0
        self.__backtrack(nums, target, 0, 0)
        return self.__ans

    def __backtrack(
        self, nums: List[int], target: int, i: int, sum_: int
    ) -> None:
        ## ending condition
        if i == len(nums):
            if sum_ == target:
                self.__ans += 1
        else:
            self.__backtrack(nums, target, i + 1, sum_ + nums[i])
            self.__backtrack(nums, target, i + 1, sum_ - nums[i])


def main():
    test = TargetSum()

if __name__ == "__main__":
    main()
