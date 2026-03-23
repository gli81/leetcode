# -*- coding: utf-8 -*-

from typing import List

class MaximumProductSubarray:
    def maxProduct(self, nums: List[int]) -> int:
        """
        dp
        """
        n = len(nums)
        if n == 0: return 0
        dpMax = [0] * n
        dpMin = [0] * n
        dpMax[0] = dpMin[0] = ans = nums[0]
        for i in range(1, n):
            dpMax[i] = max(
                nums[i], dpMax[i - 1] * nums[i], dpMin[i - 1] * nums[i]
            )
            ## compare
            ## 1. nums[i] pos previous max neg
            ## 2. nums[i] pos previous pos
            ## 3. nums[i] neg previous neg
            dpMin[i] = min(
                nums[i], dpMin[i - 1] * nums[i], dpMax[i - 1] * nums[i]
            )
            ## compare
            ## 1. nums[i] neg previous min pos
            ## 2. nums[i] pos previous pos
            ## 3. nums[i] neg previous neg
            ans = max(ans, dpMax[i])
        return ans


def main():
    test = MaximumProductSubarray()

if __name__ == "__main__":
    main()
