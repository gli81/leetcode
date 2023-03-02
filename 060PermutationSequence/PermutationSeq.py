# -*- coding:utf-8 -*-

from typing import List
import math

class PermutationSeq:
    def getPermutation(self, n: "int", k: "int") -> "str":
        nums = list(range(1, n + 1))
        return self.__get_ans(nums, n, k)

    
    def __get_ans(self, nums: "List[int]",
                  n: "int", k: "int") -> "str":
        if n == 1: return str(nums[0])
        len_group = math.factorial(n - 1)
        group = (k - 1) // len_group
        num = nums[group]
        nums.pop(group)
        k = k % len_group
        return str(num) + self.__get_ans(nums, n - 1, k)
    



def main():
    test = PermutationSeq()
    print(test.getPermutation(3, 1))
    print(test.getPermutation(3, 2))
    print(test.getPermutation(3, 3))
    print(test.getPermutation(4, 9))


if __name__ == "__main__":
    main()
