# -*- coding: utf-8 -*-

from typing import List

class ThreeSum:
    def threeSum(self, nums: "List[int]") ->\
                 "List[List[int]]":
        ## sort first
        nums.sort()
        ans = []
        for i in range(len(nums) - 2):
            ## find three num,
            ## so the last one you should check is
            ## the last but three num
            ## check if it add the last two nums
            ## equals to zero
            if (i == 0 or (i > 0 and\
                           nums[i] != nums[i - 1])):
            ## no equal nums so if num
            ## already in the triplet,
            ## don't check another num
            ## sorted list, so if a num equals
            ## the num before, it is a replicated num
                hi = len(nums) - 1
                lo = i + 1
                looking = -nums[i]
                ## try to find two nums that add up to 0 - nums[i]
                while lo < hi:
                    if nums[hi] + nums[lo] == looking:
                        ## find that combination
                        ans.append([nums[i], nums[lo], nums[hi]])
                        while lo < hi and nums[lo] == nums[lo + 1]: lo += 1
                        while lo < hi and nums[hi] == nums[hi - 1]: hi -= 1
                        ## moving lo and hi to the next different num, to avoid same triplet appearing in result
                        lo += 1
                        hi -= 1
                        ## when nums[lo] != nums[lo + 1], nums[lo] is the last same num of last check
                    elif nums[hi] + nums[lo] < looking:
                        lo += 1
                    else:
                        hi -= 1
        return ans



def main():
    print(ThreeSum().threeSum([-1,0,1,2,-1,-4]))
    

if __name__ == "__main__":
    main()