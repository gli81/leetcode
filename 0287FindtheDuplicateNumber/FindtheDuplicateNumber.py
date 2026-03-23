# -*- coding: utf-8 -*-

from typing import List

class FindtheDuplicateNumber:
    def findDuplicate2(self, nums: "List[int]") -> "int":
        s = set()
        for num in nums:
            if num in s:
                return num
            else:
                s.add(num)
        return -1

    def findDuplicate5(self, nums: "List[int]") -> "int":
        slow = fast = 0
        slow = nums[slow]
        fast = nums[nums[fast]]
        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]
        slow2 = 0
        while slow != slow2:
            slow = nums[slow]
            slow2 = nums[slow2]
        return slow


def main():
    test = FindtheDuplicateNumber()
    print(test.findDuplicate5([3, 1, 3, 4, 2]))

if __name__ == "__main__":
    main()
