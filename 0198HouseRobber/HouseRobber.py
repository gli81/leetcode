# -*- coding: utf-8 -*-

from typing import List

class HouseRobber:
    def rob(self, nums: "List[int]") -> "int":
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], nums[i] + dp[i - 2])
        return dp[-1]


def main():
    test = HouseRobber()
    print(test.rob(
        [1, 1, 3, 3]
    ))
    print(test.rob(
        [2, 9, 8, 3, 6]
    ))

if __name__ == "__main__":
    main()
