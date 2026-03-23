# -*- coding: utf-8 -*-

from typing import List

class JumpGame:
    def canJump(self, nums: "List[int]") -> "bool":
        maxP = end = 0
        for i in range(len(nums) - 1):
            if i > end: return False
            maxP = max(maxP, nums[i] + i)
            if i == end: end = maxP
        ## didn't figure out boundary
        return maxP >= len(nums) - 1


def main():
    test = JumpGame()
    print(test.canJump([2, 3, 1, 1, 4]))
    print(test.canJump([3, 2, 1, 0, 4]))


if __name__ == "__main__":
    main()
