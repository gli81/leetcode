# -*- coding: utf-8 -*-

from typing import List

class ProductofArrayExceptSelf:
    def productExceptSelf(self,
                          nums: "List[int]")\
                          -> "List[int]":
        left = [1 for _ in range(len(nums))]
        right = [1] * len(nums)
        ans = [1] * len(nums)
        for i in range(1, len(nums)):
            left[i] = left[i - 1] * nums[i - 1]
            right[len(nums) - i - 1] =\
                right[len(nums) - i] *\
                    nums[len(nums) - i]
        for i in range(len(nums)):
            ans[i] = left[i] * right[i]
        return ans


def main():
    test = ProductofArrayExceptSelf()
    print(test.productExceptSelf([1, 2, 3, 4]))
    print(test.productExceptSelf([-1, 1, 0, -3, 3]))

if __name__ == "__main__":
    main()
