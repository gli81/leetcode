# -*- coding: utf-8 -*-

from typing import List

class FirstMissingPositive():
    def firstMissingPositive1(self, nums: "List[int]") -> "int":
        n = len(nums)
        for i in range(n):
            while nums[i] > 0 and nums[i] <= n and nums[i] != nums[nums[i] - 1]:
                j = nums[i] - 1
                # print(j)
                nums[i] = nums[j]
                nums[j] = j + 1
                # nums[i], nums[nums[i] - 1] = nums[nums[i] - 1], nums[i]
        for i in range(n):
            if nums[i] != i + 1:
                return i + 1
        return n + 1    

def main():
    test = FirstMissingPositive()
    print(test.firstMissingPositive1([1, 2, 0]))
    print(test.firstMissingPositive1([3, 4, -1, 1]))
    print(test.firstMissingPositive1([7, 8, 9, 11, 12]))
    print(test.firstMissingPositive1([1, 1]))

if __name__ == "__main__":
    main()
