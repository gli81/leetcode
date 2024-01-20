# -*- coding: utf-8 -*-

from typing import List

class TopKFrequentElements:
    def topKFrequent(
        self,
        nums: "List[int]",
        k: "int"
    ) -> "List[int]":
        ct = {}
        for num in nums:
            if not num in ct:
                ct[num] = 0
            ct[num] += 1
        nums.sort()
        nums.sort(key=lambda x:ct[x], reverse=True)
        prev = nums[0] - 1
        cur_ct = 0
        cur = 0
        ans = []
        while cur_ct < k:
            if prev != nums[cur]:
                prev = nums[cur]
                ans.append(nums[cur])
                cur_ct += 1
            cur += 1
            # print(f"{ans}, cur_ct: {cur_ct}")
        return ans


def main():
    test = TopKFrequentElements()
    print(test.topKFrequent([1, 1, 1, 2, 2, 3], 2))
    print(test.topKFrequent(
        [3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6],
        10
    ))

if __name__ == "__main__":
    main()
