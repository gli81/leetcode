# -*- coding: utf-8 -*-

from typing import List

class SubarrayswithKDifferentIntegers:
    def subarraysWithKDistinct(
        self,
        nums: "List[int]",
        k: "int"
    ) -> "int":
        l = 0
        d = {}
        ans = 0
        r = 0
        while r < len(nums):
            while k > 0 and r < len(nums):
                if nums[r] not in d or d[nums[r]] == 0:
                    k -= 1
                    d[nums[r]] = 0
                d[nums[r]] += 1
                r += 1
            ans += 1
            while r < len(nums):
                ans += 1
                if nums[r] in d and d[nums[r]] != 0:
                    d[nums[r]] += 1
                    r += 1
                else:
                    break
            while k == 0 and l <= r:
                ans += 1
                d[nums[l]] -= 1
                if d[nums[l]] == 0:
                    k += 1
                l += 1
        return ans


def main():
    print("abc")
    test = SubarrayswithKDifferentIntegers()
    print(test.subarraysWithKDistinct(
        [1, 2, 1, 2, 3], 2
    ))
    print(test.subarraysWithKDistinct(
        [1, 2, 1, 3, 4], 3
    ))

if __name__ == "__main__":
    main()
