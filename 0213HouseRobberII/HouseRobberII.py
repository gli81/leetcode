# -*- coding: utf-8 -*-

from typing import List

class HouseRobberII:
    def rob(self, nums: "List[int]") -> "int":
        return max(
            self.__robHelper(nums, 0, len(nums) - 1),
            self.__robHelper(nums, 1, len(nums))
        )

    def __robHelper(
        self, nums: "List[int]", start: "int", end: "int"
    ) -> "int":
        if end - start == -1: return 0
        if end - start == 0: return nums[0] ## len(nums) == 1
        if end - start == 1: return nums[start]
        dp = [0] * (end - start)
        dp[0] = nums[start]
        dp[1] = max(dp[0], nums[start + 1])
        for i in range(2, end - start):
            dp[i] = max(dp[i - 2] + nums[i + start], dp[i - 1])
        return dp[-1]


def main():
    test = HouseRobberII()
    print(test.rob([3, 4, 3]))
    print(test.rob([]))
    print(test.rob([1]))
    print(test.rob([1, 1]))
    print(test.rob([1, 2]))
    print(test.rob([1, 2, 1, 1]))
    print(test.rob([2, 9, 8, 3, 6]))

if __name__ == "__main__":
    main()
