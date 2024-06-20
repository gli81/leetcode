# -*- coding: utf-8 -*-

from typing import List

class SearchinRotatedSortedArray:
    def search3(
        self,
        nums: "List[int]",
        target: "int"
    ) -> "int":
        left = 0
        right = len(nums) - 1
        while left <= right:
            ## binary search
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            ## split the list into two lists
            ## one sublist would be sorted
            if nums[left] <= nums[mid]:
                ## the left sublist is sorted
                ## the right one not
                if nums[left] <= target < nums[mid]:
                    ## target is in the left sublist
                    ## do binary search here
                    right = mid - 1
                else:
                    ## target not in the sorted sublist
                    ## focus on the other half
                    ## split it in to two sublists
                    ## and check the sorted half
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1

def main():
    print(SearchinRotatedSortedArray().search3(
        [4, 5, 6, 7, 0, 1, 2], 0
    ))
    print(SearchinRotatedSortedArray().search3(
        [4, 5, 6, 7, 0, 1, 2], 3
    ))
    print(SearchinRotatedSortedArray().search3(
        [1], 0
    ))

if __name__ == "__main__":
    main()