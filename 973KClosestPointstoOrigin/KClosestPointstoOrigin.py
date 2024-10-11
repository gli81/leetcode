# -*- coding: utf-8 -*-

from typing import List
import heapq

class KClosestPointstoOrigin:
    def kClosest(
        self,
        points: "List[List[int]]",
        k: "int"
    ) -> "List[List[int]]":
        pq = []
        for p in points:
            # print((p[0]**2 + p[1]**2)**0.5)
            heapq.heappush(pq, ((p[0]**2 + p[1]**2)**0.5, p))
        ans = []
        for _ in range(k):
            ans.append(heapq.heappop(pq)[1])
        return ans


def main():
    test = KClosestPointstoOrigin()
    print(test.kClosest(
        [
            [0, 2],
            [2, 2]
        ],
        1
    ))
    print(test.kClosest(
        [
            [3, 3],
            [5, -1],
            [-2, 4]
        ],
        2
    ))

if __name__ == "__main__":
    main()
