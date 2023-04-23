# -*- coding: utf -8-*-

from typing import List

class SortColors:
    def sortColors1(self, nums: "List[int]") -> "None":
        zero_ct = 0
        one_ct = 0
        for num in nums:
            if num == 0: zero_ct += 1
            if num == 1: one_ct += 1
        for i in range(len(nums)):
            if zero_ct > 0:
                nums[i] = 0
                zero_ct -= 1
            elif one_ct > 0:
                nums[i] = 1
                one_ct -= 1
            else: nums[i] = 2
    
        
    def sortColors2(self, nums: "List[int]") -> "None":
        zero_pos = 0
        two_pos = len(nums) - 1
        i = 0
        while i <= two_pos:
            if nums[i] == 0:
                nums[i], nums[zero_pos] = nums[zero_pos], nums[i]
                zero_pos += 1
            elif nums[i] == 2:
                nums[two_pos], nums[i] = nums[i], nums[two_pos]
                two_pos -= 1
                i -= 1
            i += 1


def main():
    test = SortColors()
    test1 = [2, 0, 2, 1, 1, 0]
    test.sortColors2(test1)
    print(test1)
    test2 = [2, 0, 1]
    test.sortColors2(test2)
    print(test2)

if __name__ == "__main__":
    main()