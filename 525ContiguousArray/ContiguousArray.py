# -*- coding: utf-8 -*-

from typing import List

class ContiguousArray:
    def findMaxLength(self, nums: "List[int]") -> "int":
        ## 先将0都替换成-1
        ## 在每个index记录数组截止当前index的和
        ## 如果两个index的和是相同的
        ## 说明两者之间的部分和为0
        ## ==> 说明两者之间的-1和1的数量相同
        n = len(nums)
        for i in range(n):
            if nums[i] == 0: nums[i] = -1
        ## presum
        presum = [nums[0]] * n
        for i in range(1, n):
            presum[i] = presum[i - 1] + nums[i]
        # print(presum)
        first_apperance = {0 : -1}
        max_length = 0
        for i in range(n):
            if presum[i] in first_apperance:
                max_length = max(max_length, i - first_apperance[presum[i]])
            else:
                first_apperance[presum[i]] = i
        return max_length



def main():
    test = ContiguousArray()
    print(test.findMaxLength([0, 1]))

if __name__ == "__main__":
    main()
