# -*- coding: utf-8 -*-

from typing import List

class LongestConsecutiveSequence:
    def longestConsecutive(self, nums: List[int]) -> int:
        ## 用一个set记录都有哪些数字
        s = set(nums)
        ans = 0
        ## 遍历nums，如果nums[i] - 1在set里
        ## 那nums[i]已经在/将在计算nums[i] - 1的interval时数到
        ## 如果不在 从nums[i]开始找，尝试更新max_
        for num in nums:
            temp = num
            if temp - 1 not in s:
                ct = 0
                while temp in s:
                    ct += 1
                    temp += 1
                ans = max(ans, ct)
        return ans


def main():
    test = LongestConsecutiveSequence()
    print(test.longestConsecutive([100, 4, 200, 1, 3, 2]))

if __name__ == "__main__":
    main()
