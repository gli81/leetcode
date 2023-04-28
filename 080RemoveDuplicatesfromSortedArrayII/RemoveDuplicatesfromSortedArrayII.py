# -*- coding: utf -8-*-

from typing import List

class RemoveDuplicatesfromSortedArrayII:
    def removeDuplicates(self, nums: "List[int]") -> "int":
        slow = 0
        fast = 1
        ct = 1
        max_ = 2
        while fast < len(nums):
            if nums[fast] != nums[slow]:
                slow += 1
                nums[slow] = nums[fast]
                ct = 1
            else:
                if ct < max_:
                    slow += 1
                    nums[slow] = nums[fast]
                    ct += 1
            fast += 1
        return slow + 1


def main():
    test = RemoveDuplicatesfromSortedArrayII()
    print(test.removeDuplicates([1, 1, 1, 2, 2, 3]))
    print(test.removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3]))

if __name__ == "__main__":
    main()
