# -*- coding: utf -8-*-

from typing import List

class RemoveDuplicatesfromSortedArrayII:
    def removeDuplicates1(self, nums: "List[int]") -> "int":
        slow = 0
        fast = 1
        ct = 1
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                nums[slow] = nums[fast]
                ct = 1
            else:
                if ct == 1:
                    slow += 1
                    nums[slow] = nums[fast]
                    ct += 1
            fast += 1
        return slow + 1

    def removeDuplicates2(self, nums: "List[int]") -> "int":
        i = 0
        for n in nums:
            if i < 2 or n > nums[i-2]:
                nums[i] = n
                i += 1
        return i


def main():
    test = RemoveDuplicatesfromSortedArrayII()
    print(test.removeDuplicates2([1, 1, 1, 2, 2, 3]))
    print(test.removeDuplicates2([0, 0, 1, 1, 1, 1, 2, 3, 3]))

if __name__ == "__main__":
    main()
