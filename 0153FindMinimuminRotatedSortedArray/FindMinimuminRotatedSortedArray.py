# -*- coding: utf-8 -*-

from typing import List

class FindMinimuminRotatedSortedArray:
    def findMin(self, nums: "List[int]") -> "int":
        l = 0
        r = len(nums) - 1
        while l < r:
            mid = l + (r - l) // 2
            # if nums[mid] < nums[mid - 1]:
            #     return nums[mid]
            if nums[mid] < nums[r]:
                ## get rid of right half
                r = mid
            else:
                l = mid + 1
        return nums[l]


def main():
    test = FindMinimuminRotatedSortedArray()
    print(test.findMin(
        [3, 4, 5, 1, 2]
    ))
    print(test.findMin(
        [4, 5, 6, 7, 0, 1, 2]
    ))
    print(test.findMin(
        [11, 13, 15, 17]
    ))

if __name__ == "__main__":
    main()
