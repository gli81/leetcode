# -*- coding: utf-8 -*-

class Solution:
    def searchRange(self, nums: list[int], target: int) -> list[int]:
        ans = [-1, -1]
        if len(nums) == 0:
            return ans
        ## binary search
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
        ## end of loop, left is pointing at the start position
        if left == len(nums) or nums[left] != target:
            return ans
        ans[0] = left
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                left = mid + 1
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        ans[1] = right
        return ans


def main():
    print(Solution().searchRange([5,7,7,8,8,10], 8))
    print(Solution().searchRange([5,7,7,8,8,10], 6))
    print(Solution().searchRange([], 0))

if __name__ == "__main__":
    main()
