# -*- coding: utf-8 -*-

from typing import List
import sys

class MaxSubarray:
    def maxSubArray1(self, nums: "List[int]") -> "int":
        '''
        over time limit, fuck
        '''
        ans = -sys.maxsize - 1
        n: "int" = len(nums)
        # dp = [[-sys.maxsize - 1] * len(nums)] * len(nums)
        dp = [[(-sys.maxsize - 1) for i in range(n)]\
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
        with just one array (*list)
        will not work, just save space =_=
        '''
        ans = -sys.maxsize - 1
        n: "int" = len(nums)
        dp = [(-sys.maxsize - 1) for _ in range(n)]
        for i in range(n):
            dp[0] = nums[i]
            if dp[0] > ans: ans = dp[0]
            for j in range(1, n - i):
                dp[j] = dp[j - 1] + nums[j + i]
                if dp[j] > ans: ans = dp[j]
        return ans
    
    def maxSubArray3(self, nums: "List[int]") -> "int":
        '''
        AC
        '''
        ans = nums[0]
        n = len(nums)
        dp = [nums[0] for _ in range(n)]
        for i in range(1, n):
            dp[i] = nums[i] if dp[i - 1] <= 0 \
                            else dp[i - 1] + nums[i]
            ans = dp[i] if dp[i] > ans else ans
        return ans


def main():
    test = MaxSubarray()
    print(test.maxSubArray3([-2, 1, -3, 4, -1, 2, 1, -5, 4]))


if __name__ == "__main__":
    main()
