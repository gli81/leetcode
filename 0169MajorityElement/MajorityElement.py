# -*- coding: utf-8 -*-

from typing import List

class MajorityElement:
    def majorityElement(self, nums: "List[int]")\
            -> "int":
        d = {}
        for num in nums:
            d[num] = d.get(num, 0) + 1
        for num in nums:
            if d[num] > len(nums) // 2:
                return num


def main():
    test = MajorityElement()
    print(test.majorityElement([2, 2, 1, 1, 1, 2, 2]))

if __name__ == "__main__":
    main()

