# -*- coding: utf -8-*-

from typing import List

class SearchinRotatedSortedArrayII:
    def search(self, nums: "List[int]", target: "int") -> "bool":
        start = 0
        end = len(nums) - 1
        while start <= end:
            mid = (start + end) // 2
            if nums[mid] == target: return True
            if nums[start] < nums[mid]:
                ## left sorted
                if target in range(nums[start], nums[mid]):
                    end = mid - 1
                else: start = mid + 1
            elif nums[start] > nums[mid]:
                ## left not sorted, then right sorted
                if target in range(nums[mid], nums[end] + 1):
                    start = mid + 1
                else: end = mid - 1
            ## still don't understand
            else: start += 1
        return False                


def main():
    test = SearchinRotatedSortedArrayII()
    print(test.search([2,5,6,0,0,1,2], 0))
    print(test.search([2,5,6,0,0,1,2], 3))
    print(test.search([5, 1, 3], 3))

if __name__ == "__main__":
    main()
