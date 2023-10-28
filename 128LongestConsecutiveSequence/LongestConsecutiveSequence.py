# -*- coding: utf-8 -*-

from typing import List

class LongestConsecutiveSequence:
    def longestConsecutive(self,
                           nums: "List[int]") -> "int":
        ## 用一个set记录都有哪些数字
        record = set()
        for num in nums:
            record.add(num)
        maxx = 0
        ## 遍历nums，如果nums[i] - 1在set里
        ## 那nums[i]已经在计算nums[i] - 1的interval时
        ## 数过了
        ## 如果不在
        ## nums[i]开始找，尝试更新maxx
        for num in nums:
            tryit = num
            if not tryit - 1 in record:
                count = 0
                while tryit in record:
                    count += 1
                    tryit += 1
                maxx = max(maxx, count)
        return maxx


def main():
    test = LongestConsecutiveSequence()
    print(
        test.longestConsecutive([100, 4, 200, 1, 3, 2])
    )

if __name__ == "__main__":
    main()
