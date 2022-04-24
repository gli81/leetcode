# -*- coding: utf-8 -*-

class RemoveDuplicatesfromSortedArray:
    def removeDuplicates(self, nums: list[int]) -> int:
        '''
        returns the length of list with distinct elements
        '''
        if len(nums) == 0: return 0
        i = 1 ## the count
        for j in range(1, len(nums)):
            if nums[j] != nums[i - 1]:
                i += 1
                nums[i - 1] = nums[j]
        return i

def main():
    print(RemoveDuplicatesfromSortedArray().removeDuplicates([1, 1, 2]))

if __name__ == "__main__":
    main()
