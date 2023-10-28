# -*- coding: utf-8 -*-

from typing import List

class BinarySearch:
    def search(self, nums: "List[int]",
               target: "int") -> "int":
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                l = mid + 1
            else:
                r = mid - 1
        return -1


def main():
    test = BinarySearch()
    print(test.search([-1, 0, 3, 5, 9, 12], 9))

if __name__ == "__main__":
    main()
