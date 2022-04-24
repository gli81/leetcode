# -*- coding: utf-8 -*-

import sys

class ThreeSumClosest:
    def threeSumClosest2(self, nums: list[int], target: int) -> int:
        nums.sort()
        diff = sys.maxsize
        ans = 0
        for i in range(len(nums) - 2):
            lo = i + 1
            hi = len(nums) - 1
            while(lo < hi):
                if abs(nums[i] + nums[lo] + nums[hi] - target) < diff:
                    ans = nums[i] + nums[lo] + nums[hi]
                    diff = abs(nums[i] + nums[lo] + nums[hi] - target)
                if diff == 0:
                    return ans
                if nums[i] + nums[lo] + nums[hi] - target > 0:
                    hi -= 1
                elif nums[i] + nums[lo] + nums[hi] - target < 0:
                    lo += 1
        return ans

def main():
    print(ThreeSumClosest().threeSumClosest2([-1,2,1,-4], 1))
    print(ThreeSumClosest().threeSumClosest2([0, 0, 0], 1))
    print(ThreeSumClosest().threeSumClosest2([-1,0,1,1,55], 3))


if __name__ == "__main__":
    main()

