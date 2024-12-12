# -*- coding: utf-8 -*-

from typing import List

class SubarraySumEqualsK:
    def subarrySum1(self,
                   nums: "List[int]",
                   k: "int") -> "int":
        """
        后一半相当于brute force\n
        结果就是超时了:-)
        """
        ## 前缀和+哈希表
        ## 截止到当前元素的和
        ## 两个index之间的差
        ## 表示两个index之间的所有元素的和
        n = len(nums)
        presum = [nums[0]] * (n + 1)
        presum[0] = 0
        for i in range(1, n):
            presum[i + 1] = presum[i] + nums[i]
        # print(presum)
        ans = 0
        for i in range(n):
            for j in range(i + 1, n + 1):
                if presum[j] - presum[i] == k:
                    ans += 1
        return ans

    def subarrySum2(self,
                   nums: "List[int]",
                   k: "int") -> "int":
        """
        我用hashmap行了吧
        """
        ## 前缀和+哈希表
        ## 截止到当前元素的和
        ## 两个index之间的差
        ## 表示两个index之间的所有元素的和
        n = len(nums)
        presum = [nums[0]] * n
        for i in range(1, n):
            presum[i] = presum[i - 1] + nums[i]
        ans = 0
        mapp = {0 : 1}
        for i in range(n):
            if presum[i] - k in mapp:
                ans += mapp[presum[i] - k]
            mapp[presum[i]] = mapp.get(presum[i], 0) + 1
        return ans


def main():
    test = SubarraySumEqualsK()
    print(test.subarrySum1([1, 1, 1], 2))

if __name__ == "__main__":
    main()
