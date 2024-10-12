# -*- coding: utf-8 -*-

from typing import List
import heapq

class KthLargestElementinanArray:
    def findKthLargest1(self, nums: "List[int]", k: "int") -> "int":
        nums.sort(reverse=True)
        return nums[k - 1]

    def findKthLargest2(self, nums: "List[int]", k: "int") -> "int":
        pass

    def findKthLargest3(self, nums: "List[int]", k: "int") -> "int":
        """
        with PQ
        """
        pq = []
        for num in nums:
            if len(pq) == k and pq[0] < num or len(pq) < k:
                heapq.heappush(pq, num)
                if len(pq) > k:
                    heapq.heappop(pq)
        # print(pq)
        return pq[0]


def main():
    test = KthLargestElementinanArray()
    print(test.findKthLargest1([2, 3, 1, 5, 4], 2))
    print(test.findKthLargest3([2, 3, 1, 5, 4], 2))

if __name__ == "__main__":
    main()
