# -*- coding: utf-8 -*-

from typing import List

class SquaresofaSortedArray:
    def sortedSquares(self,
                      nums: "List[int]") -> "List[int]":
        ans = [num ** 2 for num in nums]
        ans.sort()
        ## WORK ON QUICK SORT TMR
        return ans

    def sortedSquares2(self,
                       nums: "List[int]") -> "List[int]":
        ## corner cases
        ## 全负数
        if nums[len(nums) - 1] <= 0:
            nums.reverse()
            return [num ** 2 for num in nums]
        ## 全正数
        if nums[0] >= 0:
            return [num ** 2 for num in nums]
        ## 找分界线
        split = -1
        for i in range(len(nums)):
            if nums[i] >= 0:
                split = i - 1
                break
        i = split
        j = split + 1
        ans = []
        while i >= 0 or j < len(nums):
            ## 要先处理一头已经走完的情况
            if i < 0:
                ans.append(nums[j] ** 2)
                j += 1
            elif j >= len(nums):
                ans.append(nums[i] ** 2)
                i -= 1
            elif nums[i] ** 2 < nums[j] ** 2:
                ans.append(nums[i] ** 2)
                i -= 1
            # elif nums[i] ** 2 >= nums[j] ** 2:
            else:
                ans.append(nums[j] ** 2)
                j += 1
        return ans


def main():
    test = SquaresofaSortedArray()

if __name__ == "__main__":
    main()
