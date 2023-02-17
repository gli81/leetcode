# -*- coding: utf-8 -*-

class FourSum:
    def fourSum(self, nums: list[int],
                target: int) -> list[list[int]]:
        nums.sort()
        ans = []
        for i in range(len(nums) - 3):
            if i == 0 or nums[i] != nums[i - 1]:
                for j in range(i + 1, len(nums) - 2):
                    if j == i + 1 or nums[j] != nums[j - 1]:
                        lo = j + 1
                        hi = len(nums) - 1
                        looking = target - nums[j] - nums[i]
                        while lo < hi:
                            if nums[lo] + nums[hi] == looking:
                                ans.append([nums[i], nums[j], nums[lo], nums[hi]])
                                while lo < hi and nums[lo] == nums[lo + 1]:
                                    lo += 1
                                while lo < hi and nums[hi] == nums[hi - 1]:
                                    hi -= 1
                                lo += 1
                                hi -= 1
                            elif nums[lo] + nums[hi] < looking:
                                lo += 1
                            elif nums[lo] + nums[hi] > looking:
                                hi -= 1
        return ans


def main():
    # print(FourSum().fourSum([1,0,-1,0,-2,2], 0))
    # print(FourSum().fourSum([2,2,2,2,2], 8))
    print(FourSum().fourSum([-2,-1,-1,1,1,2,2], 0))

if __name__ == "__main__":
    main()