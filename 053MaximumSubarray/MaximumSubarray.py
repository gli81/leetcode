# -*- coding: utf-8 -*-

from typing import List
import sys

class MaxSubarray:
    def maxSubArray1(self, nums: "List[int]") -> "int":
        '''
        over time limit, fuck
        '''
        # dp = [[-sys.maxsize - 1] * len(nums)] * len(nums)
        ans = -sys.maxsize - 1
        n: "int" = len(nums)
        dp = [[(-sys.maxsize - 1) for i in range(len(nums))]\
            for _ in range(n)]
        for i in range(n):
            dp[i][0] = nums[i]
            if dp[i][0] > ans: ans = dp[i][0]
            for j in range(1, n - i):
                dp[i][j] = dp[i][j - 1] + nums[j + i]
                if dp[i][j] > ans: ans = dp[i][j]
        # print(dp)
        return ans
    
    def maxSubArray2(self, nums: "List[int]") -> "int":
        '''
        over time limit, fuck
        '''
        # dp = [[-sys.maxsize - 1] * len(nums)] * len(nums)
        ans = -sys.maxsize - 1
        n: "int" = len(nums)
        dp = [[(-sys.maxsize - 1) for i in range(len(nums))]\
            for _ in range(n)]
        for i in range(n):
            dp[i][0] = nums[i]
            if dp[i][0] > ans: ans = dp[i][0]
            for j in range(1, n - i):
                dp[i][j] = dp[i][j - 1] + nums[j + i]
                if dp[i][j] > ans: ans = dp[i][j]
        # print(dp)
        return ans


def main():
    test = MaxSubarray()
    print(test.maxSubArray2([-2, 1, -3, 4, -1, 2, 1, -5, 4]))


if __name__ == "__main__":
    main()
