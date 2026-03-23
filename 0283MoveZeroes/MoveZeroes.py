# -*- coding: utf-8 -*-

from typing import List

class MoveZeros:
    def moveZeros(self, nums: "List[int]") -> "None":
        stk_0 = []
        q = []
        for num in nums:
            if num == 0:
                stk_0.append(0)
            else:
                q.append(num)
        i = 0
        while i < len(nums):
            if q:
                nums[i] = q.pop(0)
            else:
                nums[i] = 0
            i += 1


def main():
    test = MoveZeros()
    t1 = [0, 1, 0, 3, 12]
    test.moveZeros(t1)
    print(t1)

if __name__ == "__main__":
    main()
