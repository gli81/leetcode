# -*- coding: utf-8 -*-

from typing import List
import heapq

class LastStoneWeight:
    def lastStoneWeight(
        self,
        stones: "List[int]"
    ) -> "int":
        ## store negative to simulate maxPQ
        pq = [-st for st in stones]
        heapq.heapify(pq)
        while len(pq) > 1:
            one = -heapq.heappop(pq)
            two = -heapq.heappop(pq)
            if one != two:
                heapq.heappush(pq, -abs(one - two))
        return 0 if len(pq) == 0 else -pq[0]


def main():
    test = LastStoneWeight()

if __name__ == "__main__":
    main()
